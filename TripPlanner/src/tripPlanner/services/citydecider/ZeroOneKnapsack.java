package tripPlanner.services.citydecider;

import tripPlanner.interfaces.KnapsackInterface;
import tripPlanner.models.CityVisitingOrder;

public class ZeroOneKnapsack implements KnapsackInterface {

	public ZeroOneKnapsack() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public CityVisitingOrder optimize(int[] weight, int[] profit, int W) {
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
		CityVisitingOrder cvd = new CityVisitingOrder();
		cvd.setOrder(solution);
		return cvd;
	}

}
