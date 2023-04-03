package lab6;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {

    final static int width = 800, height = 600;
    private final static double PI = 3.1415926;
    private final static int CIRCLE_DIAMETER = 20;
    private int[] x,y;
    private int[][] edges;
    final Mainframe frame;
    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(Mainframe frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);

    }

    private void initPanel() {
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

    @Override
    public void update(Graphics graphics) {

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
        graphics.setColor(Color.BLACK);
        int numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        //double edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        int x0 = width / 2;
        int y0 = height / 2;
        int radius = height / 2 - 10;
        double alpha = 2 * Math.PI / numVertices;
        this.x = new int[numVertices];
        this.y = new int[numVertices];

        x[0] = x0 + (int) (radius * Math.cos(0));
        y[0] = y0 + (int) (radius * Math.sin(0));
        for (int i = 1; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
            graphics.drawLine(x[i] + (int) (PI + CIRCLE_DIAMETER / 2), y[i] + (int) (PI + CIRCLE_DIAMETER / 2),
                    x[i - 1] + (int) (PI + CIRCLE_DIAMETER / 2), y[i - 1] + (int) (PI + CIRCLE_DIAMETER / 2));
            graphics.fillOval(x[i], y[i], CIRCLE_DIAMETER, CIRCLE_DIAMETER);
        }

        for(int i = 0;i<numVertices;i++){
            for(int j = i + 1;j<numVertices;j++){
                if (i!=j) {
                    this.edges[i][j] = 1;
                    this.edges[j][i] = 1;
                }
            }
        }

        graphics.drawLine(x[numVertices - 1] + (int) (PI + CIRCLE_DIAMETER / 2), y[numVertices - 1] +
                (int) (PI + CIRCLE_DIAMETER / 2), x[0] + (int) (PI + CIRCLE_DIAMETER / 2), y[0] + (int) (PI + CIRCLE_DIAMETER / 2));
        graphics.fillOval(x[0], y[0], CIRCLE_DIAMETER, CIRCLE_DIAMETER);

    }

}
