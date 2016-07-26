//方法：链表的反转
public Node reverseList(Node head) {
 
//如果链表为空或者只有一个节点，无需反转，直接返回原链表的头结点
 if (head == null || head.next == null) {
 return head;
}
 
Node current = head;
Node next = null; //定义当前结点的下一个结点
 Node reverseHead = null; //反转后新链表的表头
 
while (current != null) {
 next = current.next; //暂时保存住当前结点的下一个结点，因为下一次要用
 
 current.next = reverseHead; //将current的下一个结点指向新链表的头结点
 reverseHead = current; 
 
 current = next; // 操作结束后，current节点后移
}
 
return reverseHead;
}