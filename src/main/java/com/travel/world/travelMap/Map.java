package com.travel.world.travelMap;

import java.util.LinkedList;
import java.util.ListIterator;

public class Map {
    Station[] stations;
    linkedList<Station> edges[];

    Map(int stationId){
        edges[stationId] = new linkedList<Station>(0);
    }
    void addEdge(int srcId,int endId,int dist){
        Station startingStation = stations[srcId];
        Station destinationStation = stations[endId];

        edges[srcId].add(destinationStation,dist);
        edges[endId].add(startingStation,dist);
    }
    void printMap(Map map) {
      /*  int noOfStations = map.stations.length;
        linkedList[] edges = map.edges;

        int i = 0;
        while (i < noOfStations) {
            for (linkedList edge : edges) {
                ListIterator<Station> iterator = edge.listIterator();
                while (iterator.hasNext()) {
                    Station station = iterator.next();
                    System.out.println(station.toString());
                }
                i++;
            }
        }*/
    }
    public Station[] getStations() {
        return stations;
    }

    public void setStations(Station[] stations) {
        this.stations = stations;
    }


    public Station getStation(Integer val){
        return stations[val];
    }
    public int shortedPath(int srcId,int distId){
        /*Station sourceStation = stations[srcId];
        linkedList<Station> nextStationsToSource = edges[srcId].getNext(edges[srcId]);
        int[] distance = new int[stations.length];
        int[] path = new int[stations.length];
        initialize(distance);
        while(nextStationsToSource!=null){
            Station station =  getCurrent(nextStationToSource);
            Station linkedStation = edge.next();
            if(sourceStation!=linkedStation){
                if()
            }
        }*/
        return Integer.MAX_VALUE;
    }

    private void initialize(int[] distance) {
        for(int i=0;i<distance.length;i++)
            distance[i] = Integer.MAX_VALUE;
    }

}
class linkedList<E>{
    int distance;
    int data;
    linkedList<E> next;

    linkedList(int distance){
        this.distance = distance;
    }
    void add(E n,int  distance){
        linkedList newNode = new linkedList<E>(distance);
        if(head==null)
            head = newNode;
        linkedList temp = head;
        while(temp.next!=null)
            temp = temp.next;
        temp.next=newNode;
    }
    public void traverse(linkedList n){
        linkedList temp = head;
        while(temp.next!=null)
            temp = temp.next;
    }
    linkedList<E> head;

    public linkedList<Station> getNext(linkedList<Station> edge) {
        return edge.next;
    }
    public Station getCurrent(LinkedList<Station> head){
        return head.get(0);
    }
}


