package lab6;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {

    final Mainframe frame;
    final static int width = 800, height = 600;
    private int numVertices;
    private double edgeProbability;
    private int[] x,y;

    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(Mainframe frame){
        this.frame=frame;
        createOffscreenImage();
        initPanel();

    }

    private void createOffscreenImage(){
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }

    private void initPanel(){
        setPreferredSize(new Dimension(width, height));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                repaint();
            }
        });
    }

    final void createBoard(){
        numVertices = 8;
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        createOffscreenImage();
        createVertices();
        //drawLines();
        //drawVertices();
        repaint();
    }

    private void createVertices(){
        int x0= width/2;
        int y0 = height/2;
        int radius = height/2 - 10;
        double alpha = 2 * Math.PI / numVertices;
        x = new int[numVertices];
        y = new int[numVertices];

        for(int i = 0; i < numVertices;i++){
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

}
