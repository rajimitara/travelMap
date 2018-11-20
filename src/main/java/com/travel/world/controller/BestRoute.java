package com.travel.world.controller;

import com.travel.world.dao.Station;
import com.travel.world.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BestRoute {

    @Autowired
    private StationRepository stationRepository;

    //GetAllStations Available
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Station> getAllStations(){
        return stationRepository.findAll();
    }
    //Get a Stations if Available in database
    @RequestMapping(value = "/{stationId}", method = RequestMethod.GET)
    public Station getStationById(@PathVariable("stationId") String stationId){
        return stationRepository.findById(stationId);
    }
    @RequestMapping(value = "/{stationId}", method = RequestMethod.PUT)
    public Station modifyStation(@PathVariable("stationId") String stationId,@RequestBody Station station){
        station.setId(stationId);
        return stationRepository.save(station);
    }
    @RequestMapping(value="/", method=RequestMethod.POST)
    public Station createStation(@RequestBody Station station){
        return stationRepository.save(station);
    }

    @RequestMapping(value="/{stationId}", method = RequestMethod.DELETE)
    public void deleteStation(@PathVariable("stationId") String stationId){
        stationRepository.delete(stationId);
    }
    //make this Rest Get
    public void getCurrentBestPath(String srcName,String dstName){
        //call Graph g = new Graph(GRAPH);
        //        g.addEdge("h","i",7);
        //        g.dijkstra(START);
        //        g.printPath(END);
    }
    public String printRoadMap(String srcName,String dstName){
        getCurrentBestPath(srcName,dstName);
        return "";
    }
}
