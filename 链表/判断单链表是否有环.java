//方法：判断单链表是否有环
public boolean hasCycle(Node head) {
 
 if (head == null) {
 return false;
 }
 
 Node first = head;
 Node second = head;
 
 while (second != null) {
 first = first.next; //first指针走一步
 second = second.next.next; second指针走两步
 
 if (first == second) { //一旦两个指针相遇，说明链表是有环的
  return true;
 }
}
 
 return false;
}