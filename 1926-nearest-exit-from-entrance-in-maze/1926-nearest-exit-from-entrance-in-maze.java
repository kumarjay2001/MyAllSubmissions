class Solution {
    class Pair{
        int r;
        int c;
        int d;
        Pair(int r,int c,int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    int ans=-1;
    public int nearestExit(char[][] maze, int[] entrance) {
       int m=maze.length;
       int n=maze[0].length;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(entrance[0],entrance[1],0));
        int []fcol={-1,1,0,0};
        int []frow={0,0,1,-1};
        while(!q.isEmpty()){
            int r=q.peek().r;
            int c=q.peek().c;
            int d=q.peek().d;
            q.remove();
            maze[r][c]='+';
            for(int i=0;i<4;i++){
                int nr=r+frow[i];
                int nc=c+fcol[i];
                if(nr>=0 && nc>=0 && nr<m && nc<n && maze[nr][nc]=='.'){
                    maze[nr][nc]='+';
                    q.add(new Pair(nr,nc,d+1));
                    if(nr==0 || nr==m-1 || nc==0 || nc==n-1){
                        ans=d+1;
                       return ans;
                    }
                }
            }
        }
        return -1;
        
    }
}