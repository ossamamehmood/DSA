/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublelinklist;
import java.util.Scanner;

/**
 *
 * @author ossamamehmood
 */

class node {
	
	int info;

	node next;

	node prev;

}


public class DoubleLinklist {

    /**
     * @param args the command line arguments
     */
    
	static node start;


	public static void create_list(int data) {
		
	if (start == null) {
			
	start = new node();
			
	start.info = data;
		}
 else {
			
	node q = start;
			while (q.next != null)
				q = q.next;
			node temp = new node();
			temp.info = data;
			q.next = temp;
			temp.prev = q;

		}
	}

	static void addatbeg(int data) {
		node tmp = new node();
		tmp.info = data;
		tmp.next = start;
		tmp.prev = null;
 start.prev = tmp;		start = tmp;
	}

	static void addafter(int data, int pos) {
		node tmp, q;
		int i;
		q = start;
		for (i = 0; i < pos; i++) {
			q = q.next;
			if (q == null) {
				System.out.println("There are less than " + pos + " elements");
				return;
			}
		}
		tmp = new node();
		tmp.next = q.next;
		tmp.info = data;
		q.next = tmp;
		tmp.prev = q;
	}

	public static void del(int data) {
		node tmp, q;
		if (start.info == data) {
			tmp = start;
			start = start.next; /* first element deleted */
			if(start != null)
				start.prev = null;
			// delete(tmp);
			return;
		}
		q = start;
		while (q.next.next != null) {
			if (q.next.info == data) /* element deleted in between */
			{
				tmp = q.next;
				q.next = tmp.next;
				tmp.next.prev = q;
				// free(tmp);
				return;
			}
			q = q.next;
		}
		if (q.next.info == data) /* last element deleted */
		{
			tmp = q.next;

			q.next = null;
			return;
		}
		System.out.println("Element " + data + " not found");
	}

	public static void display() {
		node q;
		if (start == null) {
			System.out.println("List is empty");
			return;
		}
		q = start;
		System.out.println("List is:");
		while (q != null) {
			System.out.println(q.info + "   ");
			q = q.next;
		}
		System.out.println();
	}

	static void count() {
		node q = start;
		int cnt = 0;
		while (q != null) {
			q = q.next;
			cnt++;
		}
		System.out.println("Number of elements are " + cnt);
	}

	public static void rev() {
		node p1, p2;
		if (start.next == null)
			return; /* only one element */

		p1 = start;
		p2 = p1.next;

		p1.next = null;
		p1.prev = p2;
		while (p2 != null) {
			p2.prev = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p2.prev; /* next of p2 changed to prev */
		}
		start = p1;
	}

	public static void search(int data) {
		node ptr = start;
		int pos = 1;
		while (ptr != null) {
			if (ptr.info == data) {
				System.out.println("Item " + data + " found at position " + pos);
				return;
			}
			ptr = ptr.next;
			pos++;
		}
		if (ptr == null)
			System.out.println("Item " + data + " not found in list");
	}

	public static void main(String[] args) {
        // TODO code application logic here

		Scanner cin = new Scanner(System.in);

		int choice, n, m, position, i;
		node start = new node();
		boolean rep = true;
		while (rep) {
                    
                    System.out.println("\t - - - - - - - - - - - - - - ");
                    
                    System.out.println("\n\t  Peform Linklist Operation\n");
                    
                    System.out.println("\t - - - - - - - - - - - - - - ");
                    
                    System.out.println("\n\t Choose (1) To Create List");
			
                    System.out.println("\n\t Choose (2) To Add At Beginning");
                    
                    System.out.println("\n\t Choose (3) To Add At After");
                    
                    System.out.println("\n\t Choose (4) To Delete");
                    
                    System.out.println("\n\t Choose (5) To Display");
                    
                    System.out.println("\n\t Choose (6) To Count ");
                    
                    System.out.println("\n\t Choose (7) To Searching");
                    
                    System.out.println("\n\t Choose (8) To Quit");
                 

			System.out.print("\nEnter yours choice : ");
			choice = cin.nextInt();
			switch (choice) {
			case 1:
				System.out.print("\nEnter the element : ");
				n = cin.nextInt();
				for (i = 0; i < n; i++) {
					System.out.println("\nEnter the element");
					m = cin.nextInt();
					create_list(m);
				}
				break;
			case 2:
				System.out.println("\nEnter the element");
				m = cin.nextInt();
				addatbeg(m);
				break;
			case 3:
				System.out.println("\nEnter the element");
				m = cin.nextInt();
				System.out.println("\nEnter the position after which this element is inserted");
				position = cin.nextInt();
				addafter(m, position);
				break;
			case 4:
				if (start == null) {
					System.out.println("\nList is empty");
					continue;
				}
				System.out.println("\nEnter the element for deletion");
				m = cin.nextInt();
				del(m);
				break;
			case 5:
				display();
				break;
			case 6:
				count();
				break;
			case 7:
				rev();
				break;
			case 8:
				System.out.println("\nEnter the element to be searched");
				m = cin.nextInt();
				search(m);
				break;
			case 9:
				rep = false;
				break;
			default:
				System.out.println("\nWrong choice");
			}
		}
		cin.close();

	}

}