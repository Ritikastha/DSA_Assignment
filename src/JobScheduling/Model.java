package JobScheduling;

public class Model {

    private int profit;
    private int deadline;
    private int jobId;

    public Model(int jobId, int profit, int deadline) {
        this.jobId = jobId;
        this.profit = profit;
        this.deadline = deadline;
    }

    public int getProfit() {
        return this.profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public int getDeadline() {
        return this.deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getJobId() {
        return this.jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
}


