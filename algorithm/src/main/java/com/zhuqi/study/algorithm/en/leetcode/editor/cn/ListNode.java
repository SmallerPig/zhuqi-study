package com.zhuqi.study.algorithm.en.leetcode.editor.cn;

/**
 * @author zhuqi at 2023/3/27
 */

/**
 *
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(val);
        if (next != null) {
            sb.append("->").append(next);
        }
        return sb.toString();
    }


    /**
     * @param arr [1,2,3,4,5]
     * @return [1-2-3-4-5]
     */
    public static ListNode getByArray(int[] arr) {

        ListNode ans = new ListNode(arr[0]);
        ListNode dumb = new ListNode(-1, ans);
        for (int i = 1; i < arr.length; i++) {
            ListNode listNode = new ListNode(arr[i]);
            ans.next = listNode;
            ans = ans.next;
        }

        return dumb.next;
    }


    public static void main(String[] args) {
        ListNode byArray = getByArray(new int[]{1, 2, 3, 4, 5});
        System.out.println("byArray = " + byArray);
    }
}