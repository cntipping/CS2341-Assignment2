public class Job{
    private int id, processingTime;

    public Job(int id, int processingTime){
        this.id = id;
        this.processingTime = processingTime;
    }

    public int getId(){ return id;}

    public int getProcessingTime(){return processingTime;}
}
