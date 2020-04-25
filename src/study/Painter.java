package study;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Painter extends JFrame {
    private int prevX, prevY;
    private Color color = Color.BLACK;
    private JButton jButton = new JButton("Choose your color");
    public Painter() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(jButton);
        jButton.addActionListener(new ButtonActionListener());
        addMouseListener(new PaintMouseAdapter());
        addMouseMotionListener(new PaintMouseMotionAdapter());
    }

    private class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            color = JColorChooser.showDialog(((Component) e.getSource()).getParent(), "Painter Window", color);
        }
    }

    private class PaintMouseAdapter extends MouseAdapter {
        public void mousePressed(MouseEvent ev) {
            setPreviousCoordinates(ev.getX(), ev.getY());
        }
    }

    private class PaintMouseMotionAdapter extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent ev) {
            Graphics g = getGraphics();
            g.setColor(color);
            g.drawLine(prevX, prevY, ev.getX(), ev.getY());
            setPreviousCoordinates(ev.getX(), ev.getY());
        }
    }

    public void setPreviousCoordinates(int aPrevX, int aPrevY) {
        prevX = aPrevX;
        prevY = aPrevY;
    }

    public static void main(String[] args) {
        Painter pe = new Painter();
        pe.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });
        pe.setBounds(100, 100, 600, 600);
        pe.setTitle("MicroPaint");
        pe.setVisible(true);
    }

}