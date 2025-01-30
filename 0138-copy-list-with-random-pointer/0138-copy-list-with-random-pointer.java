/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head)
    {
        HashMap<Node,Node> copy=new  HashMap<>();
        copy.put(null,null);
        Node ans=new Node(-1);
        Node temp=ans;
        Node t2=head;
        while(t2!=null)
        {
            Node curr=new  Node(t2.val);
            copy.put(t2,curr);
            temp.next=curr;
            t2=t2.next;
            temp=temp.next;
        }
        temp=ans.next;
        t2=head;
        while(t2!=null)
        {
            temp.random=copy.getOrDefault(t2.random,null);
            t2=t2.next;
            temp=temp.next;
        }
        return ans.next;
    }
}