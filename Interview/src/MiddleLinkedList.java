import java.math.BigDecimal;

public class MiddleLinkedList {

    LinkedNode headNode;

    class LinkedNode {

        int data;
        LinkedNode next;

        LinkedNode(int data) {
            this.data = data;
            next = null;
        }

    }


    public void pushElement(int data) {

        LinkedNode newNode = new LinkedNode(data);
        newNode.next = headNode;
        headNode = newNode;

    }

    public int findElement() {
        int count = 0;

        LinkedNode node = headNode;

        while(node != null ) {
            node = node.next;
            count++;
        }

        node = headNode;
        int size = 0;
        while(size<(count/2)) {
            node = node.next;
            size++;
        }

        return node.data;
    }

    public int getMiddleElement() {


        LinkedNode fast = headNode;
        LinkedNode slow = headNode;

        while(fast!= null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }


    public static void main(String[] args) {
        MiddleLinkedList list = new MiddleLinkedList();
        list.pushElement(1);
        list.pushElement(2);
        list.pushElement(3);
        list.pushElement(4);
        list.pushElement(5);

        int num = list.getMiddleElement();

        System.out.println(num);
    }



}
