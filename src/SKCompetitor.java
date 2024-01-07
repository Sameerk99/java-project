import java.util.Arrays;

public class SKCompetitor {
    // Instance variable: array of 5 integer scores
    private int[] scores = new int[5];

    // Other instance variables (assuming similar to Competitor class)
    private int competitorNumber;
    private CompetitorName competitorName;
    private String level;
    private String country;

    // Constructor
    public SKCompetitor(int competitorNumber, CompetitorName competitorName, String level, String country, int[] scores) {
        this.competitorNumber = competitorNumber;
        this.competitorName = competitorName;
        this.level = level;
        this.country = country;
        this.scores = scores;
    }

    // Getter method for scores
    public int[] getScoreArray() {
        return scores;
    }

    // Calculate overall score from the array of integer scores
    public double getOverallScore() {
        if (scores.length < 3) {
            throw new IllegalArgumentException("At least 3 scores are required to calculate overall score.");
        }

        // Sort the scores to disregard the highest and lowest
        Arrays.sort(scores);

        // Calculate the sum of middle scores
        int sum = 0;
        for (int i = 1; i < scores.length - 1; i++) {
            sum += scores[i];
        }

        // Calculate the average
        return (double) sum / (scores.length - 2);
    }

    // Get full details including all scores
    public String getFullDetails() {
        return "Competitor number " + competitorNumber + ", name " + competitorName.getFullName() +
                ", country " + country + ". " + competitorName.getFirstName() + " is a " + level +
                " aged " + competitorName.getAge() + " and received these scores: " +
                Arrays.toString(scores) + "\nThis gives him an overall score of " + getOverallScore() + ".";
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create CompetitorName object
        CompetitorName competitorName = new CompetitorName("Keith", "John", "Talbot", 21);

        // Create SKCompetitor object with scores
        SKCompetitor skCompetitor = new SKCompetitor(100, competitorName, "Beginner", "UK", new int[]{5, 4, 5, 4, 3});

        // Test methods
        System.out.println("Scores: " + Arrays.toString(skCompetitor.getScoreArray()));
        System.out.println("Overall Score: " + skCompetitor.getOverallScore());
        System.out.println(skCompetitor.getFullDetails());
    }
}
