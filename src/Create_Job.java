import Controller.TaskController;
import Model.JobModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Create_Job extends JFrame {


    JLabel JLabel;
    JLabel Id;
    JPanel frame;
    JLabel numofTask;
    JLabel profit;
    JLabel time;


    JTextField textjob;
    JTextField textId;
    JTextField textNumTask;
    JTextField textprofit;
    JTextField textTime;

    JButton CreateJobbtn;
    JButton addTaskbtn;
    JButton backbtn;

    public Create_Job() {
        initialize();
        uIInitialize();
    }

    public void initialize () {
        setTitle("Create Your Job");
        setSize(800, 700  );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setBackground(new Color(0x9F7298));
        getContentPane();

        frame =new JPanel();
        frame.setBounds(120,50,550,550);
        frame.setBackground(new Color(0x58C4BA));
        add(frame);

    }
    public void uIInitialize(){


        backbtn = new JButton("Back");
        backbtn.setBounds(0, 10, 70, 25);
        backbtn.setFont(new Font("Roboto", Font.BOLD, 10));
        backbtn.setForeground(Color.white);
        backbtn.setBackground(new Color(0x24A692));
        backbtn.setFocusPainted(false);
        add(backbtn);
        backbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_Task_Page addTaskPage = new Add_Task_Page();
                addTaskPage.show();
                dispose();
            }
        });

        Id = new JLabel("Job Id");
        Id.setFont(new Font("San Serif", Font.PLAIN, 20));
        Id.setBounds(250,130,200,25);
        Id.setForeground(Color.black);
        add(Id);
        add(frame);

        textId = new JTextField();
        textId.setBounds(350,130,160,25);
        add(textId);
        add(frame);

        JLabel = new JLabel("Job name");
        JLabel.setFont(new Font("San Serif", Font.PLAIN, 20));
        JLabel.setBounds(250,210,200,25);
        JLabel.setForeground(Color.black);
        add(JLabel);
        add(frame);


        textjob = new JTextField();
        textjob.setBounds(350,210,160,25);
        add(textjob);
        add(frame);

        numofTask = new JLabel("No of task");
        numofTask.setFont(new Font("San Serif", Font.PLAIN, 20));
        numofTask.setBounds(250, 290, 200, 25);
        numofTask.setForeground(Color.black);
        add(numofTask);
        add(frame);

        textNumTask = new JTextField();
        textNumTask.setBounds(350, 290, 160, 25);
        add(textNumTask);
        add(frame);

        time = new JLabel("End Time");
        time.setFont(new Font("San Serif", Font.PLAIN, 20));
        time.setBounds(250, 370, 200, 25);
        time.setForeground(Color.black);
        add(time);
        add(frame);

        textTime = new JTextField();
        textTime.setBounds(350,370,160,25);
        add(textTime);
        add(frame);


        profit=new JLabel("Profit");
        profit.setFont(new Font("San Serif", Font.PLAIN, 20));
        profit.setBounds(250, 450, 200, 25);
        profit.setForeground(Color.black);
        add(profit);
        add(frame);

        textprofit = new JTextField();
        textprofit.setBounds(350,450,160,25);
        add(textprofit);
        add(frame);


        CreateJobbtn = new JButton("Create Job");
        CreateJobbtn.setBounds(210,520,180,40);
        CreateJobbtn.setForeground(Color.white);
        CreateJobbtn.setFocusPainted(false);
        CreateJobbtn.setBackground(new Color(0x24A692));
        CreateJobbtn.setFont(new Font("San Serif", Font.PLAIN, 25));
        add(CreateJobbtn);
        add(frame);

        addTaskbtn = new JButton("Add Task");
        addTaskbtn.setBounds(410,520,180,40);
        addTaskbtn.setForeground(Color.white);
        addTaskbtn.setFocusPainted(false);
        addTaskbtn.setBackground(new Color(0x24A692));
        addTaskbtn.setFont(new Font("San Serif", Font.PLAIN, 25));
        add(addTaskbtn);
        add(frame);

        CreateJobbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addJob();
            }
        });

        addTaskbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Job_Task_Page addJobTask = new Job_Task_Page();
                addJobTask.show();
                dispose();
            }
        });



    }

    private void addJob(){
        int id=Integer.parseInt(textId.getText());
        String jobName = textjob.getText();
        int numOfTask = Integer.parseInt(textNumTask.getText());
        int dead=Integer.parseInt(textTime.getText());
        int profit = Integer.parseInt(textprofit.getText());

        if(id==0||jobName.isEmpty()){
            JOptionPane.showMessageDialog(this,"Please Enter All Field","Try again",JOptionPane.ERROR_MESSAGE);
        }else{
            JobModel jobModel = new JobModel(id, jobName,numOfTask,dead,profit);
            TaskController taskController = new TaskController();

            int insert = taskController.addJob(jobModel);


            if(insert>0){

                JOptionPane.showMessageDialog(null, "Job Created Successfully");

            }

            else{
                JOptionPane.showMessageDialog(null, "Failed to create job");
            }
        }

    }








    public static void main(String[] args) {
        new Create_Job().setVisible(true);
    }
}