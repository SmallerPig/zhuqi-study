package com.zhuqi.study.netty.LeeCodeMiddle;

/**
 * 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 *
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 * @author zhuqi at 2021/3/2
 */
public class Solution0086 {



    public ListNode partition(ListNode head, int x) {
        if(head==null||(head.val<=x && head.next==null)){
            return head;
        }
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode lager = new ListNode(0);
        ListNode lagerHead = lager;
        while(head !=null){
            if(head.val < x){
                small.next=head;
                small = smallHead.next;
            }else{
                lager.next =head;
                lager = lagerHead.next;
            }

            head = head.next;
        }
        lager.next =null;
        small.next=lagerHead.next;
        return smallHead.next;
    }

    public ListNode partition1(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
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
