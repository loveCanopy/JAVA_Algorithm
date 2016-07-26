//方法：从尾到头打印单链表
public void reversePrint(Node head) {
 
if (head == null) {
 return;
 }
 
 Stack<Node> stack = new Stack<Node>(); //新建一个栈
 Node current = head;
 
 //将链表的所有结点压栈
 while (current != null) {-
 stack.push(current); //将当前结点压栈
 current = current.next;
}
 
 //将栈中的结点打印输出即可
while (stack.size() > 0) {
 System.out.println(stack.pop().data); //出栈操作
}
}