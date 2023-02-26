import Controller.TaskController;
import Model.TaskModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Add_Task_Page extends JFrame {


    JLabel Label;
    JLabel id;
    JPanel frame;


    JTextField textTask;
    JTextField textId;
    JButton addTaskbtn;
    JButton scheduleJobbtn
            ;


    public Add_Task_Page() {
       initialize();
        uIInitialize();
    }

    public void initialize () {
        setTitle("Add Your Task");
        setSize(800, 700 );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setBackground(new Color(0x24A6A3));
        getContentPane();

        frame =new JPanel();
        frame.setBounds(120,50,550,550);
        frame.setBackground(new Color(0x58C4BA));
        add(frame);

    }
    public void uIInitialize(){

        id = new JLabel("Add Task Id");
        id.setFont(new Font("San Serif", Font.PLAIN, 20));
        id.setBounds(200,150,200,25);
        id.setForeground(Color.black);
        add(id);
        add(frame);

        textId = new JTextField();
        textId.setBounds(350,150,160,25);
        add(textId);
        add(frame);


        Label = new JLabel("Add your Task ");
        Label.setFont(new Font("San Serif", Font.PLAIN, 20));
        Label.setBounds(200,230,200,25);
        Label.setForeground(Color.black);
        add(Label);
        add(frame);


        textTask = new JTextField();
        textTask.setBounds(350,230,160,25);
        add(textTask);
        add(frame);


        addTaskbtn = new JButton("Add Task");
        addTaskbtn.setBounds(300,320,180,35);
        addTaskbtn.setForeground(Color.white);
        addTaskbtn.setFocusPainted(false);
        addTaskbtn.setBackground(new Color(0x24A692));
        addTaskbtn.setFont(new Font("San Serif", Font.PLAIN, 25));
        add(addTaskbtn);
        add(frame);

        scheduleJobbtn = new JButton("Create Job");
        scheduleJobbtn.setBounds(300,385,180,35);
        scheduleJobbtn.setForeground(Color.white);
        scheduleJobbtn.setFocusPainted(false);
        scheduleJobbtn.setBackground(new Color(0x24A692));
        scheduleJobbtn.setFont(new Font("San Serif", Font.PLAIN, 25));
        add(scheduleJobbtn);
        add(frame);

      addTaskbtn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             addTask();
          }
      });

        scheduleJobbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Create_Job createJob = new Create_Job();
                createJob.show();
                dispose();
            }
        });
    }


    private void addTask(){
        String task= textTask.getText();
        int taskId = Integer.parseInt(textId.getText());

        if(task.isEmpty()|| textId.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Please enter all the fields");

        }

        else{
            TaskModel taskModel = new TaskModel(task,taskId);

            TaskController taskController = new TaskController();
            int insert =taskController.addTask(taskModel);

            if (insert > 0) {
                JOptionPane.showMessageDialog(null, "Task Added Successfully");


            } else {
                JOptionPane.showMessageDialog(null, "Failed to Add Task");
            }
        }
    }





    public static void main(String[] args) {
        new Add_Task_Page().setVisible(true);
    }
}