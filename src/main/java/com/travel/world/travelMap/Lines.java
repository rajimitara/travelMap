package com.travel.world.travelMap;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.Map;

public class Lines {

   //all lines available in lines : go to database
    Map<String,Set<Station>> lines;

    String lineName;

    public Lines(){
        if(lines == null)
            lines = new HashMap<String, Set<Station>>();
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }


    public void createTravelLine(String lineName,Set<Station> stations){
       lines.put(lineName,stations);
    }
    public void createTravelLine(String lineName,Station station){
        Set<Station> stationSet = lines.get(lineName);
        if(CollectionUtils.isEmpty(stationSet)) {
            stationSet = new HashSet<>();
            stationSet.add(station);
        }else{
            stationSet.add(station);
        }
        lines.put(lineName,stationSet);
    }
    public void deleteStationFromTravelLine(String lineName,Station station){
        Set<Station> stationSet = lines.get(lineName);
        if(!CollectionUtils.isEmpty(stationSet))
            stationSet.remove(station);
        lines.put(lineName,stationSet);
    }

    public void createTravelLine(String lineName, String stations){
       String list= "OCP Orchard,SRP Square,JSP Junction,Design Patterns Plaza,EJB Estates";
       String[] edges = stations.split(",");
        Station station;
        Set<Station> stationSet = new HashSet<>();
       for(String stationId:edges) {
           station = new Station(stationId);
           stationSet.add(station);
       }
        lines.put(lineName,stationSet);
    }

    public Set<Station> getAllStationsFromTravelLine(String lineName){
        return lines.get(lineName);
    }

    public void printStationsOfLine(String lineName){
        Set<Station> lineStations = lines.get(lineName);
        if(!CollectionUtils.isEmpty(lineStations))
            for(Station station:lineStations)
                System.out.println(station.toString());
    }

    public void setLines(Map<String, Set<Station>> lines) {
        this.lines = lines;
    }

    public Map<String, Set<Station>> getLines() {
        return lines;
    }

}
