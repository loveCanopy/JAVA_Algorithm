和上面的第2节一样，也是设置两个指针first和second，只不过这里是，两
个指针同时向前走，second指针每次走两步，first指针每次走一步，直到second指
针走到最后一个结点时，此时first指针所指的结点就是中间结点。注意链表为空，链表结点个数为1和2的情况。时
间复杂度为O（n）。
代码实现：
//方法：查找链表的中间结点
public Node findMidNode(Node head) {
 
if (head == null) {
 return null;
}
 
Node first = head;
 Node second = head;
//每次移动时，让second结点移动两位，first结点移动一位
while (second != null && second.next != null) {
 first = first.next;
 second = second.next.next;
}
 
//直到second结点移动到null时，此时first指针指向的位置就是中间结点的位置
 return first;
}