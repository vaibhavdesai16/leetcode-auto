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
    public ListNode swapPairs(ListNode head) {

         int totalLength = 0;
        ListNode cpyHead = head;
        while(cpyHead != null){
            totalLength++;
            cpyHead = cpyHead.next;
        }
        if(totalLength == 0 || totalLength == 1){
            return head;
        }
        ListNode ls[] = new ListNode[totalLength];
    
        int count = 0;
        while(head != null){
            if(count%2 == 0 ) {
                if((count+1)<totalLength){
                      ls[count +1] = head;
                }
                else if(count+1 == totalLength){
                    ls[count] = head;
                }
              
            }
            else{
                  ls[count -1] = head;
            }
            count++;
            head = head.next;
        }
        

        ListNode newHead = ls[0];
        for(int i=0; i<(ls.length-1); i++){
            ls[i].next = ls[i+1];
        }
        
        ls[ls.length-1].next = null;
        
        return newHead;
        
    }
}