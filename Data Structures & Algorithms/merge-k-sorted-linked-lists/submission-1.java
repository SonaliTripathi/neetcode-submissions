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
        Queue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode dummy = new ListNode(0);
        for(ListNode list : lists){
            if(list!=null)
            minHeap.add(list);
        }

        ListNode curr = dummy;
        while(minHeap.size()!=0){
            ListNode min = minHeap.poll();
            if(min.next!=null){
                minHeap.offer(min.next);
            }
            curr.next=min;
            curr=curr.next;
        }
        return dummy.next;

    }
}

//nlogk
//k
