public class Competitor {
    // Instance variables
    private int competitorNumber;
    private CompetitorName competitorName;
    private String level;
    private String country;

    // Constructor
    public Competitor(int competitorNumber, CompetitorName competitorName, String level, String country) {
        this.competitorNumber = competitorNumber;
        this.competitorName = competitorName;
        this.level = level;
        this.country = country;
    }

    // Getter and Setter methods for competitorNumber
    public int getCompetitorNumber() {
        return competitorNumber;
    }

    public void setCompetitorNumber(int competitorNumber) {
        this.competitorNumber = competitorNumber;
    }

    // Getter and Setter methods for competitorName
    public CompetitorName getCompetitorName() {
        return competitorName;
    }

    public void setCompetitorName(CompetitorName competitorName) {
        this.competitorName = competitorName;
    }

    // Getter and Setter methods for level
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    // Getter and Setter methods for country
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // Method to calculate overall score (placeholder implementation)
    public double getOverallScore() {
        // You can replace the following with your own logic to calculate the overall score
        return 5.0;
    }

    // Method to get full details of the competitor
    public String getFullDetails() {
        return "Competitor number " + competitorNumber + ", name " + competitorName.getFullName() +
                ", country " + country + ". " + competitorName.getFirstName() + " is a " + level +
                " aged " + competitorName.getAge() + " and has an overall score of " + getOverallScore() + ".";
    }

    // Method to get short details of the competitor
    public String getShortDetails() {
        return "CN " + competitorNumber + " (" + competitorName.getInitials() + ") has overall score " + getOverallScore() + ".";
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create CompetitorName objects
        CompetitorName competitorName1 = new CompetitorName("Alice", "Mary", "Smith", 30);
        CompetitorName competitorName2 = new CompetitorName("Bob", "John", "Johnson", 25);

        // Create Competitor objects and pass CompetitorName objects
        Competitor competitor1 = new Competitor(101, competitorName1, "Intermediate", "USA");
        Competitor competitor2 = new Competitor(202, competitorName2, "Expert", "Canada");

        // Test methods from CompetitorName class
        System.out.println("CompetitorName Test:");
        System.out.println("Full Name 1: " + competitorName1.getFullName());
        System.out.println("Initials 1: " + competitorName1.getInitials());
        System.out.println("Age 1: " + competitorName1.getAge());

        System.out.println("\nFull Name 2: " + competitorName2.getFullName());
        System.out.println("Initials 2: " + competitorName2.getInitials());
        System.out.println("Age 2: " + competitorName2.getAge());

        // Test methods from Competitor class
        System.out.println("\nCompetitor Test:");
        System.out.println("Competitor Number 1: " + competitor1.getCompetitorNumber());
        System.out.println("Competitor Level 1: " + competitor1.getLevel());
        System.out.println("Competitor Country 1: " + competitor1.getCountry());
        System.out.println("Overall Score 1: " + competitor1.getOverallScore());
        System.out.println("Full Details 1: " + competitor1.getFullDetails());
        System.out.println("Short Details 1: " + competitor1.getShortDetails());

        System.out.println("\nCompetitor Number 2: " + competitor2.getCompetitorNumber());
        System.out.println("Competitor Level 2: " + competitor2.getLevel());
        System.out.println("Competitor Country 2: " + competitor2.getCountry());
        System.out.println("Overall Score 2: " + competitor2.getOverallScore());
        System.out.println("Full Details 2: " + competitor2.getFullDetails());
        System.out.println("Short Details 2: " + competitor2.getShortDetails());
    }
}



