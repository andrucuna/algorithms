package com.leetcode.andrucuna.algorithms;

/**
 * Problem: 
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode iterator = null;
        ListNode result = null;
        
        do {
        	// We check if l1 and l2 still have values to be added
        	int s1 = (l1 != null)? l1.val : 0;
        	int s2 = (l2 != null)? l2.val : 0;
        	l1 = (l1 != null)? l1.next : null;
        	l2 = (l2 != null)? l2.next : null;
        	
        	// We calculate the node and the sum carry
        	ListNode currentNode = new ListNode( (s1+s2+carry)%10 );
        	carry = (s1+s2+carry)/10;
        	
        	// We build the list
        	if(iterator == null) {
        		iterator = currentNode;
        		result = iterator;
        	} else {
        		iterator.next = currentNode;
        		iterator = iterator.next;
        	}
        } while( l1 != null || l2 != null );
        
        // Finally, we check if there is an additional node to be added
        if( carry != 0 ) {
        	iterator.next = new ListNode( carry );
        }
        
        return result;
    }
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		AddTwoNumbers a =  new AddTwoNumbers();
		
		ListNode l1 = a.new ListNode(2);
		l1.next = a.new ListNode(4);
		l1.next.next = a.new ListNode(3);
		
		ListNode l2 = a.new ListNode(10);
		
		a.addTwoNumbers(l1, l2);
	}
}
