package com.lot.lot_final.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@Entity
@Table(name="covid_data_world_cut")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    @Column(name = "country_name")
    public String countryName;
    @Column(name = "province_confirmed_count")
    public int confirmedCount;
    @Column(name = "province_cured_count")
    public int curedCount;
    @Column(name = "province_dead_count")
    public int deadCount;
    @Column(name = "update_time")
    public Date updateTime;

}
