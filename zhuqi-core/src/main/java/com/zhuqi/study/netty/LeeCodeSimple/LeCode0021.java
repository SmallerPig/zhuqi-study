package com.zhuqi.study.netty.LeeCodeSimple;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *  
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LeCode0021 {

    public static void main(String[] args) {
        LeCode0021 leCode0021 = new LeCode0021();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4,new ListNode())));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode())));
        /*
        1 ,2,4
        1,3,4

        1,1,3,4
        2,4

        1,1,2,4
        3,4

        1,1,2,3,4
        4

        1,1,2,3,4,4
         */
        ListNode listNode = leCode0021.mergeTwoLists2(l1, l2);
        System.out.println("listNode = " + listNode);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = l1;
        while (l2.next!=null){
            if (result.val <= l2.val){
                ListNode temp = result.next;
                ListNode resultNext = l2;
                result.next = l2;
                l2 = l2.next;
            }
        }


        return result;
    }


    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }



}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
