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
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null ){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head2=slow;
        prev.next=null;
        head2=reverse(head2);
       // return head2.val;
        int maxo=0;
        while(head!=null && head2!=null){
            maxo=Math.max(maxo,head.val+head2.val);
            head=head.next;
            head2=head2.next;
        }
        return maxo;
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
        
    }
}