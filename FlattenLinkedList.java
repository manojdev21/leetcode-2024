/**
Given a Linked List of size n, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.

Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
**/

/*Node class  used in the program
'class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}'
*/
/*  Function which returns the  root of
    the flattened linked list. */
class GfG {
    Node flatten(Node root) {
        // Your code here
        Node newList = root;
        while (root.next != null) {
            newList = flatten(newList, root.next);
            root = root.next;
        }
        return newList;
    }
    
    private Node flatten(Node a, Node b) {
        Node node = new Node(-1);
        Node dummy = node;
        while (a != null && b != null) {
            if (a.data <= b.data) {
                dummy.bottom = a;
                a = a.bottom;
            } else {
                dummy.bottom = b;
                b = b.bottom;
            }
            dummy = dummy.bottom;
        }
        if (a != null) {
            dummy.bottom = a;
        } else if (b != null) {
            dummy.bottom = b;
        }
        return node.bottom;
    }
}
