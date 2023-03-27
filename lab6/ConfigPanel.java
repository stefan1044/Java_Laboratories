package lab6;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final Mainframe frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;


    public ConfigPanel(Mainframe frame){
        this.frame=frame;
        init();
    }

    private void init(){
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));

    }
}
