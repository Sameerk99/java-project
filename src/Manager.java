import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Manager {
    public static void main(String[] args) {
        CompetitorList competitorList = new CompetitorList();
        readDetailsFromFile(competitorList, "RunCompetitor.csv");
        competitorList.generateFinalReportToFile("FinalReport.txt");

        // Example: Allow the user to enter a competitor number and display short details
        int userInputCompetitorNumber = 100; // Replace with actual user input
        competitorList.displayShortDetails(userInputCompetitorNumber);
    }

    private static void readDetailsFromFile(CompetitorList competitorList, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Skip the header line
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                // Parse the line and create SKCompetitor objects
                SKCompetitor competitor = parseCompetitorFromLine(line);
                // Add the objects to the CompetitorList
                competitorList.addCompetitor(competitor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static SKCompetitor parseCompetitorFromLine(String line) {
        String[] fields = line.split(",");
        // Extract data from fields array and create SKCompetitor object
        // Example:
        // int competitorNumber = Integer.parseInt(fields[0]);
        // String firstName = fields[1];
        // ...
        // return new SKCompetitor(competitorNumber, firstName, ..., scores);
        return null; // Replace with your implementation
    }
}

