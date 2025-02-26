public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        Integer gapBetweenFirstAndSecondPointer = n - 1;
        ListNode firstPointer = head;
        ListNode secondPointer = new ListNode(0, head);

        while (firstPointer.next != null && gapBetweenFirstAndSecondPointer > 0) {
            firstPointer = firstPointer.next;
            gapBetweenFirstAndSecondPointer--;
        }

        while (firstPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        secondPointer.next = secondPointer.next.next;

        return head;
    }
}
