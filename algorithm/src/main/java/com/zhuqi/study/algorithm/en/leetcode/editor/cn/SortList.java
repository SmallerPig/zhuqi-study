//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 1976 👎 0

package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
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
         * > 2023/07/13 19:04:17
         * Success:
         * Runtime:10 ms, faster than 91.06% of Java online submissions.
         * Memory Usage:53.4 MB, less than 54.63% of Java online submissions.
         *
         * @param head
         * @return
         */
        public ListNode sortList(ListNode head) {
            List<ListNode> lists = new ArrayList<>();
            ListNode cur = head;
            while (cur != null) {
                lists.add(cur);
                cur = cur.next;
            }
            lists.sort((a1, a2) -> a1.val - a2.val);
            cur = null;
            ListNode ans = new ListNode(-1);
            ListNode dumb = ans;
            int size = lists.size();
            for (int i = 0; i < size; i++) {
                ans.next = lists.get(i);
                ans = ans.next;
            }
            ans.next = null;

            return dumb.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}