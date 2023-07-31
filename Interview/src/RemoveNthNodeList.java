import java.util.ArrayList;
import java.util.List;

class ListNodeNew {
      int val;
      ListNodeNew next;
      ListNodeNew() {}
      ListNodeNew(int val) { this.val = val; }
      ListNodeNew(int val, ListNodeNew next) { this.val = val; this.next = next; }
  }
class RemoveNthNodeList {
    public ListNodeNew removeNthFromEnd(ListNodeNew head, int n) {
        if (head == null || head.next == null) return null;

        ListNodeNew temp = new ListNodeNew(0);
        temp.next = head;
        ListNodeNew first = temp, second = temp;

        while (n > 0) {
            second = second.next;
            n--;
        }

        while (second.next != null) {
            second = second.next;
            first = first.next;
        }

        first.next = first.next.next;
        return temp.next;
    }

    public static void main(String[] args) {
        ListNodeNew root = new ListNodeNew(1);
        root.next = new ListNodeNew(2);
        root.next.next = new ListNodeNew(3);
        root.next.next.next = new ListNodeNew(4);
        root.next.next.next.next = new ListNodeNew(5);

        RemoveNthNodeList nthNodeList = new RemoveNthNodeList();
        ListNodeNew neww = nthNodeList.removeNthFromEnd(root, 2);

        while (neww != null) {
            System.out.println(neww.val);
            neww = neww.next;
        }
    }
}