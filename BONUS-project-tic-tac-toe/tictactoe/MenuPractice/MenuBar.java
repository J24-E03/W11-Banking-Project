package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar implements ActionListener, ItemListener{

    public JMenuBar createMenuBar(){
        JMenuBar menuBar;
        JMenu filemenu, editmenu;
        JMenu editsubmenu;
        JMenuItem menuItem;

        menuBar = new JMenuBar();

        filemenu = new JMenu("File");
        filemenu.setMnemonic(KeyEvent.VK_F);
        filemenu.getAccessibleContext().setAccessibleDescription("Menu of the File");
        menuBar.add(filemenu);


        menuItem = new JMenuItem("New", KeyEvent.VK_N);
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        filemenu.add(menuItem);
        menuItem = new JMenuItem("Open File...", KeyEvent.VK_O);
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        filemenu.add(menuItem);
        menuItem = new JMenuItem("Close", KeyEvent.VK_C);
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        filemenu.add(menuItem);


        editmenu = new JMenu("Edit");
        editmenu.setMnemonic(KeyEvent.VK_E);
        editmenu.getAccessibleContext().setAccessibleDescription("This is the Edit menu");
        menuBar.add(editmenu);


        menuItem = new JMenuItem("Undo", KeyEvent.VK_U);
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        editmenu.add(menuItem);

        menuItem = new JMenuItem("Redo", KeyEvent.VK_R);
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        editmenu.add(menuItem);

        editsubmenu = new JMenu("Expand To...");
        editsubmenu.setMnemonic(KeyEvent.VK_X);
        editsubmenu.addActionListener(this);
        editmenu.add(editsubmenu);

        menuItem = new JMenuItem("Enclosing");
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        editsubmenu.add(menuItem);

        menuItem = new JMenuItem("Next");
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        editsubmenu.add(menuItem);

        menuItem = new JMenuItem("Previous");
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        editsubmenu.add(menuItem);

        return menuBar;
    }


    private static void createAndShowGUI() {

        JFrame frame = new JFrame("Basic Menu Bar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SimpleMenu smenu = new SimpleMenu();
        frame.setJMenuBar(smenu.createMenuBar());

        frame.pack();
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }

    @Override
    public void itemStateChanged(ItemEvent e){
    }

    @Override
    public void actionPerformed(ActionEvent e){

        JMenuItem jmi = (JMenuItem) e.getSource();
        System.out.println("menu item clicked: " + jmi.getText());
        if (jmi.getText().equalsIgnoreCase("close")){
            System.exit(0);
        }
    }
}