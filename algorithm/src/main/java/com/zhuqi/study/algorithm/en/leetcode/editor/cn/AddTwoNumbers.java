//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 9527 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
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
        /**
         * > 2023/06/27 08:26:38
         * Success:
         * Runtime:1 ms, faster than 100.00% of Java online submissions.
         * Memory Usage:42 MB, less than 40.44% of Java online submissions.
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            boolean flag = false;
            ListNode ans = new ListNode(0);
            ListNode dumb = new ListNode(-1);
            dumb.next = ans;
            while (l1 != null || l2 != null || flag) {
                int val = 0;

                if (l1 != null && l2 != null) {
                    val = l1.val + l2.val;
                    l1 = l1.next;
                    l2 = l2.next;
                } else if (l1 != null) {
                    val = l1.val;
                    l1 = l1.next;
                } else if (l2 != null) {
                    val = l2.val;
                    l2 = l2.next;
                }
                val = val + (flag ? 1 : 0);
                if (val >= 10) {
                    flag = true;
                    val = val % 10;
                } else {
                    flag = false;
                }
                ListNode temp = new ListNode(val);
                ans.next = temp;
                ans = ans.next;
            }

            return dumb.next.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}