package View;//package View;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.util.*;
//
//public class JobSchedulingGUI extends JFrame {
//
//    private JTable jobTable;
//    private JButton addJobButton, editJobButton, deleteJobButton;
//    private JMenuBar menuBar;
//    private JMenu fileMenu, helpMenu;
//    private JMenuItem exitMenuItem, aboutMenuItem;
//    private JLabel statusBar;
//
//    private ArrayList<String> jobList = new ArrayList<String>();
//
//    public JobSchedulingGUI() {
//        setTitle("Job Scheduling");
//        setSize(800, 600);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//        createComponents();
//        addComponentsToFrame();
//        addListeners();
//    }
//
//    private void createComponents() {
//        jobTable = new JTable();
//        addJobButton = new JButton("Add Job");
//        editJobButton = new JButton("Edit Job");
//        deleteJobButton = new JButton("Delete Job");
//        menuBar = new JMenuBar();
//        fileMenu = new JMenu("File");
//        helpMenu = new JMenu("Help");
//        exitMenuItem = new JMenuItem("Exit");
//        aboutMenuItem = new JMenuItem("About");
//        statusBar = new JLabel("Ready");
//    }
//
//    private void addComponentsToFrame() {
//        setJMenuBar(menuBar);
//        fileMenu.add(exitMenuItem);
//        menuBar.add(fileMenu);
//        helpMenu.add(aboutMenuItem);
//        menuBar.add(helpMenu);
//
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.add(addJobButton);
//        buttonPanel.add(editJobButton);
//        buttonPanel.add(deleteJobButton);
//
//        JScrollPane tableScrollPane = new JScrollPane(jobTable);
//
//        add(tableScrollPane, BorderLayout.CENTER);
//        add(buttonPanel, BorderLayout.SOUTH);
//        add(statusBar, BorderLayout.NORTH);
//    }
//
//
//    private void addListeners() {
//        exitMenuItem.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                System.exit(0);
//            }
//        });
//
//        aboutMenuItem.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(JobSchedulingGUI.this,
//                        "Job Scheduling Application\n\nVersion 1.0\n\nDeveloped by OpenAI",
//                        "About", JOptionPane.INFORMATION_MESSAGE);
//            }
//        });
//
//        addJobButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                // Code to add a new job
//            }
//        });
//
//        editJobButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                // Code to edit an existing job
//            }
//        });
//
//        deleteJobButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                // Code to edit an existing job
//            }
//        });
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        JobSchedulingGUI myObj = new JobSchedulingGUI(); // Create an object of Main
//
//    }
//}



import javax.swing .*;
import java.awt .*;

public class JobSchedulingGUI extends JFrame {
    JLabel label;
    JTextField text;
    JButton button;
    JPasswordField password;

    public JobSchedulingGUI() {
        initilize();
        uiInitilize();
    }

    public void initilize() {
        setTitle("Add Task");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(400, 150, 600, 500);
        setResizable(false);
        setLayout(null);
        Color c = new Color(253, 243, 213);
        getContentPane().setBackground(c);
    }

    public void uiInitilize() {
        label = new JLabel("Add Task");
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial", Font.BOLD, 25));
        label.setBounds(250, 40, 350, 25);
        add(label);

//            task 1
        label = new JLabel("Task 1");
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setBounds(150, 100, 200, 30);
        add(label);

//            textbox
        button = new JButton("View Furniture");
        button.setForeground(Color.black);
         button.setBounds(220, 100, 200, 30);
        add(button);


//            task 2
        label = new JLabel("Task 2");
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setBounds(150, 150, 200, 30);
        add(label);

        //            textbox
        button = new JButton("Add to Cart");
         button.setForeground(Color.black);
        button.setBounds(220, 150, 200, 30);
        add(button);

//            task 3
        label = new JLabel("Task 3");
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setBounds(150, 200, 200, 30);
        add(label);

        //            textbox
        button = new JButton("Buy");
        button.setForeground(Color.black);
        button.setBounds(220, 200, 200, 30);
        add(button);

        label = new JLabel("Task 4");
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setBounds(150, 250, 200, 30);
        add(label);

        //            textbox
        button = new JButton("Payment");
        button.setForeground(Color.black);
        button.setBounds(220, 250, 200, 30);
        add(button);

//            button
        button = new JButton("Add Task");
        button.setForeground(Color.WHITE);
        button.setBackground(Color.blue);
        button.setBounds(200, 300, 90, 25);
        add(button);

        button = new JButton("Edit Task");
        button.setForeground(Color.WHITE);
        button.setBackground(Color.blue);
        button.setBounds(300, 300, 90, 25);
        add(button);

//        button = new JButton("Back To Login");
//        button.setForeground(Color.WHITE);
//        button.setBackground(Color.red);
//        button.setBounds(300, 320, 200, 25);
//        add(button);
    }

    public static void main(String[] args) {
        new JobSchedulingGUI().setVisible(true);

    }
}

