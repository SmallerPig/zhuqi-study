//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// Related Topics 栈 递归 链表 双指针 👍 1186 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

public class ReorderList {
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
        ListNode helper = solution.reverse(ListNode.getByArray(new int[]{1, 2, 3, 4, 5}), true);
        System.out.println("helper = " + helper);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            ListNode mid = mid(head);
            ListNode l2 = mid.next;
            mid.next = null;
            l2 = reverse(l2);
            merger(head, l2);

        }

        private void merger(ListNode l1, ListNode l2) {
            ListNode temp1;
            ListNode temp2;

            while (l1 != null && l2 != null) {
                temp1 = l1.next;
                temp2 = l2.next;

                l1.next = l2;
                l1 = temp1;

                l2.next = l1;
                l2 = temp2;
            }

        }

        public ListNode mid(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode cur = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return cur;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}