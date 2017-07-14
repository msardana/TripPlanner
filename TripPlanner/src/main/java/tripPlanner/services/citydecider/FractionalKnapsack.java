package tripPlanner.services.citydecider;

import tripPlanner.interfaces.KnapsackInterface;

/**
 *  Program to implementing a fractional knapsack problem
 *  
 *  In this problem we have a Knapsack that has a weight limit W.
 *  There are items i1, i2, ..., in each having weight w1, w2, … wn and some benefit (value or profit) associated with it v1, v2,.., vn.
 *  Our objective is to maximize the benefit such that the total weight inside the knapsack is at most W
 *  And we are also allowed to take an item in fractional part
*/

public class FractionalKnapsack implements KnapsackInterface {

	
	
	public FractionalKnapsack() {
		super();
	}

	private Integer getNext(double rank[]) {
        double highest = 0;
        Integer index = -1;
        for (Integer i = 0; i < rank.length; ++i) {
            if (rank[i] > highest) {
                highest = rank[i];
                index = i;
            }
        } 
        return index;
    }
	
	
	
	/**
	 * Input
	 * weight[] represents the time required to cover a particular city. Unit is in days.
	 * profit[] represents the score of each city. It tells the priority of a particular city.Highest priority is for the maximum score.
	 * W represents the total days chosen by the user to travel.
	*/
	
	@Override
	public double[] optimize(int[] weight, int[] profit, int W) {
		double cW = 0; 												//current weight
        int n = weight.length;
        double rank[]=new double[n];
        double solution[] = new double[n];
        for (int i = 0; i < weight.length; ++i) {
            rank[i] = profit[i] / (float)weight[i]; 
        }
        
        
        while (cW < W) {
            int item = getNext(rank);        						//next highest rank
            if (item == -1) {
                													//No items left
                break;
            }

            if (cW + weight[item] <= W) {
                cW += weight[item];
                rank[item] = 0;
                solution[item] = 1;
            } else {
                solution[item] = (W - cW)/weight[item];
                cW += (W - cW);
                break;  											//the knapsack is full
            }
        }

		return solution;											//Solution matrix decides which city to leave out of tour
	}        
}
