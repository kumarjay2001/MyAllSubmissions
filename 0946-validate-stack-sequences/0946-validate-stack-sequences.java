class Solution {
   public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int l = 0;
        for (int i : pushed) {
            st.push(i);
            while (!st.empty() && st.peek() == popped[l]) {
                st.pop();
                l++;
            }
        }
        return st.empty();
    }
}