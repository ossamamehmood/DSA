/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package bst;

import java.util.Scanner;

/**
 *
 * @author hasna
 */
class node {
	int info;
	node lchild;
	node rchild;
}

class Binary {
    node root=null,parent=null,location=null;
    
	void find(int item) {
		node ptr, ptrsave;
		
		if(root==null) { // if null then tree is empty
			location = null;
			parent = null;
			return;
		}

		if(item==root.info) { // if found then item = root.info
			location = root;
			parent = null;
			return;
		}

		if(item<root.info) // if not root then either left (<) or right (>) of root
            ptr=root.lchild;
		else 
            ptr=root.rchild;
		ptrsave=root;

		while(ptr!=null) {// find the exact location
			if(item==ptr.info) { // if found then get location and return
				location = ptr;
				parent = ptrsave;
				return;
			}
			ptrsave=ptr; // if not found then search further by going left or right
			if(item<ptr.info)	
                ptr=ptr.lchild;
			else 
                ptr=ptr.rchild;
		}
        location=null;
        parent=ptrsave;
    }

	void insert(int item) {
		node tmp; //,parent=new node(), location=new node();
		find(item);
		if(root!=null && location!=null) {
			System.out.println("Item already present");
			return;
		}

		tmp=new node();
		tmp.info=item;
		tmp.lchild=null;
		tmp.rchild=null;

		if(parent==null) {
			root=tmp;
		}
		else if(item<parent.info) {
			parent.lchild=tmp;
		} else {
			parent.rchild=tmp;
		}
	}

	void delete(int item) {
	//	node parent=new node(), location=new node();
		if(root==null) {
			System.out.println("Tree is empty");
			return;
		}
		find(item); // it will the item to be deleted
		if(location==null) {
			System.out.println("Item not present in tree"); 
			return;
		}
		if( (location.lchild==null) && (location.rchild==null) )
				casea(parent,location);
		if( (location.lchild!=null) && (location.rchild==null) )
				caseb(parent,location);
		if( (location.lchild==null) && (location.rchild!=null) )
				caseb(parent,location);
		if( (location.lchild!=null) && (location.rchild!=null) )
				casec(parent,location);
		//free(location);
	}

	void casea(node par, node loc) {
		if(par==null)	root=null;
		else if(loc==par.lchild)	par.lchild=null;
		else par.rchild=null;
	}

	void caseb(node par, node loc) {
		node child;
		
		if(loc.lchild!=null)	child=loc.lchild;
		else child=loc.rchild;
		
		if(par==null)	root=child;
		else if(loc==par.lchild)	par.lchild=child;
		else par.rchild=child;
	}

	void casec(node par,node loc) {
		node ptr, ptrsave, suc, parsuc;
		
		ptrsave=loc;
		ptr=loc.rchild;

		while(ptr.lchild!=null) {
			ptrsave=ptr;
			ptr=ptr.lchild;
		}

		suc=ptr;
		parsuc=ptrsave;

		if(suc.lchild==null && suc.rchild==null)
			casea(parsuc,suc);
		else
			caseb(parsuc,suc);
		
		if(par==null)
			root=suc;
		else if(loc==par.lchild)
			par.lchild=suc;
		else
			par.rchild=suc;

		suc.lchild=loc.lchild;
		suc.rchild=loc.rchild;
	}

	void preorder(node ptr) {
		if(root==null) {
			System.out.println("Tree is empty");
			return;
		}
		if(ptr!=null) {
			System.out.println(ptr.info);
			preorder(ptr.lchild);
			preorder(ptr.rchild);
		}
	}

	void inorder(node ptr) {
		if(root==null) {
			System.out.println("Tree is empty");
			return;
		}
		if(ptr!=null) {
			System.out.println(ptr.info);
			inorder(ptr.lchild);
			// inorder(ptr.rchild);
		}
	}

	void postorder(node ptr) {
		if(root==null) {
			System.out.println("Tree is empty");
			return;
		}
		if(ptr!=null) {
			postorder(ptr.lchild);
			postorder(ptr.rchild);
			System.out.println(ptr.info);
		} 
	}
}

public class Q6 {
	    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int choice, num;
		Binary o=new Binary();

		while(true)	{
			System.out.println("1.Insert");
			System.out.println("2. Delete");
			System.out.println("3. Inorder Traversal");
			System.out.println("4. Preorder Traversal ");
			System.out.println("5. Postorder Traversal");
			System.out.println("6. Quit");
			System.out.println("Enter your choice :");
			choice=in.nextInt();
			
			switch(choice) {
				case 1:
					System.out.println("Enter the number to be inserted");
					num=in.nextInt();
					o.insert(num);
					break;
				case 2:
					System.out.println("Enter the number to be deleted");
					num=in.nextInt();
					o.delete(num);
					break;
				case 3:
					o.inorder(o.root);
					break;
				case 4:
					o.preorder(o.root);
					break;
				case 5:
					o.postorder(o.root);
					break;
				case 6:
					return;
				default:
					System.out.println("Wrong choice");
			}
		}
	}
}