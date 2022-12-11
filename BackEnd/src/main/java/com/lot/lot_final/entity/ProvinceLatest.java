package com.lot.lot_final.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="covid_data_china_province_latest")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class ProvinceLatest {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        public int id;
        @Column(name="province_name")
        public String provinceName;
        @Column(name="province_confirmed_count")
        public int provinceConfirmedCount;
        @Column(name="province_cured_count")
        public int provinceCuredCount;
        @Column(name="province_dead_count")
        public int provinceDeadCount;
        @Column(name="update_time")
        public Date updateTime;
}
