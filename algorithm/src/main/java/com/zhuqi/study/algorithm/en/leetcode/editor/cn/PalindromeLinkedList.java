//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 1648 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        boolean palindrome = solution.isPalindrome(ListNode.getByArray(new int[]{1, 2, 2, 1}));

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
         * > 2023/07/06 19:35:15
         * Success:
         * Runtime:4 ms, faster than 76.15% of Java online submissions.
         * Memory Usage:57.9 MB, less than 32.58% of Java online submissions.
         *
         * @param head
         * @return
         */
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }

            ListNode p1 = mid(head);

            // 找到前半部分链表的尾节点并反转后半部分链表
            ListNode p2 = reverseList(p1);

            p1 = head;
//            System.out.println("p1 = " + p1);
//            System.out.println("p2 = " + p2);

            while (p2 != null) {
                if (p1.val != p2.val) {
                    return false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }

            return true;
        }

        private ListNode mid(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}