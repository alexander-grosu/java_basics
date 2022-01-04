import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // list of flights in next 2 hours
        findPlanesLeavingInTheNextTwoHours(Airport.getInstance()).forEach(System.out::println);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {

        LocalDateTime timeNow = LocalDateTime.now();

        var flightsInNextTwoHours = airport.getTerminals().stream()
                .flatMap(terminals -> terminals.getFlights().stream())
                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                .filter(flight -> LocalDateTime.ofInstant(flight.getDate().toInstant(), ZoneId.systemDefault()).isAfter(timeNow)
                        && LocalDateTime.ofInstant(flight.getDate().toInstant(), ZoneId.systemDefault()).isBefore(timeNow.plusHours(2)))
                .collect(Collectors.toList());

        return flightsInNextTwoHours;
    }

}