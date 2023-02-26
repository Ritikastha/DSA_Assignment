package Model;

public class JobTaskModel {
    private int Job_Id;
    private int Source_Task;
    private int Destination_Task;

    public JobTaskModel() {
    }

    public JobTaskModel(int jobid, int sourcetask, int destinationtask) {
        this.Job_Id = jobid;
        this.Source_Task = sourcetask;
        this.Destination_Task= destinationtask;
    }

    public void setJobId(int jobid) {
        this.Job_Id = jobid;
    }

    public void setSource(int sourcetask) {
        this.Source_Task = sourcetask;
    }

    public void setDestination_Task(int destinationtask) {
        this.Destination_Task = destinationtask;
    }

    public int getJobId() {
        return this.Job_Id;
    }

    public int getSource() {
        return this.Source_Task;
    }

    public int getDestination_Task() {
        return this.Destination_Task;
    }
}
