/**
 * 反转链表
 * 法一：迭代，用一个temp来存储原本的下一个节点
 * 法二：
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 //迭代
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}

//递归
class Solution {
    public ListNode reverseList(ListNode head) {
       if(head == null || head.next == null) return head;
       ListNode p = reverseList(head.next);
       head.next.next = head;
       head.next = null; //n1指向的下一个一定是null;
       return p;
    }
}