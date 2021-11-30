package com.demo.service.inter;

import com.demo.dto.MaintenanceDTO;
import com.demo.entity.Maintenance;

import java.util.List;

public interface MaintenanceServiceInter {

    List<MaintenanceDTO> getAllMaintenances();

    MaintenanceDTO getMaintenance(int id);

    Boolean addAndUpdateMaintenance(Maintenance maintenance);

    Boolean deleteMaintenance(int id);

    Boolean deleteMaintenanceDetail(int id);

    Boolean deleteMaintenancePhoto(int id);
}
