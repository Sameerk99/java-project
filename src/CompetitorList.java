import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CompetitorList {
    private ArrayList<SKCompetitor> competitors = new ArrayList<>();

    // Method to add a competitor to the list
    public void addCompetitor(SKCompetitor competitor) {
        competitors.add(competitor);
    }

    // Method to generate the final report and write it to a text file
    public void generateFinalReportToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            // Print table of competitors with full details
            writer.println("Competitors Details:");
            for (SKCompetitor competitor : competitors) {
                writer.println(competitor.getFullDetails());
            }

            // Find and print details of the competitor with the highest overall score
            SKCompetitor highestScorer = getCompetitorWithHighestScore();
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
        for (SKCompetitor competitor : competitors) {
            totalOverallScore += competitor.getOverallScore();
        }

        return totalOverallScore / competitors.size();
    }

    // Method to calculate the frequency of each individual score
    private Map<Integer, Integer> calculateScoreFrequency() {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (SKCompetitor competitor : competitors) {
            int[] scores = competitor.getScoreArray();
            for (int score : scores) {
                frequencyMap.put(score, frequencyMap.getOrDefault(score, 0) + 1);
            }
        }
        return frequencyMap;
    }

    // Method to get the competitor with the highest overall score
    private SKCompetitor getCompetitorWithHighestScore() {
        if (competitors.isEmpty()) {
            return null;
        }

        return Collections.max(competitors, Comparator.comparing(SKCompetitor::getOverallScore));
    }

    // Method to display short details for a specific competitor number
    public void displayShortDetails(int competitorNumber) {
        for (SKCompetitor competitor : competitors) {
            if (competitor.getCompetitorNumber() == competitorNumber) {
                System.out.println("Short Details for Competitor " + competitorNumber + ":");
                System.out.println(competitor.getShortDetails());
                return;
            }
        }
        System.out.println("Competitor with number " + competitorNumber + " not found.");
    }

    private SKCompetitor parseCompetitorFromLine(String line) {
        String[] fields = line.split(",");
        // Extract data from fields array and create SKCompetitor object
        // Example:
        // int competitorNumber = Integer.parseInt(fields[0]);
        // String firstName = fields[1];
        // ...
        // return new SKCompetitor(competitorNumber, firstName, ..., scores);
        return null; // Replace with your implementation
    }

    public void readDetailsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Skip the header line
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                // Parse the line and create SKCompetitor objects
                SKCompetitor competitor = parseCompetitorFromLine(line);
                // Add the objects to the CompetitorList
                addCompetitor(competitor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

