class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] vis=new boolean[rooms.size()];
        dfs(rooms.get(0),0,rooms,vis);
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                return false;
            }
        }
        return true;
    }
    public void dfs(List<Integer> romi,int key,List<List<Integer>> rooms,boolean []vis){
        vis[key]=true;
        for(Integer i:romi){
            if(!vis[i]){
                dfs(rooms.get(i),i,rooms,vis);
            }
        }
    }
}