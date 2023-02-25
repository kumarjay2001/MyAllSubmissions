class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s=new Stack<>();
        
        HashMap<Integer,Integer> hm=new HashMap<>();
//         HashMap will store the pairs of element and its next greater element
        int n=nums2.length;
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && nums2[i]>s.peek()){ 
                // we keep on poping untill we got our desired greater element
                s.pop();
            }
            if(s.isEmpty()){
                
                hm.put(nums2[i],-1); 
            }else{
                hm.put(nums2[i],s.peek());
            }
            s.push(nums2[i]);
        }
        int[] ans=new int[nums1.length];
        int k=0;
        for(int i=0;i<nums1.length;i++){          
                ans[i]=hm.get(nums1[i]);
                k++;
            
        }
        return ans;
    }
}