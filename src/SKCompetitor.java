import java.util.Arrays;

public class SKCompetitor extends Competitor {

    // Constructor
    public SKCompetitor(int competitorNumber, CompetitorName competitorName, String level, String country, int[] scores) {
        super(competitorNumber, competitorName, level, country);
        setScores(scores);
    }

    // Override the abstract method in the Competitor class
    @Override
    public double getOverallScore() {
        if (getScores().length < 3) {
            throw new IllegalArgumentException("At least 3 scores are required to calculate overall score.");
        }

        // Sort the scores to disregard the highest and lowest
        int[] sortedScores = Arrays.copyOf(getScores(), getScores().length);
        Arrays.sort(sortedScores);

        // Calculate the sum of middle scores
        int sum = 0;
        for (int i = 1; i < sortedScores.length - 1; i++) {
            sum += sortedScores[i];
        }

        // Calculate the average
        return (double) sum / (sortedScores.length - 2);
    }

    // Override the getShortDetails method in the Competitor class
    @Override
    public String getShortDetails() {
        String initials = getInitials();
        return "CN " + getCompetitorNumber() + " (" + initials + ") has overall score " + String.valueOf(getOverallScore()) + ".";
    }

    // Additional methods specific to SKCompetitor can be added here

    // Helper method to get initials from the first and last name
    private String getInitials() {
        if (getCompetitorName() == null) {
            return "";
        }

        String firstName = getCompetitorName().getFirstName();
        String lastName = getCompetitorName().getLastName();

        // Ensure non-empty strings before getting initials
        char firstInitial = (firstName.length() > 0) ? firstName.charAt(0) : ' ';
        char lastInitial = (lastName.length() > 0) ? lastName.charAt(0) : ' ';

        return String.valueOf(firstInitial) + String.valueOf(lastInitial);
    }

    public int[] getScoreArray() {
        return getScores();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create CompetitorName object
        CompetitorName competitorName = new CompetitorName("Keith", "John", "Talbot", 21);

        // Create SKCompetitor object with scores
        SKCompetitor skCompetitor = new SKCompetitor(100, competitorName, "Beginner", "UK", new int[]{5, 4, 5, 4, 3});

        // Test methods
        System.out.println("Competitor Number: " + skCompetitor.getCompetitorNumber());
        System.out.println("Scores: " + Arrays.toString(skCompetitor.getScores()));
        System.out.println("Overall Score: " + skCompetitor.getOverallScore());
        System.out.println(skCompetitor.getFullDetails());
    }
}
