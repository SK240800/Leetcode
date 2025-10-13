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
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if(head == null) return null;

        ListNode cur = head, prev = null;
        while(m>1){
            prev = cur;
            cur = cur.next;
            m--;
            n--;

        }

        ListNode con = prev, tail = cur;

        ListNode third = null;
        while(n>0){
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;        
        
    }
}