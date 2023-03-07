/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        
        int [][]matrix=new int[m][n];
        if(head==null){
            return matrix;
        }
        int strow=0,stcol=0,endrow=m-1,endcol=n-1;
    while( strow<=endrow && stcol<=endcol){
        for(int i=stcol;i<=endcol;i++){
            if(head!=null){
                  matrix[strow][i]=head.val;
                  head=head.next;
            }else{
                 matrix[strow][i]=-1;
            }
           
        }
        for(int j=strow+1;j<=endrow;j++){
            if(head!=null){
                matrix[j][endcol]=head.val;
                head=head.next;
            }else{
                 matrix[j][endcol]=-1;
            }
            
        }
        for(int i=endcol-1;i>=stcol;i--){
            if(strow==endrow){
                break;
            }
            if(head!=null){
                 matrix[endrow][i]=head.val;
                 head=head.next;
            }else{
                 matrix[endrow][i]=-1;
            }
           
        }
        for(int j=endrow-1;j>=strow+1;j--){
            if(stcol==endcol){
                break;
            }
            if(head!=null){
                    matrix[j][stcol]=head.val;
                    head=head.next;
            }
            else{
                 matrix[j][stcol]=-1;
            }
        
        }
        strow++;endrow--;stcol++;endcol--;
    }
       
        return matrix;
    }
}