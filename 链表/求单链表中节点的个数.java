//方法：获取单链表的长度
public int getLength(Node head) {
 if (head == null) {
 return 0;
 }
 
 int length = 0;
 Node current = head;
 while (current != null) {
 length++;
 current = current.next;
 }
 
 return length;
}