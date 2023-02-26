import Controller.TaskController;
import Model.JobTaskModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Job_Task_Page extends JFrame{
  JPanel frame;
  JButton Back;
  JLabel id;
  JTextField textId;
  JComboBox task;
  JComboBox dependency;
  JButton addTaskbtn;
  JLabel createTaskbtn;
  JLabel dependentTask;

    Job_Task_Page(){
        setTitle("Select Task For Job");
        setSize(800,700 );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setBackground(new Color(0x39CCB7));
        getContentPane();

        frame =new JPanel();
        frame.setBounds(120,50,550,550);
        frame.setBackground(new Color(0x58C4BA));
        add(frame);

        initilize();
    }

    void initilize(){

        Back = new JButton("Back");
        Back.setBounds(0, 10, 70, 25);
        Back.setFont(new Font("Roboto", Font.BOLD, 10));
        Back.setForeground(Color.white);
        Back.setBackground(new Color(0x24A692));
        Back.setFocusPainted(false);
        add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_Task_Page addTaskPage = new Add_Task_Page();
                addTaskPage.show();
                dispose();
            }
        });

        TaskController taskController = new TaskController();
        ArrayList<Integer> idtaskList = taskController.fetchTask();
        String[] idOfTaskList=new String[idtaskList.size()+1];
        System.out.println(idtaskList);


        for(int i=0; i<idtaskList.size(); i++){

               System.out.println(idtaskList.get(i));
               idOfTaskList[i]=idtaskList.get(i).toString();


        }

        System.out.println(Arrays.toString(idOfTaskList));

        id = new JLabel("Job Id");
        id.setFont(new Font("San Serif", Font.PLAIN, 20));
        id.setBounds(230,130,200,25);
        id.setForeground(Color.black);
        add(id);
        add(frame);

        textId = new JTextField();
        textId.setBounds(390,130,160,25);
        add(textId);
        add(frame);

        createTaskbtn = new JLabel("Current Task");
        createTaskbtn.setFont(new Font("San Serif", Font.PLAIN, 20));
        createTaskbtn.setBounds(230,210,200,25);
        createTaskbtn.setForeground(Color.black);
        add(createTaskbtn);
        add(frame);


        task = new JComboBox(idOfTaskList);
        task.setFont(new Font("Roboto", Font.PLAIN, 20));
        task.setBounds(390,210,160,25);
        add(task);

        dependentTask = new JLabel("Dependent Task");
        dependentTask.setFont(new Font("San Serif", Font.PLAIN, 20));
        dependentTask.setBounds(230, 290, 200, 25);
        dependentTask.setForeground(Color.black);
        add(dependentTask);
        add(frame);


        dependency = new JComboBox(idOfTaskList);
        dependency.setFont(new Font("Roboto", Font.PLAIN, 20));
        dependency.setBounds(390, 290, 160, 25);
        add(dependency);

        addTaskbtn = new JButton("Add Task");
        addTaskbtn.setBounds(320,400,150,40);
        addTaskbtn.setForeground(Color.white);
        addTaskbtn.setFocusPainted(false);
        addTaskbtn.setBackground(new Color(0x24A692));
        addTaskbtn.setFont(new Font("San Serif", Font.PLAIN, 20));
        add(addTaskbtn);
        add(frame);

        addTaskbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int jobId;
                int source;
                int destination;

                if(textId.getText().isEmpty()||String.valueOf(task.getSelectedItem()).isEmpty()){
                    JOptionPane.showMessageDialog(null, "blank fields", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    jobId=Integer.parseInt(textId.getText());
                    source=Integer.parseInt(String.valueOf(dependency.getSelectedItem()));
                    destination=Integer.parseInt(String.valueOf(task.getSelectedItem()));

                    JobTaskModel jobTaskModel = new JobTaskModel(jobId,source,destination);
                    TaskController taskController1 = new TaskController();
                    int insert = taskController.addJobTask(jobTaskModel);

                    if(insert>0){
                        JOptionPane.showMessageDialog(null, "Task added Successfully");
                    }else{
                        JOptionPane.showMessageDialog(null, "Filed to add Task");
                    }


                }
            }
        });

    }


    public static void main(String[] args) {
        new Job_Task_Page().setVisible(true);
    }





}
