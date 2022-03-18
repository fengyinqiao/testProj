package com.fengyq.leetcode;
/*在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
        示例 1:
        输入: 4->2->1->3
        输出: 1->2->3->4*/
public class SortList {
    public static void main(String[] args) {
            ListNode head=new ListNode(-1);
            head.next=new ListNode(5);
            head.next.next=new ListNode(3);
            head.next.next.next=new ListNode(4);
            head.next.next.next.next=new ListNode(0);
            ListNode res=mergeSort(head);
            ListNode curr=res;
            while(curr!=null) {
                System.out.print(curr.val+"->");
                curr=curr.next;
            }
    }

    private static ListNode mergeSort(ListNode head) {
        if(head==null||head.next==null) {
            return head;
        }
        ListNode mid=getMidNode(head);
        ListNode rightHead=mid.next;
        mid.next=null;
        ListNode left=mergeSort(head);
        ListNode right=mergeSort(rightHead);
        ListNode res=merge(left,right);
        return res;
    }

    private static ListNode merge(ListNode head, ListNode rightHead) {
        if(head==null) {
            return rightHead;
        }
        if(rightHead==null) {
            return head;
        }
        ListNode p1=head,p2=rightHead,dummy=new ListNode(-1),newHead=dummy;
        while(p1!=null&&p2!=null) {
            if(p1.val<p2.val) {
                dummy.next=p1;
                p1=p1.next;
            }else {
                dummy.next=p2;
                p2=p2.next;
            }
            dummy=dummy.next;
        }
        if(p1==null) {
            dummy.next=p2;
        }
        if(p2==null) {
            dummy.next=p1;
        }
        return newHead.next;
    }

    private static ListNode getMidNode(ListNode head) {
        if(head==null) {
            return null;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode slow=dummy,fast=dummy;
        while(fast!=null&&fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
