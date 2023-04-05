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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        ListNode ans=new ListNode();
        ans.next=head;
        ListNode temp=ans;
        while(temp.next!=null && temp.next.next!=null){
            if(temp.next.val==temp.next.next.val){
                int value=temp.next.val;
                while(temp.next!=null && temp.next.val==value){
                    temp.next=temp.next.next;
                }
            }else{
                temp=temp.next;
            }
        }
        return ans.next;
    }
}