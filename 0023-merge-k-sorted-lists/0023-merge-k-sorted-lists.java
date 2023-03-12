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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists,0,lists.length-1);
        

    }
    public ListNode merge(ListNode[]lists,int left,int right){
        if(left == right) return lists[left];
        int mid=left+(right-left)/2;
        ListNode lleft=merge(lists,left,mid);
        ListNode rright=merge(lists,mid+1,right);
        return mergeSort(lleft,rright);
    }

    public ListNode mergeSort(ListNode head1,ListNode head2){
        ListNode dummyval=new ListNode(0);
        ListNode dummy=dummyval;
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                dummy.next=head1;
                head1=head1.next;
            }else{
                dummy.next=head2;
                head2=head2.next;
            }
            dummy=dummy.next;
        }
        if(head1!=null){
            dummy.next=head1;
        }
        if(head2!=null){
            dummy.next=head2;
        }
        return dummyval.next;
    }
}