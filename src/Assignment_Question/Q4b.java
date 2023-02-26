package Assignment_Question;

class Q4b {

    static class List_Node {
        int val;
        List_Node next;

        List_Node(int x) {
            val = x;
        }
    }
    //    this method takes List_Node object as input and returns an integer value
    public int sort_List(List_Node head) {
//        if head is equal to null and head next is qual to null then it returns 0
        if (head == null || head.next == null)
            return 0;
//initialize
        int count = 0;
        List_Node current = head;

        while (current.next != null) {
            if (current.val > current.next.val) {
                current.next = current.next.next;
//                increment
                count++;
            }
//            stores current next value in current
            else {
                current = current.next;
            }
        }
//        return
        return count;
    }

    public static void main(String[] args) {
        Q4b obj = new Q4b();
        List_Node head = new List_Node(5);
        head.next = new List_Node(2);
        head.next.next = new List_Node(1);
        head.next.next.next = new List_Node(0);
        head.next.next.next.next = new List_Node(8);
        head.next.next.next.next.next = new List_Node(3);
        head.next.next.next.next.next.next = new List_Node(8);
        head.next.next.next.next.next.next.next = new List_Node(7);

        System.out.println("Number of steps required to sort the linked list: " + obj.sort_List(head));
    }
}
