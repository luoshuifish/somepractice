
public class Percolation {
	
	private  int[][] status;
	
	private static int FULL = 0;
	private static int EMPTY = 1;
	
	private WeightedQuickUnionUF uf;
	
	
	private int num;
	
	public Percolation(int N){
		
		num = N;
		
		status = new int[N][N];
		
		//init
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				status[i][j] = FULL;
			}
		}
		
		uf = new WeightedQuickUnionUF(N*N);
	}
	
	public void open(int i, int j){
		if (!isOpen(i, j)){
			status[i-1][j-1] = EMPTY;
			
			//上
			if (isValid(i-1,j)){
				if (isOpen(i-1,j)){
					uf.union(pToUnion(i, j),pToUnion(i-1, j));
				}
			}
			
			//下
			if (isValid(i+1,j)){
				if (isOpen(i+1,j)){
					uf.union(pToUnion(i, j),pToUnion(i+1, j));
				}
			}
			
			//左
			if (isValid(i,j-1)){
				if (isOpen(i,j-1)){
					uf.union(pToUnion(i, j),pToUnion(i, j-1));
				}
			}
			
			//右
			if (isValid(i,j+1)){
				if (isOpen(i,j+1)){
					uf.union(pToUnion(i, j),pToUnion(i, j+1));
				}
			}
			
		}else{
			return;
		}
		
	}
	
	
	private boolean isValid(int i, int j) {
		// TODO Auto-generated method stub
		return (i>=1 && i<=num && j>=1 && j<=num);
	}

	//两种坐标系间的转换，即Percolation与WeightedQuickUnionUF
	private int pToUnion(int i, int j){
		
		return (i-1)*num + (j-1);
		
	}
	
	public boolean isOpen(int i, int j){
		
		return status[i-1][j-1] == EMPTY;
		
	}
	
	public boolean isFull(int i, int j){
		
		if (!isOpen(i,j)) return false;

		
		for (int j1 = 1; j1 <= num; j1++) {
			if (isOpen(1,j1) && uf.connected(pToUnion(i, j),pToUnion(1, j1))) return true;
		}
		
		return false;
	}
	
	public boolean percolates(){
		for (int j1 = 1; j1 <= num; j1++){
			if (isFull(num,j1)) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Percolation per = new Percolation(4);
		System.out.println(per.isValid(-5,4));

	}
	
	
}
