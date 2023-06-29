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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        int size=1;
        ListNode temp=head;
        while(temp.next!=null){
            size++;
            temp=temp.next;
        }
        temp.next=head;
        ListNode curr=head;
        k=k%size;
        for(int i=0;i<size-k-1;i++){
            curr=curr.next;
            
        }
        head=curr.next;
        curr.next=null;
        return head;
    }
}