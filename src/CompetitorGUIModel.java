import java.util.ArrayList;

public class CompetitorGUIModel {
    private CompetitorList competitorList;

    public CompetitorGUIModel() {
        competitorList = new CompetitorList();
        // You may need to load competitors from a file or database here
    }

    public CompetitorList getCompetitorList() {
        return competitorList;
    }

    public void addCompetitor(SKCompetitor competitor) {
        competitorList.addCompetitor(competitor);
    }

    public void updateCompetitorScores(int competitorNumber, int[] newScores) {
        Competitor competitor = competitorList.getCompetitorByNumber(competitorNumber);
        if (competitor != null && competitor instanceof SKCompetitor) {
            SKCompetitor skCompetitor = (SKCompetitor) competitor;
            skCompetitor.setScores(newScores);
        }
    }


    public void updateCompetitorDetails(int competitorNumber, String level, String country) {
        Competitor competitor = competitorList.getCompetitorByNumber(competitorNumber);
        if (competitor != null && competitor instanceof SKCompetitor) {
            SKCompetitor skCompetitor = (SKCompetitor) competitor;
            skCompetitor.setLevel(level);
            skCompetitor.setCountry(country);
        }
    }


    public void removeCompetitor(int competitorNumber) {
        competitorList.removeCompetitorByNumber(competitorNumber);
    }


}

