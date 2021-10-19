/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularlinklist;
import java.util.Scanner;

/**
 *
 * @author ossam
 */

class node {
	int info;
	node link;
	
}

public class CircularLinklist {

    /**
     * @param args the command line arguments
     */
    
	static node last;
	
	static void create_list(int data) {
		if (last == null) {
			last = new node();
			last.info = data;
			last.link = last;
		} else {
			node temp = new node();
			temp.info = data;
			temp.link = last.link;
			last.link = temp;
			last = temp;
		}
	}

	static void addatbeg(int data) {
		if (last == null) {
			last = new node();
			last.info = data;
			last.link = last;
		} else {
			node temp = new node();
			temp.info = data;
			temp.link = last.link;
			last.link = temp;
		}

	}

	static void addafter(int data, int pos) {
		node temp = last.link;
		for(int i=0; i<pos-1;i++) {
			temp = temp.link;
			if(temp == last && i != pos-2) {
				System.out.println("Index out of bound");
				return;
			}
		}
		if(temp == last)
			create_list(data);
		else {
			node n = new node();
			n.info = data;
			n.link = temp.link;
			temp.link = n;
		}
	}

	static void del(int data) {
		if(last.link == last && last.info == data) {
			last = null;
		}else {
			node q = last;
			while(q.link != last) {
				if(q.link.info == data) {
					q.link = q.link.link;
					return;
				}
				q = q.link;
			}
			if(q.link.info == data) {
				q.link = q.link.link;
				last = q;
				return;
			}
		}
		System.out.println("Element " + data + " not found");
	}

	static void display() {
		if (last == null) {
			System.out.println("List is empty");
			return;
		}
		node q = last.link;
		System.out.print("List is: ");
		while (q != last) {
			System.out.print(q.info + "   ");
			q = q.link;
		}
		System.out.println(q.info);
	}

	static void count() {
		if (last == null) {
			System.out.println("List is empty");
			return;
		}
		node q = last.link;
		int cnt =1;
		while (q != last) {
			cnt++;
			q = q.link;
		}
		System.out.println("Number of elements are " + cnt);
	}

	static void search(int data) {
		node ptr = last.link;
		int pos = 1;
		do {
			if (ptr.info == data) {
				System.out.println("Item " + data + " found at position " + pos);
				return;
			}
			ptr = ptr.link;
			pos++;
		}while (ptr != last);
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
                    
                    System.out.println("\n\t Choose (4) To Delect");
                    
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
					System.out.print("\nEnter yours choice : ");
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
                                
				System.out.println("\nEnter the element to be searched");
				m = cin.nextInt();
				search(m);
				break;
			
                            case 8:
                                
				rep = false;
				break;
			
                            default:
				System.out.println("\nWrong choice");
			}
		}
		cin.close();

	}

}