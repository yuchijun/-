/**
 * (leetcode 141) -- 利用HashSet
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> hashset = new HashSet();

        while(head != null){
            if(hashset.contains(head)){
                return true;
            }else{
                hashset.add(head);
            }
            head = head.next;
        }
        return false;   
    }
}