package com.demo.service.impl;

import com.demo.dto.MaintenanceDTO;
import com.demo.entity.Maintenance;
import com.demo.repository.MaintenanceRepository;
import com.demo.repository.PhotosRepository;
import com.demo.service.inter.MaintenanceServiceInter;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaintenanceService implements MaintenanceServiceInter {

    private final MaintenanceRepository maintenanceRepository;

    private final PhotosRepository photosRepository;

    @Autowired
    public MaintenanceService(MaintenanceRepository maintenanceRepository, PhotosRepository photosRepository) {
        this.maintenanceRepository = maintenanceRepository;
        this.photosRepository = photosRepository;
    }

    @Override
    public List<MaintenanceDTO> getAllMaintenances()
    {
        try
        {
            List<MaintenanceDTO> maintenanceDTOList = new ArrayList<>();
            maintenanceRepository.findAll().forEach(maintenance -> {
                maintenanceDTOList.add(new MaintenanceDTO(maintenance));
            });

            return maintenanceDTOList;
        }catch (Exception ex)
        {
            return new ArrayList<>();
        }
    }

    @Override
    public MaintenanceDTO getMaintenance(int id)
    {
        try
        {
            Maintenance maintenance = maintenanceRepository.findById(id).get();
            return new MaintenanceDTO(maintenance);
        }catch (Exception e)
        {
            return new MaintenanceDTO();
        }
    }

    @Override
    public Boolean addAndUpdateMaintenance(Maintenance maintenance)
    {
        try
        {
            maintenanceRepository.save(maintenance);
            return true;
        } catch (Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean deleteMaintenance(int id)
    {
        try
        {
            Maintenance maintenance = maintenanceRepository.findById(id).get();
            maintenanceRepository.delete(maintenance);

            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }

    @Override
    public Boolean deleteMaintenanceDetail(int id)
    {
        try
        {
            Maintenance maintenance = maintenanceRepository.findById(id).get();
            maintenance.setMaintenanceDetail(null);
            maintenanceRepository.save(maintenance);

            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }

    @Override
    public Boolean deleteMaintenancePhoto(int id)
    {
        try
        {
            Maintenance maintenance = maintenanceRepository.findById(id).get();
            maintenance.getPhoto().setImages(null);
            photosRepository.save(maintenance.getPhoto());

            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }
}
