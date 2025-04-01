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
    ListNode first = null;
    public boolean isPalindrome(ListNode head) {
        first = head;
        boolean r = recur(head);
        return r;
    }

    public boolean recur(ListNode node){

        if(node == null){
            return true;
        }

        boolean r = recur(node.next);
        //System.out.println("node " + node.val + " first " + first.val);
        r = r && (first.val == node.val);
        first = first.next;
        return r;
    }
}