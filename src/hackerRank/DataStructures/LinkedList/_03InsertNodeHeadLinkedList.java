package hackerRank.DataStructures.LinkedList;

/*
 * Link:https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list
 */

public class _03InsertNodeHeadLinkedList {

	Node Insert(Node head,int data) {
		Node newNode=new Node();
		newNode.data=data;
		newNode.next=head;
		return newNode;
	}
	class Node{
		Node next;
		int data;
	}
}
