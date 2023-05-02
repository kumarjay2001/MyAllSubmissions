class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < indices.length; i++)
            map.put(indices[i], i);
        
        int len = s.length();
        for(int i = 0; i < len; i++){
            if(map.containsKey(i)){
                int indice = map.get(i);
                if(s.substring(indices[indice], sources[indice].length() + indices[indice]).equals(sources[indice])){
                    sb.append(targets[indice]);
                    i+=sources[indice].length()-1;
                    continue;
                }
            }
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}