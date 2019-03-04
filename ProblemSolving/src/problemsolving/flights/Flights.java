package problemsolving.flights;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jesus_Serrato
 */
public class Flights {

    Map<String, List<String>> connections;

    public Flights() {
        connections = new HashMap<>();
    }

    public void addConnection(String origin, String destination) {
        connections.putIfAbsent(origin, new ArrayList<>());
        connections.get(origin).add(destination);
    }

    public boolean isConnected(String origin, String destination) {
        List<String> destinations = connections.get(origin);

        if (destinations != null) {
            //if (destinations.stream().anyMatch(d -> d.equals(destination))) {
            if (destinations.contains(destination)) {
                return true;
            } else {
                if (destinations.stream().anyMatch(d -> isConnected(d, destination))) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Flights{" + "connections=" + connections + '}';
    }

    public static void main(String[] args) {
        Flights flights = new Flights();
        flights.addConnection("Seattle", "New York City");
        flights.addConnection("Portland", "Chicago");
        flights.addConnection("Miami", "Los Angeles");
        flights.addConnection("New York City", "Los Angeles");
        flights.addConnection("Seattle", "Washington D.C.");
        flights.addConnection("Los Angeles", "Mexico City");
        flights.addConnection("Mexico City", "Guadalajara");

        System.out.println(flights.toString());

        System.out.println(flights.isConnected("Seattle", "Los Angeles") == true);
        System.out.println(flights.isConnected("Seattle", "Washington D.C.") == true);
        System.out.println(flights.isConnected("Seattle", "Chicago") == false);
        System.out.println(flights.isConnected("Seattle", "Guadalajara") == true);
    }

}
