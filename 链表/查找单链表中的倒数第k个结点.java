public int findLastNode(int index) { //index代表的是倒数第index的那个结点
 
 //第一次遍历，得到链表的长度size
 if (head == null) {
 return -1;
 }
 
 current = head;
 while (current != null) {
 size++;
 current = current.next;
}
 
 //第二次遍历，输出倒数第index个结点的数据
 current = head;
 for (int i = 0; i < size - index; i++) {
 current = current.next;
 }
 
return current.data;
}


//这里需要声明两个指针：即两个结点型的变量first和second，首先让first和second都指向第一个结点，然后让second结点往后挪k-1个位置，此时first和second就间隔了k-1个位置，然后整体向后移动这两个节点，直到second节点走到最后一个结点的时候，此时first节点所指向的位置就是倒数第k个节点的位置。时间复杂度为O（n）
public Node findLastNode(Node head, int k) {
if (k == 0 || head == null) {
 return null;
 }
 
 Node first = head;
 Node second = head;
 
//让second结点往后挪k-1个位置
 for (int i = 0; i < k - 1; i++) {
 System.out.println("i的值是" + i);
 second = second.next;
 if (second == null) { //说明k的值已经大于链表的长度了
 //throw new NullPointerException("链表的长度小于" + k); //我们自己抛出异常，给用户以提示
  return null;
 }
}
 
 //让first和second结点整体向后移动，直到second走到最后一个结点
 while (second.next != null) {
 first = first.next;
 second = second.next;
 }
 //当second结点走到最后一个节点的时候，此时first指向的结点就是我们要找的结点
return first;
}