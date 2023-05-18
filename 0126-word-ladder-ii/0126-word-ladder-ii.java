class Solution {
    
    List<List<String>> ans;
    
    public void dfs(String endWord,String beginWord,List<String> path,Map<String,Integer> map){
        
        if(endWord.equals(beginWord)){
            List<String> pathCopy=new ArrayList<>(path);
            Collections.reverse(pathCopy);
            ans.add(pathCopy);
            return;
        }
        
        int steps=map.get(endWord);
        char arr[]=endWord.toCharArray();
        for(int i=0;i<arr.length;i++){
            char og=arr[i];
            for(char ch='a';ch<='z';ch++){
                arr[i]=ch;
                String transition=String.valueOf(arr);
                if(map.containsKey(transition) && map.get(transition)+1==steps){
                    path.add(transition);
                    dfs(transition,beginWord,path,map);
                    path.remove(path.size()-1);
                }
            }
            arr[i]=og;
        }
    }
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        ans=new ArrayList<>();
        Set<String> set=new HashSet<>();
        Set<String> vis=new HashSet<>();
        for(String a : wordList) set.add(a);
        Map<String,Integer> map=new HashMap<>();
        Queue<String> q=new ArrayDeque<>();
        vis.add(beginWord);
        q.add(beginWord);
        map.put(beginWord,0);
        
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                String temp=q.remove();
                int steps=map.get(temp);
                char arr[]=temp.toCharArray();
                for(int j=0;j<arr.length;j++){
                    char og=arr[j];
                    for(char ch='a';ch<='z';ch++){
                        arr[j]=ch;
                        String transition=String.valueOf(arr);
                        if(set.contains(transition) && !vis.contains(transition)){
                            vis.add(transition);
                            q.add(transition);
                            map.put(transition,steps+1);
                        }
                    }
                    arr[j]=og;
                }
            }
        }
        
        if(map.containsKey(endWord)){
            List<String> path=new ArrayList<>();
            path.add(endWord);
            dfs(endWord,beginWord,path,map);
        }
        
        return ans;
    }
}