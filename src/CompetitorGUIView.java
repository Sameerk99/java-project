import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompetitorGUIView {
    private CompetitorGUIModel model;
    private JFrame frame;
    private JTextArea competitorTextArea;

    public CompetitorGUIView(CompetitorGUIModel model) {
        this.model = model;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Competitor GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add your GUI components and layout here
        competitorTextArea = new JTextArea();
        competitorTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(competitorTextArea);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Save competitor report to a text file
                model.getCompetitorList().generateFinalReportToFile("CompetitorReport.txt");
                // Close the program
                frame.dispose();
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(closeButton, BorderLayout.SOUTH);

        updateCompetitorTextArea(); // Initial update of text area

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }

    public JButton getUpdateButton() {
        return updateButton;
    }


}
