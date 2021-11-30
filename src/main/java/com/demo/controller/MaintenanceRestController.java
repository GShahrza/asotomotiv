package com.demo.controller;

import com.demo.dto.MaintenanceDTO;
import com.demo.entity.Maintenance;
import com.demo.service.inter.MaintenanceServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/maintenance")
public class MaintenanceRestController {

    private final MaintenanceServiceInter maintenanceService;
    @Autowired
    public MaintenanceRestController(MaintenanceServiceInter maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping("/getAll")
    public List<MaintenanceDTO> getAllMaintenances()
    {
        return maintenanceService.getAllMaintenances();
    }

    @GetMapping("getMaintenance/{id}")
    public MaintenanceDTO getMaintenance(@PathVariable int id)
    {
        return maintenanceService.getMaintenance(id);
    }

    @PostMapping("/add")
    public Boolean addAndUpdateMaintenance(@RequestBody Maintenance maintenance)
    {
        return maintenanceService.addAndUpdateMaintenance(maintenance);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteMaintenance(@PathVariable int id)
    {
        return maintenanceService.deleteMaintenance(id);
    }

    @DeleteMapping("/delete/detail/{id}")
    public Boolean deleteMaintenanceDetail(@PathVariable int id)
    {
        return maintenanceService.deleteMaintenanceDetail(id);
    }

    @DeleteMapping ("/delete/photo/{id}")
    public Boolean deleteMaintenancePhoto(@PathVariable int id)
    {
        return maintenanceService.deleteMaintenancePhoto(id);
    }
}
