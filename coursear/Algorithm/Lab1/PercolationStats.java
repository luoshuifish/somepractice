import java.util.ArrayList;


public class PercolationStats {
	
	private int count;
	private ArrayList<Double> listSet = new ArrayList<Double>();
	private double mean;
	private double stddev;
	private int number;
	
	public PercolationStats(int N, int T) {
		// perform T independent computational experiments on an N-by-N grid
		throwError(N,T);
		count = T;
		number = N;
		while (count > 0) {
			int testCount = 0;
			Percolation percolation = new Percolation(N);
			
			int[] n = new int[N*N];
			for (int i = 0; i < n.length; i++) {
				n[i] = i+1;
			}
			StdRandom.shuffle(n);
			for (int i = 0; i < n.length; i++) {

				if (n[i]%N != 0) {
					percolation.open(n[i]/N + 1, n[i] - (n[i]/N)*N);

				}else {
					percolation.open(n[i]/N, N);
				}
				testCount++;
				if (percolation.percolates()) { 
					break;
				}
			}
			double temp = (double)testCount/(double)(number * number);
			listSet.add(temp);
			count = count -1;
			
		}
	}
	private void throwError(int n, int t) {
		// TODO Auto-generated method stub
		if (n <= 0 || t <= 0)	throw new IndexOutOfBoundsException(); 
		
	}
	public double mean() {
		double sum = 0;
		for (Double number : listSet) {
			sum = sum + number;
		}
		mean = sum/(double)listSet.size();
		return mean;
	}
	public double stddev() {
		double stdSum = 0;
		for (Double number : listSet) {
			stdSum = stdSum + ((double)number -mean())*((double)number -mean());
		}
		
		stddev = Math.sqrt(stdSum/(listSet.size()-1));
		return stddev;
	}
	public double confidenceLo() {
		
		return mean() - 1.96*stddev/Math.sqrt(listSet.size());
	}
	public double confidenceHi(){
		return mean() + 1.96*stddev/Math.sqrt(listSet.size());		   
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//PercolationStats percolationStats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		PercolationStats percolationStats = new PercolationStats(-23, 100);
		
		System.out.println("mean="+percolationStats.mean());
		System.out.println("stddev="+percolationStats.stddev());
		System.out.println("95% confidence interval="+percolationStats.confidenceLo()+","+percolationStats.confidenceHi());
	}

}
