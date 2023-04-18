import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Race {

    // Define a class to represent a racer
    public static class Racer {
        String name;
        int time;

        public Racer(String name, int time) {
            this.name = name;
            this.time = time;
        }
    }

    public static void printBestTimes(List<Racer> racers) {
        // Sort the racers by their times
        Collections.sort(racers, new Comparator<Racer>() {
            @Override
            public int compare(Racer r1, Racer r2) {
                return r1.time - r2.time;
            }
        });

        // Output the best three times
        int numRacers = racers.size();
        if (numRacers >= 1) {
            System.out.println("First place: " + racers.get(0).name + " (" + racers.get(0).time + " minutes)");
        }
        if (numRacers >= 2) {
            System.out.println("Second place: " + racers.get(1).name + " (" + racers.get(1).time + " minutes)");
        }
        if (numRacers >= 3) {
            System.out.println("Third place: " + racers.get(2).name + " (" + racers.get(2).time + " minutes)");
        }
    }

}

