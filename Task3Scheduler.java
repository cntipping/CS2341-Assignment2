import java.util.*;

public class Task3Scheduler {
    public static void main(String[] args){

        List<Job> jobs = JobReader.jobReader("task3-input.txt");

        jobs.sort(Comparator.comparingInt(j -> j.getArrivalTime()));

        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(j -> j.getArrivalTime()));

        List<Integer> executionOrder = new ArrayList<>();
        int totalTime =0, completionTime = 0, currentTime = 0;
        int i = 0;

        while(i < jobs.size() || !pq.isEmpty()){
            while(i < jobs.size() && jobs.get(i).getArrivalTime() <= currentTime){
                pq.offer(jobs.get(i));
                i++;
            }

            if (!pq.isEmpty()){
                Job job = pq.poll();
                currentTime += job.getProcessingTime();
                completionTime += currentTime - job.getArrivalTime();
                executionOrder.add(job.getId());
            } else {
                currentTime++;
            }
        }

        double averageCompletionTime = (double) completionTime / jobs.size();
        System.out.println("Execution order: " + executionOrder);
        System.out.println("Average completion time: " + averageCompletionTime);
    }
}
