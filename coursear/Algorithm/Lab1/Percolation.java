
public class Percolation {
	
	private  int[][] status;
	
	private  int FULL = 0;
	private  int EMPTY = 1;
	
	private WeightedQuickUnionUF uf;
	private WeightedQuickUnionUF ufTemp;

	
	
	private int num;
	
	public Percolation(int N) {
		
		num = N;
		
		status = new int[N][N];
		
		//init
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				status[i][j] = FULL;
			}
		}
		
		uf = new WeightedQuickUnionUF(N*N + 2);
		ufTemp = new WeightedQuickUnionUF(N*N + 2);

	}
	
	public void open(int i, int j) {
		if (!isOpen(i, j)) {
			status[i-1][j-1] = EMPTY;
			
			if (i == 1)  {
				uf.union(pToUnion(i, j), num*num);
				ufTemp.union(pToUnion(i, j), num*num);
			}
			
			if (i == num) ufTemp.union(pToUnion(i, j), num*num + 1);
			
			//上
			if (isValid(i-1, j)) {
				if (isOpen(i-1, j)) {
					uf.union(pToUnion(i, j), pToUnion(i-1, j));
					ufTemp.union(pToUnion(i, j), pToUnion(i-1, j));

				}
			}
			
			//下
			if (isValid(i+1, j)) {
				if (isOpen(i+1, j)) {
					uf.union(pToUnion(i, j), pToUnion(i+1, j));
					ufTemp.union(pToUnion(i, j), pToUnion(i+1, j));

				}
			}
			
			//左
			if (isValid(i, j-1)) {
				if (isOpen(i, j-1)) {
					uf.union(pToUnion(i, j), pToUnion(i, j-1));
					ufTemp.union(pToUnion(i, j), pToUnion(i, j-1));
					
				}
			}
			
			//右
			if (isValid(i, j+1)) {
				if (isOpen(i, j+1)) {
					uf.union(pToUnion(i, j), pToUnion(i, j+1));
					ufTemp.union(pToUnion(i, j), pToUnion(i, j+1));
				}
			}
			
		} else {
			return;
		}
		
	}
	
	
	private boolean isValid(int i, int j) {
		// TODO Auto-generated method stub
		return (i >= 1 && i <= num && j >= 1 && j <= num);
	}

	//两种坐标系间的转换，即Percolation与WeightedQuickUnionUF
	private int pToUnion(int i, int j) {
		
		return (i-1)*num + (j-1);
		
	}
	
	public boolean isOpen(int i, int j) {
		
		return status[i-1][j-1] == EMPTY;
		
	}
	
	public boolean isFull(int i, int j) {
		
		return (isOpen(i, j) && uf.connected(num*num, pToUnion(i, j)));
	}
	
	public boolean percolates() {
			
		return ufTemp.connected(num*num, num*num + 1);
	}
	
	
	
}
