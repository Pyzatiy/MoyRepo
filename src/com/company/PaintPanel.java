package com.company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaintPanel extends BasePaintPanel implements ActionListener {

    static JButton newColor = new JButton();
    Color maincolor;
    JButton colorbutton;

    public PaintPanel() {
        PaintPanel.MyMouseHandler handler = new PaintPanel.MyMouseHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
        maincolor=Color.black;
        newColor.addActionListener(this);



    }

    @Override
    void changeColor() {
        JToolBar colorbar = new  JToolBar("Colorbar", JToolBar.HORIZONTAL);
        colorbar.setBounds(100, 100, 200, 50);
        colorbutton = new  JButton();
        colorbutton.setBackground(maincolor);
        colorbutton.setBounds(15, 5, 20, 20);
        colorbar.add(colorbutton);



        JButton redbutton = new  JButton();
        redbutton.setBackground(Color.red);
        redbutton.setBounds(40, 5, 15, 15);
        redbutton.addActionListener(new  ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                maincolor = Color.red;
                colorbutton.setBackground(maincolor);
            }
        });
        colorbar.add(redbutton);

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Paint program simple");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new PaintPanel();
        frame.add(panel);



        panel.add(newColor);


        frame.pack(); // устанавливает такой минимальный размер контейнера, который достаточен для отображения всех компонентов.
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        changeColor();
    }

    private class MyMouseHandler extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();

            g = getGraphics();

            x2 = x1;
            y2 = y1;
        }

        public void mouseDragged(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();

            g.drawLine(x1, y1, x2, y2);

            x2 = x1;
            y2 = y1;
        }

    }


}