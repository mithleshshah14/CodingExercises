import java.util.ArrayList;
import java.util.List;

public class AddTwoLinkedList {

    public static ListNode.Node addTwoNumbers(ListNode.Node l1, ListNode.Node l2) {

        // res is head node of the resultant list
        ListNode.Node res = null;
        ListNode.Node prev = null;
        ListNode.Node temp = null;
        int carry = 0, sum;

        while (l1 != null || l2 != null) {

            sum = carry + (l1 != null ? l1.data : 0)
                    + (l2 != null ? l2.data : 0);

            carry = (sum >= 10) ? 1 : 0;

            sum = sum % 10;

            temp = new ListNode.Node(sum);

            if (res == null) {
                res = temp;
            }
            else {
                prev.next = temp;
            }

            prev = temp;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            temp.next = new ListNode.Node(carry);
        }

        // return head of the resultant list
        return res;
    }

    public static void main(String[] args) {

        ListNode list = new ListNode();

        // creating first list
        list.head1 = new ListNode.Node(7);
        list.head1.next = new ListNode.Node(5);
        list.head1.next.next = new ListNode.Node(9);
        list.head1.next.next.next = new ListNode.Node(4);
        list.head1.next.next.next.next = new ListNode.Node(6);
      //  System.out.print("First List is ");
        //list.printList(head1);

        // creating second list
        list.head2 = new ListNode.Node(8);
        list.head2.next = new ListNode.Node(4);
       // System.out.print("Second List is "+list.head2);
      //  list.printList(head2);

        // add the two lists and see the result
        ListNode.Node rs = addTwoNumbers(list.head1, list.head2);
        System.out.print("Resultant List is "+ rs);

    }

    public static class ListNode {
        static Node head1, head2;

       public static class Node {

            int data;
            Node next;

            Node(int d) {
                data = d;
                next = null;
            }

           @Override
           public String toString() {
               return "Node{" +
                       "data=" + data +
                       ", next=" + next +
                       '}';
           }
       }
    }
}
