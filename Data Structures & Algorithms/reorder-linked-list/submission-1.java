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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        //1. Divide the list
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //slow stores the last element of 1st partition

        //2. Reverse second list
        ListNode second=slow.next;
        ListNode prev = slow.next = null;
        while(second!=null){
            ListNode temp = second.next;
            second.next = prev;
            prev=second;
            second=temp;
        }

        //prev is the first element of the second list now
        //and second is at null

        //3. Merge fisrt and second lists

        ListNode first = head;
        second = prev;
        while(second!=null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next =second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }   
    }
}
//n
//1
