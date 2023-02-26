package Assignment_Question;

import java.util.*;

/*
Question 5.b)
        Assume an electric vehicle must go from source city s to destination city d.
        You can locate many service centers along the journey that allow for the replacement of batteries; however,
        each service center provides batteries with a specific capacity. You are given a 2D array in which
        service center[i]=[xi,yj] indicates that the ith service center is xi miles from the source city and
        offers yj miles after the automobile can travel after replacing batteries at specific service centers.
        Return the number of times the car's batteries need to be replaced before arriving at the destination.
        Input: serviceCenters = [{10,60},{20,30},{30,30},{60,40}], targetMiles= 100, startChargeCapacity = 10
        Output: 2
        Explanation: The car can go 10 miles on its initial capacity; after 10 miles, the car replaces
        batteries with a capacity of 60 miles; and after travelling 50 miles, at position 60 we change batteries
        with a capacity of 40 miles; and ultimately, we may arrive at our destination.
*/
public class Q5b {
    public int num_Battery_Replace(int[][] serviceCenters, int targetMiles, int startChargeCapacity) {
//        initializes
        int count = 0;
        int currentMiles = startChargeCapacity;
//        create two ArrayLists to store the distances and capacities of the service centers.
        ArrayList<Integer> distances = new ArrayList<>();
        ArrayList<Integer> capacities = new ArrayList<>();

        for (int[] serviceCenter : serviceCenters) {
            distances.add(serviceCenter[0]);
            capacities.add(serviceCenter[1]);
        }
//        iterates through the distances of the service centers
        for (int i = 0; i < distances.size(); i++) {
//            checks if the current distance is greater than the current mileage of the car.
            if (distances.get(i) > currentMiles) {
 //       if current service center distance is greater,then the car's battery is replaced and the capacity
 //       is updated with the capacity of the previous service center
                currentMiles = capacities.get(i - 1);
//                increments
                count++;
            }
        }

//        if the car's battery can reach the targetMiles distance. If not, then the car's battery
//        is replaced
        if (currentMiles < targetMiles) {
//         the count variable is incremented.
            count++;
        }
//        return
        return count;
    }

    public static void main(String[] args) {
        int [][] serviceCenterList={{10,60},{20,30},{30,30},{60,40}};
        Q5b question1=new Q5b();
        int finalAnswer=question1.num_Battery_Replace(serviceCenterList,100,10);
        System.out.println("car's batteries need to be replaced: "+finalAnswer +"times.");
    }
}



