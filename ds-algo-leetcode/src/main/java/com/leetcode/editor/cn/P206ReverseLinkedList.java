//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1686 👎 0


package com.leetcode.editor.cn;

import com.leetcode.editor.cn.assembly.ListNode;

/*
 * Java：反转链表
 */
public class P206ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
        // TO TEST
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        head.next = node2;
        ListNode listNode = solution.reverseList(head);
        while (listNode != null) {
            System.out.print(listNode.val + "\t");
            listNode = listNode.next;
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)

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
        public ListNode reverseList(ListNode head) {
            ListNode cur = null, pre = head;
            while (pre != null) {
                ListNode n = pre.next;
                pre.next = cur;
                cur = pre;
                pre = n;
            }
            return cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}