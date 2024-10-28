import java.util.*;
import java.io.*;

public class Task1Scheduler{

    public static void main(String[] args){
        List<Job> jobs = readJobFile("task1-input.txt");

        PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job job1, Job job2){
                return Integer.compare(job1.getProcessingTime(), job2.getProcessingTime());
            }
        });

        pq.addAll(jobs);

        List<Integer> executionOrder = new ArrayList<>();
        int totalTime = 0, completionTime = 0;

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

    public static List<Job> readJobFile(String fileName){

        List<Job> jobs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(" ");
                int id = Integer.parseInt(parts[0]);
                int processingTime = Integer.parseInt(parts[1]);
                jobs.add(new Job(id, processingTime));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return jobs;
    }
}
