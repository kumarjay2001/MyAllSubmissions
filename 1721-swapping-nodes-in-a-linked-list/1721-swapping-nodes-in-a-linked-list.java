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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        ListNode first=head;
        ListNode second=head;
        int fe=0,se=0;
        while(fe<k-1){
            first=first.next;
            fe++;
        }
        while(se<size-k){
            second=second.next;
            se++;
        }
        int tempo=first.val;
        first.val=second.val;
        second.val=tempo;
        return head;
    }
}