package com.zhuqi.study.netty.LeeCodeSimple;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 *
 * 206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @author zhuqi at 2021/2/25
 */
public class Solution0206 {

    public static void main(String[] args) {
        Solution0206 solution0206 = new Solution0206();
        ListNode res = solution0206.reverseList1(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))));
        System.out.println("res = " + res);
    }


    /**
     * 1-2-3-4-5
     *
     * 1
     *
     * 2-1
     *
     * 3-2-1
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head){
        ListNode result = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = result;
            result = head;

            head = next;
        }

        return result;
    }








    /**
     * 剑指offer题目之后回顾
     * 1-2-3-4-5
     * 2-1-3-4-5
     * 3-2-1-4-5
     * 4-3-2-1-5
     *
     * 5-4-3-2-1
     * @return
     */
    public ListNode reverseList1(ListNode head){
        //使用迭代的方式来
        ListNode next = null;
        ListNode current = head;
        while (current!=null&& current.next!=null){
            ListNode tep  = current.next;//tep= 2-3-4-5-n
            current.next = next;// current = 1-n
            next = current;//next =1-n
            current = tep; // current = 2-3-4-5-n
        }
        return next;
    }

    /**
     *
     *
     * 1-2-3-4-5
     *
     * 1
     * 2-1
     * 3-2-1
     * 4-3-2-1
     * 5-4-3-2-1
     * 迭代法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        // 新结果
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 保存下一个节点
            ListNode next = curr.next;
            // 把当前节点插入到新结果的前面,新结果自然而然的就是倒序
            curr.next = prev;
            // 把新结果的指针指向已经修改好的结果
            prev = curr;
            // 原节点指针向后移一位;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseList(ListNode head) {

        Deque<ListNode> deque = new ArrayDeque<>();
        while (head!=null){
            deque.addFirst(head);
            head = head.next;
        }
        return getNext(deque);
    }

    public ListNode getNext(Deque<ListNode> deque){
        ListNode result = new ListNode();
        while (!deque.isEmpty()){
            result = deque.removeFirst();
            result.next = getNext(deque);
        }

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
