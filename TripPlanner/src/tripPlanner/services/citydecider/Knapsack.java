package tripPlanner.services.citydecider;

public class Knapsack {
	
	public int[] zero_oneknapsack(int[] weight,int[] profit,int W){
		int k,w,i;
		int n = weight.length;
		int[] B = new int[W+1];
		int solution[]=new int[n];
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
		return solution;
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
    
    public double[] fractionalknapsack(int[] weight,int[] profit,int W){
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
        
        return solution;
    }
}
