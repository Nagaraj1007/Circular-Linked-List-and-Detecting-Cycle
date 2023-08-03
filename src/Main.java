class CircularLinkedList{
    Node head;
    Node tail;
    static class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }

    public boolean cycleOrNot(){
        Node slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    public int cycleAtValue(){
        Node slow = head, fast = head, current = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                while (current != slow){
                    current = current.next;
                    slow = slow.next;
                }
                return slow.value;
            }
        }
        return -1;
    }

}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.head = new CircularLinkedList.Node(5);
        list.head.next = new CircularLinkedList.Node(3);
        list.head.next.next = new CircularLinkedList.Node(10);
        list.head.next.next.next = list.head;
        System.out.println(list.cycleOrNot());
        System.out.println(list.cycleAtValue());
    }
}