package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class BasePaintPanel extends JPanel {

    protected int x1, y1, x2, y2;
    protected Graphics g;

    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 800;
    private static final Color BACK_COLOR = Color.WHITE;

    BasePaintPanel() {
        setBackground(BACK_COLOR);
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));

    }

    abstract void changeColor();

}
