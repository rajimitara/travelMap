package com.travel.world.travelMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


public class Station implements Comparable<Station> {
    final String id; //6 digit number
    String name;
    boolean isClosed;
    boolean isConnectingStation;
    public int dist = Integer.MAX_VALUE; // MAX_VALUE assumed to be infinity
    public Station previous = null;
    public final java.util.Map<Station, Integer> neighbours = new HashMap<>();

    public void printPath() {
        if (this == this.previous) {
            System.out.printf("%s", this.id);
        } else if (this.previous == null) {
            System.out.printf("%s(unreached)", this.id);
        } else {
            this.previous.printPath();
            System.out.printf(" -> %s(%d)", this.id, this.dist);
        }
    }

    public int compareTo(Station other) {
        if (dist == other.dist)
            return id.compareTo(other.id);

        return Integer.compare(dist, other.dist);
    }

    //all stations available in map : go to database
    Map<String,Station> allStations;

    public Map<String, Station> getAllStations() {
        return allStations;
    }

    public void setAllStations(Map<String, Station> allStations) {
        this.allStations = allStations;
    }
    public Station getStation(String stationId){
        return allStations.get(stationId);
    }
    void addToStation(Set<Station> stations){
        for(Station station: stations)
            allStations.put(station.getId(),station);
    }

    public Station(String id){
        this.id =id;
    }
    Station(String[] split){
        id="";
    }
    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }
    public boolean isConnectingStation() {
        return isConnectingStation;
    }

    public void setConnectingStation(boolean connectingStation) {
        isConnectingStation = connectingStation;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return id == station.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isClosed=" + isClosed +
                ", isConnectingStation=" + isConnectingStation +
                '}';
    }
}
