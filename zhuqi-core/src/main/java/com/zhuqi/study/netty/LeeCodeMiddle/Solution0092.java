package com.zhuqi.study.netty.LeeCodeMiddle;

/**
 *
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * @author zhuqi at 2021/3/2
 */
public class Solution0092 {


    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftNode = new ListNode(0);
        ListNode leftHead = leftNode;
        ListNode rightNode = new ListNode(0);
        ListNode rightHead = rightNode;
        ListNode middle = new ListNode(0);
        ListNode middleHead = middle;
        int index = 1;
        while(head!=null){
            if(index<left){
                leftNode.next =head;
                leftNode = leftNode.next;
            }
            if(index==left){
                middleHead = head;
                middle =head;
            }
            if(index>left&& index< right){
                middle = middle.next;
            }

            if(index == right){
                middle.next =null;
            }
            if(index> right){
                rightNode.next = head;
                rightNode = rightNode.next;
            }

            index++;
            head = head.next;
        }
        ListNode middleNode = reverseList(middleHead.next);

        leftNode.next = middleNode;
        middleNode.next  = rightHead.next;
        rightNode.next = null;


        return leftHead.next;



    }
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public class ListNode {
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
