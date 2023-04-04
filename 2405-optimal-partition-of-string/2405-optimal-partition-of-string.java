class Solution {
    public int partitionString(String s) {
        int []lastseen=new int[26];
        Arrays.fill(lastseen,-1);
        int count=0;
        int scs=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(lastseen[ch-'a']>=scs){
                count++;
                scs=i;
               
            }
             lastseen[ch-'a']=i;
        }
        return count+1;
        
    }
}