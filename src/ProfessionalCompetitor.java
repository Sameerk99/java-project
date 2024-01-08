// ProfessionalCompetitor.java
public class ProfessionalCompetitor extends Competitor {
    public ProfessionalCompetitor(int competitorNumber, CompetitorName competitorName, String level, String country) {
        super(competitorNumber, competitorName, level, country);
    }

    @Override
    public double getOverallScore() {
        // Placeholder logic for calculating overall score for ProfessionalCompetitor
        double baseScore = 4.0;
        double ageMultiplier = 0.15; // Adjust based on age
        double countryMultiplier = 0.08; // Adjust based on country

        return baseScore + ageMultiplier * getCompetitorName().getAge() + countryMultiplier * getCountry().length();
    }


}
