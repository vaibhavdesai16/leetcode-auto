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
    ArrayList<Integer> arr = new ArrayList<>();

    public boolean isPalindrome(ListNode head) {
        recur(head);
        int idx = 0;
        while(head != null){
            if(idx <= arr.size()/2){

                if(head.val != arr.get(idx)){
                    return false;
                }
                else{
                    head = head.next;
                    idx++;
                }

            }else{
                return true;
            }
        }

        return true;
    }

    public void recur(ListNode node){

        if(node == null){
            return;
        }

        recur(node.next);
        arr.add(node.val);
    }
}