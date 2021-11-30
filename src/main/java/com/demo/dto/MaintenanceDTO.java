package com.demo.dto;

import com.demo.entity.Maintenance;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MaintenanceDTO {

    private int id;
    private String maintenanceName;
    private String maintenanceDetail;
    private PhotosDTO photosDTO;

    public MaintenanceDTO(Maintenance maintenance){
        this.id = maintenance.getId();
        this.maintenanceName = maintenance.getMaintenanceName();
        this.maintenanceDetail = maintenance.getMaintenanceDetail();
        this.photosDTO = new PhotosDTO(maintenance.getPhoto());

    }

}
