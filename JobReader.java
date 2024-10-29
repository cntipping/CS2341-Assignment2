import java.io.*;
import java.util.*;

public class JobReader{
    public static List<Job> jobReader(String fileName){
        List<Job> jobs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(" ");
                int id = Integer.parseInt(parts[0]);
                int processingTime = Integer.parseInt(parts[1]);

                if (parts.length == 2){
                    jobs.add(new Job(id, processingTime));
                } else if (parts.length == 3){
                    int priority = Integer.parseInt(parts[2]);
                    jobs.add(new Job(id, processingTime, priority));
                } else if (parts.length == 4){
                    int priority = Integer.parseInt(parts[2]);
                    int arrivalTime = Integer.parseInt(parts[3]);
                    jobs.add(new Job(id, processingTime, priority, arrivalTime));
                } else{
                    throw new IllegalArgumentException("Wrong number of arguments");
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return jobs;
    }
}
