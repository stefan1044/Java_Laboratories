package lab6;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final Mainframe frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox<Double> linesCombo;
    JButton createButton;


    public ConfigPanel(Mainframe frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 30, 1));
        linesLabel = new JLabel("Line probability: ");

        Double[] arr = {1.0};
        linesCombo = new JComboBox<>(arr);
        createButton = new JButton("Create");
        createButton.addActionListener(e -> this.frame.drawingPanel.repaint());

        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
    }
}
