package com.lot.lot_final.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="covid_data_world_sum")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class GlobalSum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    @Column(name = "world_confirmed_count")
    public int sum;
    @Column(name = "world_cured_count")
    public int cured;
    @Column(name = "world_dead_count")
    public int dead;
    @Column(name = "update_time")
    public Date date;
}
