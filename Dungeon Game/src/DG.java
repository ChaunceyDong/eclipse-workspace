
public class DG {

	public static void main(String[] args) {

		new DG().text();
		
	
}
	void text() {
		Solution s =new Solution();
		int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };

		for(int t = 0;t<dungeon.length;t++)
			for(int l=0; l<dungeon[0].length;l++) {
				System.out.print(dungeon[t][l] + " ");
				if( l ==dungeon[0].length - 1)
					System.out.println();
			}
		
		s.calculateMinimumHP(dungeon);
		
		for(int t = 0;t<dungeon.length;t++)
			for(int l=0; l<dungeon[0].length;l++) {
				System.out.print(dungeon[t][l] + " ");
				if( l ==dungeon[0].length - 1)
					System.out.println();
			}
		
	}
}

class Solution {
	
    public int calculateMinimumHP(int[][] dungeon) {
        int x, y;
        x = dungeon.length;
        y = dungeon[0].length;
        for(int i = x-1; i>=0; i--){
          for(int j = y-1; j>=0; j--){
        	  dungeon[i][j] = minHP(dungeon,i,j);
          }
        }
        
        return 0;
    }
    
    int minHP(int[][] dungeon ,int m, int n) {
    	int x, y;
        x = dungeon.length;
        y = dungeon[0].length;
        
        if(m == x-1&&n==y-1)
        	return Math.max(1, 1-dungeon[m][n]);
        if(m == x-1)
        	return Math.max(1, dungeon[m][n+1]-dungeon[m][n]);
    	if(n == y-1)
    		return Math.max(1, dungeon[m+1][n]-dungeon[m][n]);
    	return Math.max(1, Math.min(dungeon[m+1][n], dungeon[m][n+1])-dungeon[m][n]);
    }
    
    
}