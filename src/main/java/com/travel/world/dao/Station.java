package com.travel.world.dao;

import org.springframework.data.annotation.Id;

import java.util.Map;

public class Station {
    @Id
    public String id;
    public String name;
    public boolean isConnectionStation=false;
    public String neighbours;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(String neighbours) {
        this.neighbours = neighbours;
    }

    public boolean isConnectionStation() {
        return isConnectionStation;
    }

    public void setConnectionStation(boolean connectionStation) {
        isConnectionStation = connectionStation;
    }


}
