package com.totalizator.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by home
 */
@Entity
@Table(name = "sport")
public class Sport extends GenericEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "popularity", nullable = false)
    private long popularity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopularity() {
        return popularity;
    }

    public void setPopularity(long popularity) {
        this.popularity = popularity;
    }
}
