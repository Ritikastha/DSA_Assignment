package Model;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//



public class TaskModel {
    String Task_Name;
    int Task_Id;

    public TaskModel() {
    }

    public TaskModel(String Taskname, int Taskid) {
        this.Task_Name = Taskname;
        this.Task_Id = Taskid;
    }

    public void setTask_Name(String Taskname) {
        this.Task_Name = Taskname;
    }

    public void setTask_Id(int Taskid) {
        this.Task_Id = Taskid;
    }

    public String getTask_Name() {
        return this.Task_Name;
    }

    public int getTask_Id() {
        return this.Task_Id;
    }
}
