class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    public int maxDistance(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new Pair(i,j));
                }
            }
        }
        int []fis={-1,0,1,0};
        int []ris={0,1,0,-1};
        if(q.size()==0 || q.size()==grid[0].length*grid.length){
            return -1;
        }
        int lvl=-1;
        while(!q.isEmpty()){
            lvl++;
            int ni=q.size();
            while(ni-->0){
                int r=q.peek().r;
                int c=q.peek().c;
                q.remove();
                for(int i=0;i<4;i++){
                    int nr=r+fis[i];
                    int nc=c+ris[i];
                    if(nr<0 || nc<0 || nr>=grid.length || nc>=grid[0].length || grid[nr][nc]==1){
                        continue;
                    }
                    q.add(new Pair(nr,nc));
                    grid[nr][nc]=1;
                }
            }
        }
        return lvl;
    }
}