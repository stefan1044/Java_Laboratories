package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class ControlPanel extends JPanel {
    final Mainframe frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");

    public ControlPanel(Mainframe frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));

        add(saveBtn);
        add(loadBtn);
        add(exitBtn);


        this.exitBtn.addActionListener(this::exitGame);
    }

    private void exitGame(ActionEvent actionEvent) {
        frame.dispose();
    }


}
