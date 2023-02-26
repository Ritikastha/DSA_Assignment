import Controller.TaskController;

import JobScheduling.Sequence;
import Model.JobModel;
import Model.JobTaskModel;
import Model.TaskModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Timer;
import java.util.*;

public class Job_Start extends JFrame {

    int count = 0;
    TaskController taskController = new TaskController();
    JPanel frame;
    JLabel Job;
    JLabel Select_Job;

    JScrollPane job;
    ScrollLabel t;
    String text="";

    JButton backbtn;
    JButton stopbtn;
    JButton JBtn;

    Job_Start(){
        setTitle("Start Job");
        setSize(800, 700 );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane();

        frame =new JPanel();
        frame.setBounds(120,50,550,550);
        frame.setBackground(new Color(0x58C4BA));
        add(frame);

        initilize();
    }
    void initilize(){


        backbtn = new JButton("Back");
        backbtn.setBounds(0, 10, 75, 25);
        backbtn.setFont(new Font("Roboto", Font.BOLD, 15));
        backbtn.setBackground(new Color(0x24A692));
        backbtn.setFocusPainted(false);
        backbtn.setForeground(Color.white);
        add(backbtn);
        backbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_Task_Page addTaskPage = new Add_Task_Page();
                addTaskPage.show();
                dispose();
            }
        });



        Select_Job = new JLabel("Select Job");
        Select_Job.setFont(new Font("San Serif", Font.PLAIN, 20));
        Select_Job.setBounds(250,150,200,25);
        Select_Job.setForeground(Color.black);
        add(Select_Job);
        add(frame);

        Job = new JLabel("Job Here");
        Job.setFont(new Font("San Serif", Font.PLAIN, 20));
        Job.setBounds(250,210,200,25);
        add(Job);
        add(frame);

        t=new ScrollLabel(text);
        t.setBounds(350,150,160,25);
        t.setFont(new Font("San Serif", Font.PLAIN, 15));
//        add(t);
//        add(frame);

        job =new JScrollPane(t);
        job.setBounds(350,210,160,25);
        job.setVisible(true);
        add(job);

        JBtn = new JButton("Start Job");
        JBtn.setBounds(310,280,160,40);
        JBtn.setForeground(Color.white);
        JBtn.setFocusPainted(false);
        JBtn.setBackground(new Color(0x24A692));
        JBtn.setFont(new Font("San Serif", Font.PLAIN, 20));
        add(JBtn);
        add(frame);

        stopbtn = new JButton("Job Completed");
        stopbtn.setBounds(290,350,200,40);
        stopbtn.setForeground(Color.white);
        stopbtn.setFocusPainted(false);
        stopbtn.setBackground(new Color(0x24A692));
        stopbtn.setFont(new Font("San Serif", Font.PLAIN, 20));
        add(stopbtn);
        add(frame);

       JBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(null, "job started");
               try {
                   jobShedule();
               } catch (InterruptedException ex) {
                   ex.printStackTrace();
               }
           }
       });



    }
    public void topoSort(int jobId){
//        int jobId = Integer.parseInt(String.valueOf(jobs.getSelectedItem()));

        JobModel jobModel = taskController.fetchJobBYId(jobId);
        int vertixes = jobModel.getNum_Of_Task();
        System.out.println("i am vertix: "+vertixes);
        Graph graph = new Graph(vertixes);

        ArrayList<JobTaskModel> jtm = taskController.fetchTaskModels(jobId);
        System.out.println("I am arrat list of task");
        for(int i=0; i<jtm.size(); i++){
            graph.add_Edge(jtm.get(i).getSource(),jtm.get(i).getDestination_Task());
        }

        int[] tasks=graph.topology_Sort();

        for (int i=0; i<tasks.length; i++){
            TaskModel tm =new TaskModel();
            tm=taskController.getTaskById(tasks[i]);
            System.out.println(tm.getTask_Name());
             text+= tm.getTask_Name()+"->";
             t.setText(text);

        }
    }

    public void jobShedule() throws InterruptedException {

        ArrayList<JobModel> jobModels = taskController.fetchJob();
        Sequence sequencingJob = new Sequence();
        ArrayList<JobScheduling.Model> jminsc=new ArrayList<>();


        //creating job model from the job model retreved from database
        for(int i=0; i<jobModels.size(); i++){
          JobScheduling.Model jobm = new JobScheduling.Model(jobModels.get(i).getJobId(),jobModels.get(i).getProfit(),jobModels.get(i).getTime());

            jminsc.add(jobm);
        }

        List<Integer> scheduledJobs = new ArrayList<Integer>();
        scheduledJobs=sequencingJob.scheduling(jminsc);
        int[] allTask =  new int[scheduledJobs.size()];
        int[] allTime = new int[scheduledJobs.size()];

        for(int i=0; i<scheduledJobs.size(); i++){
            JobModel JM = taskController.fetchJobBYId(scheduledJobs.get(i));
             allTime[i]=JM.getTime();
             allTask[i]=JM.getJobId();

        }
        //created list of executables tasks
        System.out.println(Arrays.toString(allTask));
        Runnable[] TASKS = new Runnable[allTask.length];
        for(int tim = 0; tim<allTime.length;tim++) {

            int finalTim = tim;
            TimerTask task = new TimerTask() {
            @Override
            public void run() {

                    text="";
                    t.setText(text);

                    System.out.println("run task");
                    JobModel job = taskController.fetchJobBYId(allTask[finalTim]);

                    String jobName = job.getJob_Name();
                    System.out.println(jobName);
                    Job.setText(jobName);
                    topoSort(allTask[finalTim]);


                }
            };
            TASKS[tim]=task;
        }
        for(int i=0; i<allTime.length; i++){

        }

        //list of date object of when task will execute
        ArrayList<Calendar> TIMES = new ArrayList<>();
       for(int timeTo=0; timeTo<allTime.length;timeTo++){
           Calendar date = Calendar.getInstance();
           date.set(Calendar.HOUR_OF_DAY,4);
           date.set(Calendar.MINUTE,allTime[timeTo]);
           date.set(Calendar.SECOND,0);
           TIMES.add(date);
           System.out.println(date.getTime());
       }


       //executing tasks in the given time
        Timer timer = new Timer();
        for(int i=0; i<TASKS.length; i++){
            final int index=i;
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    TASKS[index].run();;
                }
            };
            timer.schedule(task,TIMES.get(i).getTime());
        }

    }

    public static void main(String[] args) {
        new Job_Start().setVisible(true);
    }


}
