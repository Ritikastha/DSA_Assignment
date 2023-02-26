package Model;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class JobModel {
    private int Job_Id;
    private String Job_Name;
    private int Num_Of_Task;
    private int Time;
    private int Profit;

    public JobModel() {

    }

    public JobModel(int Job_Id, String Job_Name, int Num_Of_Task, int Time, int Profit) {
        this.Job_Id =Job_Id;
        this.Job_Name = Job_Name;
        this.Num_Of_Task = Num_Of_Task;
        this.Time =Time;
        this.Profit = Profit;
    }

    public void setJobId(int job_Id) {
        this.Job_Id = job_Id;
    }

    public int getJobId() {
        return this.Job_Id;
    }

    public String getJob_Name() {
        return this.Job_Name;
    }
    public void setJob_Name(String job_Name) {
        this.Job_Name = job_Name;
    }

    public int getNum_Of_Task() {
        return this.Num_Of_Task;
    }

    public void setNum_Of_Task(int num_Of_Task) {
        this.Num_Of_Task = num_Of_Task;
    }

    public int getTime() {
        return this.Time;
    }

    public void setTime(int time) {
        this.Time = time;
    }

    public int getProfit() {
        return this.Profit;
    }

    public void setProfit(int profit) {
        this.Profit = profit;
    }
}
