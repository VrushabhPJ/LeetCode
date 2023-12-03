package Linked_List;/* Reverse Link List II
 Reverse a linked list A from position B to C.

NOTE: Do it in-place and in one-pass.

*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
 }
public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        if(A.next == null || (B == C)) return A;  //if A next null or B & C are same

        ListNode dummy= new ListNode(0);
        dummy.next= A;

        int pos= 1;
        ListNode nodebefore= dummy;
        while(pos < B) {
            nodebefore= nodebefore.next;
            pos++;
        }
        ListNode workingptr= nodebefore.next; // start of sublist at B point to reverse part of list
        while(B < C) {
            ListNode nodeExtract= workingptr.next;
            workingptr.next= nodeExtract.next;

            nodeExtract.next= nodebefore.next;
            nodebefore.next= nodeExtract;
            B++;
        }

        return dummy.next;
    }
}