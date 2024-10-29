import java.util.*;

public class Task2Scheduler {
    public static void main(String[] args) {
        List<Job> jobs = JobReader.jobReader("task2-input.txt");

        PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job job1, Job job2){
                if (job1.getPriority() != job2.getPriority()){
                    return Integer.compare(job1.getPriority(), job2.getPriority());
                } else {
                    return Integer.compare(job1.getProcessingTime(), job2.getProcessingTime());
                }
            }
        });

        pq.addAll(jobs);

        List<Integer> executionOrder = new ArrayList<>();
        int totalTime = 0, completionTime =0;

        while(!pq.isEmpty()){
            Job job = pq.poll();
            completionTime += job.getProcessingTime();
            totalTime += completionTime;
            executionOrder.add(job.getId());
        }

        double averageCompletionTime = (double) totalTime / jobs.size();
        System.out.println("Execution order: " + executionOrder);
        System.out.println("Average completion time: " + averageCompletionTime);
    }
}
