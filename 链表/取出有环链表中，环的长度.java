//方法：判断单链表是否有环。返回的结点是相遇的那个结点
public Node hasCycle(Node head) {
 
 if (head == null) {
 return null;
 }
 
 Node first = head;
 Node second = head;
 
while (second != null) {
 first = first.next;
 second = second.next.next;
 
 if (first == second) { //一旦两个指针相遇，说明链表是有环的
  return first; //将相遇的那个结点进行返回
 }
 }
 return null;
}
 
//方法：有环链表中，获取环的长度。参数node代表的是相遇的那个结点
public int getCycleLength(Node node) {
 
 if (head == null) {
 return 0;
 }
 
 Node current = node;
 int length = 0;
 
 while (current != null) {
 current = current.next;
 length++;
 if (current == node) { //当current结点走到原点的时候
  return length;
 }
 }
 return length;
}