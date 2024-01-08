import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class CompetitorGUIController {
    private CompetitorGUIModel model;
    private CompetitorGUIView view;

    public CompetitorGUIController(CompetitorGUIModel model, CompetitorGUIView view) {
        this.model = model;
        this.view = view;
        initialize();
    }

    private void initialize() {
        // Add listeners and other initialization logic here

        // For example:
        JButton updateButton = view.getUpdateButton();
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click, update model or view as needed
                updateCompetitorScores();
            }
        });

        JButton viewDetailsButton = view.getViewDetailsButton();
        viewDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click, show details in the view
                displayCompetitorDetails();
            }
        });

        // Add more listeners as needed
    }

    private void updateCompetitorScores() {
        // Example: Retrieve values from the view and update the model
        int competitorNumber = view.getCompetitorNumber();
        double[] newScores = view.getNewScores();

        // Update the model
        SKCompetitor competitor = model.getCompetitorList().findCompetitorByNumber(competitorNumber);
        if (competitor != null) {
            competitor.setScores(newScores);
            // You might want to update the view to reflect the changes
            view.updateScoresDisplay(competitor.getOverallScore());
        } else {
            // Display an error message or handle the case when the competitor is not found
        }
    }

    private void displayCompetitorDetails() {
        // Example: Retrieve values from the view and show details in the view
        int competitorNumber = view.getCompetitorNumber();

        // Retrieve the competitor from the model
        SKCompetitor competitor = model.getCompetitorList().findCompetitorByNumber(competitorNumber);
        if (competitor != null) {
            // Update the view to display details
            view.displayCompetitorDetails(competitor.getFullDetails());
        } else {
            // Display an error message or handle the case when the competitor is not found
        }
    }


}
