public abstract class Competitor {
    private int competitorNumber;
    private CompetitorName competitorName;
    private String level;
    private String country;

    public Competitor(int competitorNumber, CompetitorName competitorName, String level, String country) {
        this.competitorNumber = competitorNumber;
        this.competitorName = competitorName;
        this.level = level;
        this.country = country;
    }

    public abstract double getOverallScore();

    public int getCompetitorNumber() {
        return competitorNumber;
    }

    public void setCompetitorNumber(int competitorNumber) {
        this.competitorNumber = competitorNumber;
    }

    public CompetitorName getCompetitorName() {
        return competitorName;
    }

    public void setCompetitorName(CompetitorName competitorName) {
        this.competitorName = competitorName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFullDetails() {
        return "Competitor number " + competitorNumber + ", name " + competitorName.getFullName() +
                ", country " + country + ". " + competitorName.getFirstName() + " is a " + level +
                " aged " + competitorName.getAge() + " and has an overall score of " + getOverallScore() + ".";
    }

    public String getShortDetails() {
        return "CN " + competitorNumber + " (" + competitorName.getInitials() + ") has overall score " + getOverallScore() + ".";
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create CompetitorName objects
        CompetitorName competitorName1 = new CompetitorName("Alice", "Mary", "Smith", 30);
        CompetitorName competitorName2 = new CompetitorName("Bob", "John", "Johnson", 25);

        // Create Competitor objects and pass CompetitorName objects
        Competitor amateurCompetitor = new AmateurCompetitor(101, competitorName1, "Intermediate", "USA");
        Competitor professionalCompetitor = new ProfessionalCompetitor(202, competitorName2, "Expert", "Canada");

        // Test methods from CompetitorName class
        System.out.println("CompetitorName Test:");
        System.out.println("Full Name 1: " + competitorName1.getFullName());
        System.out.println("Initials 1: " + competitorName1.getInitials());
        System.out.println("Age 1: " + competitorName1.getAge());

        System.out.println("\nFull Name 2: " + competitorName2.getFullName());
        System.out.println("Initials 2: " + competitorName2.getInitials());
        System.out.println("Age 2: " + competitorName2.getAge());

        // Test methods from Competitor class (and subclasses)
        System.out.println("\nCompetitor Test:");
        System.out.println("Competitor Number 1: " + amateurCompetitor.getCompetitorNumber());
        System.out.println("Competitor Level 1: " + amateurCompetitor.getLevel());
        System.out.println("Competitor Country 1: " + amateurCompetitor.getCountry());
        System.out.println("Overall Score 1: " + amateurCompetitor.getOverallScore());
        System.out.println("Full Details 1: " + amateurCompetitor.getFullDetails());
        System.out.println("Short Details 1: " + amateurCompetitor.getShortDetails());

        System.out.println("\nCompetitor Number 2: " + professionalCompetitor.getCompetitorNumber());
        System.out.println("Competitor Level 2: " + professionalCompetitor.getLevel());
        System.out.println("Competitor Country 2: " + professionalCompetitor.getCountry());
        System.out.println("Overall Score 2: " + professionalCompetitor.getOverallScore());
        System.out.println("Full Details 2: " + professionalCompetitor.getFullDetails());
        System.out.println("Short Details 2: " + professionalCompetitor.getShortDetails());
    }
}
