package com.travel.world.routeFinder;

 import com.travel.world.routeFinder.Graph;
 import com.travel.world.travelMap.Lines;
 import com.travel.world.travelMap.Station;
 import org.junit.Before;
 import org.junit.Test;

 import java.util.*;

public class TravelMapTests {
    //define test scenario
    //define a map & trace a station in it
 /*   @Test
    public void contextLoads() {
    }
*/
    String val = ""+133331;
    Lines line;
    Set<Station> setOfStations;
    Station station;
    //create Map
    final Graph.Edge[] GRAPH = {
            new Graph.Edge("a", "b", 8),
            new Graph.Edge("a", "c", 2),
            new Graph.Edge("a", "d", 5),
            new Graph.Edge("b", "d", 2),
            new Graph.Edge("b", "f", 13),
            new Graph.Edge("c", "d", 2),
            new Graph.Edge("c", "e", 5),
            new Graph.Edge("d", "e", 1),
            new Graph.Edge("d", "g", 3),
            new Graph.Edge("e", "g", 1),
            new Graph.Edge("f", "g", 2),
            new Graph.Edge("f", "h", 3),
            new Graph.Edge("g", "h", 6),
            new Graph.Edge("g", "f", 2),
    };
    @Before
    public void setUp(){
        int noOfStations = 5;
        line = new Lines();
        setOfStations = new HashSet<>();
        Station station;
        for(int i=0;i<noOfStations;i++){
            station = new Station(val);
            station.setName("test"+i);
            setOfStations.add(station);
        }
        line.createTravelLine("lineNo1",setOfStations);

    }

    @Test
    public void test001_createStation(){
        int val = 133331;
        Station station = new Station(""+val++);
        station.setName("test001");
        station.setName("test001");
        String yesOrNo = "T";
        if(yesOrNo.equals("T"))
            station.setConnectingStation(true);
        else
            station.setConnectingStation(false);
        yesOrNo ="T";
        if(yesOrNo.equals("T"))
            station.setClosed(true);
        else
            station.setClosed(false);

        System.out.println(station.toString());
    }
    @Test
    public void test002_modifyStationId(){
        if(station==null)
            station = new Station(val);
        station.setName("test002");
        station.setClosed(!station.isClosed());
        System.out.println(station.toString());
    }
    @Test
    public  void test003_printAllStations(){
        line.createTravelLine("test003_line",line.getAllStationsFromTravelLine(line.getLineName()));
        line.printStationsOfLine("test003_line");
    }
    @Test
    public void test004_createMap(){
       /* Scanner sc = new Scanner(System.in);
        System.out.println("Add line to map on station id? type 6 digit number");
        int val = sc.nextInt();
        Map map = new Map(val);
        Station newStation = new Station();
        Station connectingStation = newStation.getStation(val);

        String lineName = line.getLineName();
        Set<String> set = new HashSet<String>();

        for(Station station : line.getAllStationsFromTravelLine(lineName))
            set.add(station.getId());
        Iterator<String> itr = set.iterator();

        String srcId = connectingStation.getId();
        for(int i=0;i<set.size();i++) {

            String dstId = itr.next();
                    graph.addEdge(srcId,dstId,4);
            srcId = dstId;
        }*/
        final String START = "a";
        final String END = "i";
        Graph g = new Graph(GRAPH);
        g.dijkstra(START);
        g.dijkstra(START);
        g.printAllPaths();
    }

    @Test
    public void test005_printLinesInMap(){
        Graph g = new Graph(5);
        Lines line = new Lines();
        String list1= "OCP Orchard,SRP Square,JSP Junction,Design Patterns Plaza,EJB Estates";
        String list2= "OCP,SRP Square,JSP Junction,Design Patterns Plaza,EJB";

        line.createTravelLine("Break Neck Pizza",list1);
        line.createTravelLine("Break Neck Pizza",list2);
        createMethod(list1,g);
        createMethod(list2,g);
        final String START = "OCP Orchard";
        final String END = "EJB";
        g.dijkstra(START);
        g.printPath(END);
        //g.printAllPaths();
    }

    private void createMethod(String list1, Graph g) {
        String[] edges = list1.split(",");
        int i=0,n=edges.length-1;
        while(i<n){    //src Station
            g.addEdge(edges[i], edges[++i], new Random().nextInt(5)+1);
        }
    }
}

