package tripPlanner.services.citydecider;

import tripPlanner.interfaces.KnapsackInterface;


/**
 *  Program to implementing a 0/1 knapsack problem
 *  
 *  Given weights and values of n items, put these items in a knapsack of capacity W 
 *  to get the maximum total value in the knapsack. In other words,
 *  given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights
 *  associated with n items respectively. Also given an integer W which represents knapsack capacity, 
 *  find out the maximum value subset of val[] such that sum of the weights of this subset is 
 *  smaller than or equal to W. You cannot break an item, either pick the complete item, 
 *  or don’t pick it (0-1 property).
 *  
*/

public class ZeroOneKnapsack implements KnapsackInterface {

	public ZeroOneKnapsack() {
		super();
	}
	
	
	/**
	 * Input
	 * weight[] represents the time required to cover a particular city. Unit is in days.
	 * profit[] represents the score of each city. It tells the priority of a particular city. Highest priority is for the maximum score.
	 * W represents the total days chosen by the user to travel.
	*/
	
	@Override
	public double[] optimize(int[] weight, int[] profit, int W) {
		int k,w,i;
		int n = weight.length;
		int[] B = new int[W+1];
		double solution[]=new double[n];
		int keep[][] = new int[n][W+1];
		for(k=0;k<n;k++){
			for(w=W;w>=weight[k];w--){
				if(B[w-weight[k]]+profit[k]>B[w]){
					B[w]=B[w-weight[k]]+profit[k];
					keep[k][w]=1;
				}
				else{
					keep[k][w]=0;
				}
			}
		}
		
		
		k=W;
		for(i=n-1;i>=0;i--){
			if(keep[i][k]==1){
				solution[i]=1;
				k=k-weight[i];
			}
		}
		return solution;											//Solution matrix decides which city to leave out of tour
	}

}
