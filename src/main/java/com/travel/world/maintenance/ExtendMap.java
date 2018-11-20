package com.travel.world.maintenance;

import com.travel.world.travelMap.Lines;
import com.travel.world.travelMap.Station;

import java.util.Map;
import java.util.Set;

public class ExtendMap {
    // write methods which can modify existing station


    public void modifyExistingStation(String stationId){
        //if stationId belongs to 2 lines then make it as 'isConnectingStation'
        Station station = new Station("");
        Station station1 = station.getStation(stationId);
        station1.setConnectingStation(true);
    }

    // write method which lays down new station or line
    public void layDownStation(Lines line,String stationId){
        Station station = new Station(stationId);
        station.setConnectingStation(true);
        Set<Station> stationSet =  line.getAllStationsFromTravelLine(line.getLineName());
        stationSet.add(station);
        line.createTravelLine(line.getLineName(),stationSet);
    }

    //Shutdown of a station
    public void modifyExistingStation(String stationId,boolean closeStation){
        Station station = new Station("");
        Station station1 = station.getStation(stationId);
        station1.setClosed(true);
    }

    //changing line station from one to another.
    public void movingStationToAnotherLine(String stationId,Lines line1,Lines line2){
        Set<Station> stationSet1 =  line1.getAllStationsFromTravelLine(line1.getLineName());
        Set<Station> stationSet2 =  line2.getAllStationsFromTravelLine(line2.getLineName());
        Station station = new Station(stationId);
        if(!stationSet1.isEmpty()){
            if(stationSet1.contains(station))
                stationSet1.remove(station);
        }
        line1.createTravelLine(line1.getLineName(),station);

    }


}
