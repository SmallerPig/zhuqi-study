package com.zhuqi.study.netty.LeeCodeMiddle;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]  10009998
 *
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * 通过次数718,056提交次数1,814,718
 * @author zhuqi at 2021/2/24
 */
public class Solution0002 {


    public static void main(String[] args){
        Solution0002 solution0002 = new Solution0002();
//        System.out.println(solution0002.addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))),
//                new ListNode(5, new ListNode(6, new ListNode(4)))).val);
        System.out.println("solution0002.lengthOfLongestSubstring(\"dvdf\") = " + solution0002.lengthOfLongestSubstring("dvdf"));


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = 0, num2 = 0;
        ListNode res= new ListNode();
        while (l1!= null || l2!=null){
            int temp = l1.val+l2.val;
            int carry = 0;
            if (temp>10){
                temp = temp/10;
                carry = 1;
            }
            res.val = temp;

            l1 = l1.next;
            l2= l2.next;
            res.next = addTwoNumbers(l1, l2);
            String s = "12312";
        }
        return res;

    }

    ListNode getList(int sum){
        if (sum<=0){return null;}
        ListNode result = new ListNode();
        ListNode node = new ListNode(sum%10);
        node.next = getList(sum/10);
        result.next = node;
        return result;
    }
    public int lengthOfLongestSubstring(String s) {
        int left =0, right =0;
        int result =0;
        int length = s.length();
        Set<Character> sets = new HashSet<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(!sets.contains(c)){
                sets.add(c);
                result = Math.max(result, sets.size());
            }else{
                sets = new HashSet<>();
                sets.add(c);
            }
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
