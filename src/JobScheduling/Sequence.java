package JobScheduling;

import java.util.*;

public class Sequence {
    public Sequence() {
    }

    public List<Integer> scheduling(ArrayList<Model> js) {
        Compare cs = new Compare();
        Collections.sort(js, cs);
        List<Integer> scheduledJobs = new ArrayList();
        Set<Integer> usedDeadlines = new HashSet();
        Iterator var5 = js.iterator();


        while(true) {
            while(var5.hasNext()) {
                Model job = (Model)var5.next();

                for(int i = job.getDeadline(); i >= 1; --i) {
                    if (!usedDeadlines.contains(i)) {
                        scheduledJobs.add(job.getJobId());
                        usedDeadlines.add(i);
                        break;
                    }
                }
            }

            System.out.println("Scheduled jobs: " + scheduledJobs);
            return scheduledJobs;
        }
    }

    public static void main(String[] args) {
        Model p1 = new Model(11, 70, 2);
        Model p2 = new Model(12, 100, 1);
        Model p3 = new Model(13, 20, 3);
        Model p4 = new Model(14, 40, 2);
        Model p5 = new Model(15, 20, 1);
        ArrayList<Model> input = new ArrayList();
        input.add(p1);
        input.add(p2);
        input.add(p3);
        input.add(p4);
        input.add(p5);
        Sequence s = new Sequence();
        s.scheduling(input);
    }
}
