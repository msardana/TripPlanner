package tripPlanner.services.citydecider;

import tripPlanner.interfaces.KnapsackInterface;
import tripPlanner.models.CityVisitingOrder;

public class FractionalKnapsack implements KnapsackInterface {

	
	
	public FractionalKnapsack() {
		super();
		// TODO Auto-generated constructor stub
	}


	private int getNext(double rank[]) {
        double highest = 0;
        int index = -1;
        for (int i = 0; i < rank.length; ++i) {
            if (rank[i] > highest) {
                highest = rank[i];
                index = i;
            }
        } 
        return index;
    }
	
	
	@Override
	public CityVisitingOrder optimize(int[] weight, int[] profit, int W) {
		// TODO Auto-generated method stub
		double cW = 0; //current weight
        int n = weight.length;
        double rank[]=new double[n];
        double solution[] = new double[n];
        for (int i = 0; i < weight.length; ++i) {
            rank[i] = profit[i] / (float)weight[i]; 
        }
        
        
        while (cW < W) {
            int item = getNext(rank);        //next highest rank
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
                break;  //the knapsack is full
            }
        }
        
        CityVisitingOrder cvd = new CityVisitingOrder();
		cvd.setOrder(solution);
		return cvd;
	}        
}
