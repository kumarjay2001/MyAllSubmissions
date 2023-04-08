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
    public ListNode partition(ListNode head, int x) {
        ListNode dummyval=new ListNode(-300);
        ListNode dummy=dummyval;
        // dummy=dummy.next;
        ListNode curr=head;
        while(curr!=null){
            if(curr.val<x){
                ListNode temp=new ListNode(curr.val);
                dummy.next=temp;
                dummy=dummy.next;
                curr.val=-300;
               
            }
             curr=curr.next;
        }
        curr=head;
        while(curr!=null){
            if(curr.val!=-300){
               ListNode temp=new ListNode(curr.val);
                dummy.next=temp;
                dummy=dummy.next;
                // curr.val=-1;
            }
             curr=curr.next;
        }
        return dummyval.next;
    }
}