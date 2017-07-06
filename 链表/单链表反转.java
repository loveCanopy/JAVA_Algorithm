就地反转
一：
把当前链表的下一个节点pCur插入到头结点dummy的下一个节点中，就地反转。
dummy->1->2->3->4->5的就地反转过程：
dummy->2->1->3->4->5
dummy->3->2->1->4->5
dummy->4>-3->2->1->5
dummy->5->4->3->2->1
pCur是需要反转的节点。
prev连接下一次需要反转的节点
反转节点pCur
纠正头结点dummy的指向
pCur指向下一次要反转的节点
1 prev.next = pCur.next;
2 pCur.next = dummy.next;
3 dummy.next = pCur;
4 pCur = prev.next;
二：
为了反转这个单链表，我们先让头结点的next域指向结点2，再让结点1的next域指向结点3，最后将结点2的next域指向结点1，
就完成了第一次交换，顺序就变成了Header-结点2-结点1-结点3-结点4-NULL，
然后进行相同的交换将结点3移动到结点2的前面，然后再将结点4移动到结点3的前面就完成了反转，思路有了，就该写代码了：
LinkedList ReverseSinglyLinkedList(LinkedList list)
{
    LNode   *tmp = NULL;
    LNode   *p = NULL;
 
    if (list == NULL)
    {
        return NULL;
    }
    tmp = list->next;
    while (tmp->next != NULL)
    {
        p = tmp->next;
        tmp->next = p->next;
        p->next = list->next;
        list->next = p;
    }
    return list;
}



二。新建链表,头节点插入法 和原地反转差不多 只是新开辟了空间
      public ListNode reverseList2(ListNode head) {
         ListNode dummy = new ListNode(-1);
         ListNode pCur = head;
         while (pCur != null) {
             ListNode pNex = pCur.next;
             pCur.next = dummy.next;
             dummy.next = pCur;
             pCur = pNex;
         }
         return dummy.next;
     }