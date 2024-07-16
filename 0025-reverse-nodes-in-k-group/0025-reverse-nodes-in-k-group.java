/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k)
    {
        ListNode temp=new  ListNode(-1,head);
        head=temp;
        temp=temp.next;
        ListNode nexttemp;
        ListNode prev=head;
        ListNode curr=temp;
        int count=1;
        while(temp!=null && temp.next!=null)
        {
            while(temp.next!=null && count<=k-1)
            {
                count++;
                temp=temp.next;
            }
            if(count<=k-1)
                break;
            nexttemp=temp.next;
            temp.next=null;
            ListNode rev=reverse(curr);
            prev.next=rev;
            curr.next=nexttemp;
            temp=curr.next;
            prev=curr;
            curr=nexttemp;
            count=1;
        }
        return head.next;
    }
    public ListNode reverse(ListNode head)
    {
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}