package tripPlanner.interfaces;


/**
 * This is a java program to implement a standard fractional knapsack problem. 
 * It is an algorithmic problem in combinatorial optimization in which the goal is to fill a container (the “knapsack”) 
 * with amounts of different materials chosen to maximize the value of the selected materials.
*/

public interface KnapsackInterface {

	
	
	/**
	 * Input
	 * weight[] represents the time required to cover a particular city. Unit is in days.
	 * profit[] represents the score of each city. It tells the priority of a particular city. Highest priority is for the maximum score.
	 * W represents the total days chosen by the user to travel.
	*/
	public double[] optimize(int[] days_incities,int[] priority_scores,int W);



}
