package com.zl.leetcode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-06-18
 */
public class Sum2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumNodeStart = new ListNode(0);
        ListNode listNodeTmp = new ListNode(0);
        listNodeTmp.next = new ListNode(0);
        int tmp;
        int index = 0;
        while (l1 != null || l2 != null) {
            int sum1 = 0;
            int sum2 = 0;
            if (l1 != null) {
                sum1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum2 += l2.val;
                l2 = l2.next;
            }
            int sum = sum1 + sum2;
            if (sum >= 10) {
                tmp = 1;
                sum = sum - 10;
            } else {
                tmp = 0;
            }
            boolean flag = l1 != null || l2 != null;
            if (index == 0) {
                sumNodeStart.val = sum;
                if (flag || tmp == 1) {
                    if (tmp == 1) {
                        listNodeTmp = new ListNode(1);
                    }
                    sumNodeStart.next = listNodeTmp;
                }

            } else {
                listNodeTmp.val += sum;
                if (flag || tmp == 1) {
                    if (tmp == 1) {
                        listNodeTmp.next = new ListNode(1);
                    } else {
                        listNodeTmp.next = new ListNode(0);
                    }

                    listNodeTmp = listNodeTmp.next;
                }

            }
            index++;
        }

        return sumNodeStart;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(8);
        ListNode l2 = new ListNode(8);
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(addTwoNumbers(l1, l2));
    }
}
