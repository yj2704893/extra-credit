import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Check that the filename was provided as a command line argument
        if (args.length == 0) {
            System.err.println("Usage: java Main race_data.txt");
            System.exit(1);
        }

        // Open the input file
        File inputFile = new File(args[0]);
        Scanner scanner;
        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + args[0]);
            System.exit(1);
            return; // Unreachable
        }

        // Parse the input data into a list of racers
        List<Race.Racer> racers = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue; // Skip empty lines
            }
            String[] parts = line.split(",");
            if (parts.length != 2) {
                System.err.println("Invalid input: " + line);
                continue;
            }
            String name = parts[0].trim();
            int time;
            try {
                time = Integer.parseInt(parts[1].trim());
            } catch (NumberFormatException e) {
                System.err.println("Invalid time: " + parts[1].trim());
                continue;
            }
            racers.add(new Race.Racer(name, time));
        }
        scanner.close();

        Race.printBestTimes(racers);
    }

}

