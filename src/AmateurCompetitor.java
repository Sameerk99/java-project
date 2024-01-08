// AmateurCompetitor.java
public class AmateurCompetitor extends Competitor {
    public AmateurCompetitor(int competitorNumber, CompetitorName competitorName, String level, String country) {
        super(competitorNumber, competitorName, level, country);
    }

    @Override
    public double getOverallScore() {
        // Placeholder logic for calculating overall score for AmateurCompetitor
        double baseScore = 3.0;
        double ageMultiplier = 0.1; // Adjust based on age
        double countryMultiplier = 0.05; // Adjust based on country

        return baseScore + ageMultiplier * getCompetitorName().getAge() + countryMultiplier * getCountry().length();
    }

    // Additional methods specific to AmateurCompetitor...
}
