/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return solve(lists, 0 , lists.length-1);
    }

    //先分治，再合并
    public ListNode solve(ListNode[] arr, int left, int right){
        if(left == right){
            return arr[left];
        }
        int mid = (left + right)>>1;
        ListNode nodeL = solve(arr, left, mid);
        ListNode nodeR = solve(arr, mid+1, right);

        return mergeTwoLists(nodeL, nodeR);
    }

    //合并两个链表
    public ListNode mergeTwoLists(ListNode node1, ListNode node2){
        if(node1 == null){
            return node2;
        }else if(node2 == null){
            return node1;
        }else if(node1.val < node2.val){
            node1.next = mergeTwoLists(node1.next, node2);
            return node1; //从node1开始遍历
        }else{
            node2.next = mergeTwoLists(node1,node2.next);
            return node2;//从node2开始遍历
        }
    }
}