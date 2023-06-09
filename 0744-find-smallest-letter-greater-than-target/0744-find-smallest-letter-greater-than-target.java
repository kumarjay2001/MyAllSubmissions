class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n=letters.length;
        int left=0;int right=n;
        while(left<right){
            int mid=left+(right-left)/2;
            if(letters[mid]<=target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        if(left>=n){
            return letters[0];
            
        }
        return letters[left];
    }
}