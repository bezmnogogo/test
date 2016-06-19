package com.totalizator.dao.entities;

import javax.persistence.*;


@Entity
@Table(name = "clubs")
public class Club extends GenericEntity {

    @Column(name = "Name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Nation")
    private Nation nation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }
}
