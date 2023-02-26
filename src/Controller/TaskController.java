
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Controller;

import Database.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.JobModel;
import Model.JobTaskModel;
import Model.TaskModel;


public class TaskController {
    DatabaseConnection db = new DatabaseConnection();

    public TaskController() {
    }

    public int addTask(TaskModel taskModel) {
        try {
            String query = "insert into Task_Table(Task_Id,Task_Name) values(?,?)";
            PreparedStatement st = this.db.connection.prepareStatement(query);
            st.setString(1, taskModel.getTask_Name());
            st.setInt(2, taskModel.getTask_Id());
            return this.db.manipulate(st);
        } catch (SQLException var4) {
            var4.printStackTrace();
            return 0;
        }
    }

    public int addJob(JobModel jobModel) {
        try {
            String query = "insert into Job_Table(Job_Id, Job_Name,Job_Profit, Job_Deadline, Num_Of_Task) values(?,?,?,?,?)";
            PreparedStatement st = this.db.connection.prepareStatement(query);
            st.setInt(1, jobModel.getJobId());
            st.setString(2, jobModel.getJob_Name());
            st.setInt(3, jobModel.getProfit());
            st.setInt(4, jobModel.getTime());
            st.setInt(5, jobModel.getNum_Of_Task());

            return this.db.manipulate(st);
        } catch (SQLException var4) {
            var4.printStackTrace();
            return 0;
        }
    }

    public ArrayList<Integer> fetchTask() {
        TaskModel taskModel = null;
        ArrayList idList = new ArrayList();

        try {
            String query = "select * from Task_Table";
            PreparedStatement ps = this.db.connection.prepareStatement(query);
            ResultSet resultSet = this.db.retrieve(ps);

            while(resultSet.next()) {
                idList.add(resultSet.getInt("Task_Id"));
                taskModel = new TaskModel();
                taskModel.setTask_Id(resultSet.getInt("Task_Id"));
                taskModel.setTask_Name(resultSet.getString("Task_Name"));
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }
        return idList;
    }

    public int addJobTask(JobTaskModel jobTaskModel) {
        try {
            String query = "insert into Job_Task_Table(Job_Id , Source_Task, Destination_Task) values(?,?,?)";
            PreparedStatement st = this.db.connection.prepareStatement(query);
            st.setInt(1, jobTaskModel.getJobId());
            st.setInt(2, jobTaskModel.getSource());
            st.setInt(3, jobTaskModel.getDestination_Task());
            return this.db.manipulate(st);
        } catch (SQLException var4) {
            var4.printStackTrace();
            return 0;
        }
    }

    public JobModel fetchJobBYId(Integer id) {
        JobModel jobModel = null;

        try {
            String query = "select * from Job_Table where Job_Id=?";
            PreparedStatement ps = this.db.connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet resultSet = this.db.retrieve(ps);

            while(resultSet.next()) {
                jobModel = new JobModel();
                jobModel.setJobId(resultSet.getInt("Job_Id"));
                jobModel.setJob_Name(resultSet.getString("Job_Name"));
                jobModel.setNum_Of_Task(resultSet.getInt("Num_Of_Task"));
                jobModel.setTime(resultSet.getInt("Job_Deadline"));
                jobModel.setProfit(resultSet.getInt("Job_Profit"));
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return jobModel;
    }

    public ArrayList<JobModel> fetchJob() {
        JobModel jobModel = null;
        ArrayList<Integer> idList = new ArrayList();
        ArrayList job = new ArrayList();

        try {
            String query = "select * from Job_Table";
            PreparedStatement ps = this.db.connection.prepareStatement(query);
            ResultSet resultSet = this.db.retrieve(ps);

            while(resultSet.next()) {
                idList.add(resultSet.getInt("Job_Id"));
                jobModel = new JobModel();
                jobModel.setJobId(resultSet.getInt("Job_Id"));
                jobModel.setJob_Name(resultSet.getString("Job_Name"));
                jobModel.setNum_Of_Task(resultSet.getInt("Num_Of_Task"));
                jobModel.setProfit(resultSet.getInt("Job_Profit"));
                jobModel.setTime(resultSet.getInt("Job_Deadline"));
                job.add(jobModel);
            }
        } catch (SQLException var7) {
            var7.printStackTrace();
        }

        return job;
    }

    public ArrayList<JobTaskModel> fetchTaskModels(int jobId) {
        ArrayList list = new ArrayList();

        try {
            String query = "select * from Job_Task_Table where Job_Id=?";
            PreparedStatement ps = this.db.connection.prepareStatement(query);
            ps.setInt(1, jobId);
            ResultSet resultSet = this.db.retrieve(ps);

            while(resultSet.next()) {
                JobTaskModel jtm = new JobTaskModel();
                jtm.setJobId(resultSet.getInt("Job_Id"));
                jtm.setSource(resultSet.getInt("Source_Task"));
                jtm.setDestination_Task(resultSet.getInt("Destination_Task"));
                list.add(jtm);
            }
        } catch (SQLException var7) {
            var7.printStackTrace();
        }

        return list;
    }

    public TaskModel getTaskById(Integer id) {
        TaskModel taskModel = new TaskModel();

        try {
            String query = "select * from Task_Table where Task_Id=?";
            PreparedStatement ps = this.db.connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet resultSet = this.db.retrieve(ps);

            while(resultSet.next()) {
                taskModel.setTask_Id(resultSet.getInt("Task_Id"));
                taskModel.setTask_Name(resultSet.getString("Task_Name"));
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return taskModel;
    }

    public List<JobModel> getAllJob() {
        ArrayList jobs = new ArrayList();

        try {
            String query = "select * from Job_Table";
            PreparedStatement ps = this.db.connection.prepareStatement(query);
            ResultSet resultSet = this.db.retrieve(ps);

            while(resultSet.next()) {
                JobModel j = new JobModel();
                j.setJobId(resultSet.getInt("jobId"));
                j.setJob_Name(resultSet.getString("jobName"));
                j.setNum_Of_Task(resultSet.getInt("numOfTask"));
                j.setProfit(resultSet.getInt("jobProfit"));
                j.setTime(resultSet.getInt("deadline"));
                jobs.add(j);
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return jobs;
    }
}
