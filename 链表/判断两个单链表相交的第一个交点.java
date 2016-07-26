1.在单链表中，我们只能从头结点开始顺序遍历，最后才能到达尾结点。最后到达的尾节点却要先被比较，这听起来
是不是像“先进后出”？于是我们就能想到利用栈的特点来解决这个问题：分别把两个链表的结点放入
两个栈中，这样两个链表的尾结点就位于两个栈的栈顶，接下来比较下一个栈顶，直到找到最后一个相同的结点。
这种思路中，我们需要利用两个辅助栈，空间复杂度是O(len1+len2)，时间复杂度是O(len1+len2)。和一开始的蛮
力法相比，时间效率得到了提高，相当于是利用空间消耗换取时间效率。

2.首先遍历两个链表得到它们的长度。在第二次遍历的时候，在较长的链表上走 |len1-len2| 步，接着再同时在两个链表上遍历，找到的第一个相
同的结点就是它们的第一个交点
//方法：求两个单链表相交的第一个交点
public Node getFirstCommonNode(Node head1, Node head2) {
 if (head1 == null || head == null) {
  return null;
 }
 
 int length1 = getLength(head1);
 int length2 = getLength(head2);
 int lengthDif = 0; //两个链表长度的差值
 Node longHead;
 Node shortHead;
 
 //找出较长的那个链表
 if (length1 > length2) {
  longHead = head1;
  shortHead = head2;
  lengthDif = length1 - length2;
 } else {
  longHead = head2;
  shortHead = head1;
  lengthDif = length2 - length1;
 }
 
 //将较长的那个链表的指针向前走length个距离
 for (int i = 0; i < lengthDif; i++) {
  longHead = longHead.next;
 }
 
 //将两个链表的指针同时向前移动
 while (longHead != null && shortHead != null) {
  if (longHead == shortHead) { //第一个相同的结点就是相交的第一个结点
   return longHead;
  }
  longHead = longHead.next;
  shortHead = shortHead.next;
 }
 
 return null;
}
 
 
//方法：获取单链表的长度
public int getLength(Node head) {
 if (head == null) {
  return 0;
 }
 
 int length = 0;
Node current = head;   while (current != null) {
 
  length++;
  current = current.next;
 }
 
 return length;