package ui;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import javax.swing.*;


/**
 * The type Main window.
 */
public class MainWindow {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width, height;

    /**
     * Instantiates a new Main window.
     *
     * @param title  the title
     * @param width  the width
     * @param height the height
     */
    public MainWindow(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        createWindow();
        //createMenuBar();
    }

    private void createWindow(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        frame.add(canvas);
        frame.pack();
    }

//    private void createMenuBar() {
//
//        JMenuBar menubar = new JMenuBar();
//        ImageIcon exitIcon = new ImageIcon("src/resources/exit.png");
//
//        // Set up menu
//        JMenu menu = new JMenu("Menu");
//        menu.setMnemonic(KeyEvent.VK_M);
//        menubar.add(menu);
//
//        JMenuItem menuItem = new JMenuItem("Quit");
//        menuItem.setMnemonic(KeyEvent.VK_Q);
//        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK));
//        menuItem.setActionCommand("quit");
//        menuItem.addActionListener(this);
//        menu.add(menuItem);
//
//        return menubar;
//    }

    /**
     * Quit.
     */
    protected void quit() {
        System.exit(0);
    }
}