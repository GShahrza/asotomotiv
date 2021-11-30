package com.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Maintenance {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String maintenanceName;
    private String maintenanceDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id",referencedColumnName = "id")
    private Photos photo;

}
