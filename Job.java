public class Job{
    private int id, processingTime, priority, arrivalTime;

    // Constructor for task1
    public Job(int id, int processingTime){
        this.id = id;
        this.processingTime = processingTime;
        priority = -1;
        arrivalTime = -1;
    }

    // Constructor for task2
    public Job(int id, int processingTime, int priority){
        this.id = id;
        this.processingTime = processingTime;
        this.priority = priority;
        arrivalTime = -1;
    }

    // Constructor for task3
    public Job(int id, int processingTime, int priority, int arrivalTime){
        this.id = id;
        this.processingTime = processingTime;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
    }

    public int getId(){ return id;}
    public int getProcessingTime(){return processingTime;}
    public int getPriority(){return priority;}
    public int getArrivalTime(){return arrivalTime;}
}
