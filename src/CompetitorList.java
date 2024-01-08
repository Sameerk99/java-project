import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class CompetitorList {
    private ArrayList<Competitor> competitors = new ArrayList<>();

    // Method to add a competitor to the list
    public void addCompetitor(Competitor competitor) {
        competitors.add(competitor);
    }

    // Method to generate the final report and write it to a text file
    public void generateFinalReportToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            // Print table of competitors with full details
            writer.println("Competitors Details:");
            for (Competitor competitor : competitors) {
                writer.println(competitor.getFullDetails());
            }

            // Find and print details of the competitor with the highest overall score
            Competitor highestScorer = getCompetitorWithHighestScore();
            writer.println("\nCompetitor with the Highest Overall Score:");
            writer.println(highestScorer.getFullDetails());

            // Print other summary statistics
            writer.println("\nSummary Statistics:");
            writer.println("Average Overall Score: " + calculateAverageOverallScore());
            writer.println("Total Competitors: " + competitors.size());

            // Print frequency report
            writer.println("\nFrequency Report:");
            Map<Integer, Integer> scoreFrequency = calculateScoreFrequency();
            for (Map.Entry<Integer, Integer> entry : scoreFrequency.entrySet()) {
                writer.println("Score " + entry.getKey() + ": " + entry.getValue() + " times");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to calculate the average overall score
    private double calculateAverageOverallScore() {
        if (competitors.isEmpty()) {
            return 0.0;
        }

        double totalOverallScore = 0.0;
        for (Competitor competitor : competitors) {
            totalOverallScore += competitor.getOverallScore();
        }

        return totalOverallScore / competitors.size();
    }

    // Method to calculate the frequency of each individual score
    private Map<Integer, Integer> calculateScoreFrequency() {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Competitor competitor : competitors) {
            // Check if the competitor is of type SKCompetitor
            if (competitor instanceof SKCompetitor) {
                int[] scores = ((SKCompetitor) competitor).getScoreArray();
                for (int score : scores) {
                    frequencyMap.put(score, frequencyMap.getOrDefault(score, 0) + 1);
                }
            }
            // Handle other types of competitors if needed
        }
        return frequencyMap;
    }

    // Add other methods to modify the list of competitors as needed

    public Competitor getCompetitorByNumber(int competitorNumber) {
        for (Competitor competitor : competitors) {
            if (competitor.getCompetitorNumber() == competitorNumber) {
                return competitor;
            }
        }
        return null; // Return null if no matching competitor is found
    }

    public void removeCompetitorByNumber(int competitorNumber) {
        // Use an iterator to safely remove the competitor
        Iterator<Competitor> iterator = competitors.iterator();
        while (iterator.hasNext()) {
            Competitor competitor = iterator.next();
            if (competitor.getCompetitorNumber() == competitorNumber) {
                iterator.remove();
                break;  // Assuming competitor numbers are unique, we can exit the loop
            }
        }
    }


    // Method to get the competitor with the highest overall score
    private Competitor getCompetitorWithHighestScore() {
        if (competitors.isEmpty()) {
            return null;
        }

        return Collections.max(competitors, Comparator.comparing(Competitor::getOverallScore));
    }

    // Method to display short details for a specific competitor number
    public void displayShortDetails(int competitorNumber) {
        for (Competitor competitor : competitors) {
            if (competitor.getCompetitorNumber() == competitorNumber) {
                System.out.println("Short Details for Competitor " + competitorNumber + ":");
                System.out.println(competitor.getShortDetails());
                return;
            }
        }
        System.out.println("Competitor with number " + competitorNumber + " not found.");
    }

    // Method to parse competitor data from a line
    private Competitor parseCompetitorFromLine(String line) {
        String[] fields = line.split(",");
        // Extract data from fields array and create the appropriate Competitor subclass object
        // Example:
        // int competitorNumber = Integer.parseInt(fields[0]);
        // String firstName = fields[1];
        // ...
        // return new AmateurCompetitor(competitorNumber, firstName, ..., scores);
        return null; // Replace with your implementation
    }

    // Method to read competitor details from a file
    public void readDetailsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Skip the header line
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                // Parse the line and create the appropriate Competitor subclass object
                Competitor competitor = parseCompetitorFromLine(line);
                // Add the object to the CompetitorList
                addCompetitor(competitor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
