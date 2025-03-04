public class ReorderList {
  public void reorderList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return;
    }

    ListNode fastPointer = head;
    ListNode slowPointer = head;

    while (fastPointer != null && fastPointer.next != null) {
      fastPointer = fastPointer.next.next;
      slowPointer = slowPointer.next;
    }

    ListNode secondHalf = reverseLinkedList(slowPointer.next);
    slowPointer.next = null;

    ListNode firstHalf = head;

    while (secondHalf != null) {
      ListNode temp1 = firstHalf.next;
      ListNode temp2 = secondHalf.next;

      firstHalf.next = secondHalf;
      secondHalf.next = temp1;

      firstHalf = temp1;
      secondHalf = temp2;
    }

  }

  public ListNode reverseLinkedList(ListNode head) {
    ListNode prev = null;
    ListNode currentNode = head;

    while (currentNode != null) {
      ListNode nextNode = currentNode.next;
      currentNode.next = prev;
      prev = currentNode;
      currentNode = nextNode;
    }

    return prev;
  }

}
