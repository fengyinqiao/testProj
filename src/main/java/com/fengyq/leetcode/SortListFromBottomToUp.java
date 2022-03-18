package com.fengyq.leetcode;

/*在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
        示例 1:
        输入: 4->2->1->3
        输出: 1->2->3->4
bottom-to-up 的归并思路是这样的：先两个两个的 merge，完成一趟后，再 4 个4个的 merge，直到结束。
举个简单的例子：[4,3,1,7,8,9,2,11,5,6].
        step=1: (3->4)->(1->7)->(8->9)->(2->11)->(5->6)
        step=2: (1->3->4->7)->(2->8->9->11)->(5->6)
        step=4: (1->2->3->4->7->8->9->11)->5->6
        step=8: (1->2->3->4->5->6->7->8->9->11)*/
public class SortListFromBottomToUp {
    public static void main(String[] args) {
        ListNode head=new ListNode(4);
        head.next=new ListNode(3);
        head.next.next=new ListNode(1);
        head.next.next.next=new ListNode(7);
        head.next.next.next.next=new ListNode(8);
        head.next.next.next.next.next=new ListNode(9);
        head.next.next.next.next.next.next=new ListNode(2);
        head.next.next.next.next.next.next.next=new ListNode(11);
        head.next.next.next.next.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next.next.next.next.next=new ListNode(6);
        ListNode res=mergeSort(head);
        ListNode curr=res;
        while(curr!=null) {
            System.out.print(curr.val+"->");
            curr=curr.next;
        }
    }

    private static ListNode mergeSort(ListNode head) {
        if(head==null) {
            return null;
        }
        int nodeNum=getNodeNum(head);
        ListNode curr=head,dummy=new ListNode(-1),newHead=dummy;
        for (int i = 1; i <= nodeNum; i=i*2) {
            while (curr!=null) {
                ListNode left=curr;
                ListNode right=cut(curr,i);
                curr=cut(right,i);
                dummy.next=merge(left,right);
                while(dummy.next!=null) {
                    dummy=dummy.next;
                }
            }
            curr=newHead.next;
            dummy=newHead;
        }
        return newHead.next;
    }

    private static ListNode merge(ListNode left, ListNode right) {
        if(left==null) {
            return right;
        }
        if(right==null) {
            return left;
        }
        ListNode dummy=new ListNode(-1),newHead=dummy;
        while(left!=null&&right!=null) {
            if(left.val<right.val) {
                dummy.next=left;
                left=left.next;
            }else {
                dummy.next=right;
                right=right.next;
            }
            dummy=dummy.next;
        }
        if(left==null) {
            dummy.next=right;
        }
        if(right==null) {
            dummy.next=left;
        }
        return newHead.next;
    }

    private static ListNode cut(ListNode head, int num) {
        ListNode prev=null,curr=head;
        while(num!=0&&curr!=null) {
            prev=curr;
            curr=curr.next;
            num--;
        }
        if(prev!=null) {
            prev.next=null;
        }
        return curr;
    }

    private static int getNodeNum(ListNode head) {
        ListNode curr=head;
        int num=0;
        while(curr!=null){
            num++;
            curr=curr.next;
        }
        return num;
    }
}
