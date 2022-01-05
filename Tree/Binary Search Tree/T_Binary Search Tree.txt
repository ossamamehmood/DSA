/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbst_java;

import java.util.Scanner;

/**
 *
 * @author usman
 */




public class TBST_JAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Scanner in=new Scanner(System.in);
        tbst o=new tbst();
        int choice, num;
	
	o.insert_head();
	while(true)
	{
                          System.out.println("1. Insert");
		          System.out.println("2. Delete");
		          System.out.println("3. Inorder Traversal ");
		          System.out.println("4. Preorder Traversal ");
		          System.out.println("5. Posrorder Traversal");
		          System.out.println("6. Quit");
		          System.out.println("Enter your choice :");
		choice=in.nextInt();		
		switch(choice)
		{
			case 1:
				System.out.println("Enter the number to be inserted");
				num=in.nextInt();
				o.insert(num);
				break;
			case 2:
				System.out.println("Enter the number to be deleted");
				num=in.nextInt();
				o.delet(num);
				break;
			case 3:
				o.inorder();
				break;
			case 4:
				o.pre(o.head.leftptr);
				break;
			case 5:
				o.post(o.head.leftptr);
				break;
			case 6:
				return;  
			default:
                            System.out.println("error");
		}
	}
    }
    
}


class node
{   
   
	node leftptr;
	boolean left;
	int info;
	boolean right; 
	node rightptr;
};

class tbst
{
    boolean thread,link=true;
    node  parent=null,  location=null;
    node head;

void insert_head()
{
	
	head = new node();
	head.info = 999999;
	head.left =thread;
	head.leftptr = head;
	head.right =link;
	head.rightptr = head;
}	
void find(int item)
{
	node ptr, ptrsave=null;
	
	if(head.leftptr==head)
	{
		location = null;
		parent = head;
		return;
	}
	if(item==head.leftptr.info)
	{
		location = head.leftptr;
		parent = head;
		 return;
	}
	ptr = head.leftptr;
	while(ptr!=head)
	{
		ptrsave = ptr;
		if(item<ptr.info)
		{
			if(ptr.left==link)	ptr=ptr.leftptr;
                        else break;
		}
                else if(item>ptr.info)
		{
			if(ptr.right==link)	ptr=ptr.rightptr;
			else break;
		}
		if(item==ptr.info)
		{
			location=ptr;
			parent=ptrsave;
			return;
		}
	}
location=null;
parent=ptrsave;
}
void insert(int item)
{
	node tmp;
	find(item);
        //System.out.println(parent.info);
	if(location!=null)
	{
            System.out.println("Item already present");
		return;
	}
	tmp=new node();
	tmp.info=item;
	tmp.left=thread;
	tmp.right=thread;

	if(parent==head)	
	{
		head.left=link;
		head.leftptr=tmp;
		tmp.leftptr=head;
		tmp.rightptr=head;
                tmp.right=thread;
                tmp.left=thread;
                return;
	}
	if(item<parent.info)	
	{
            
		tmp.leftptr=parent.leftptr;
		tmp.rightptr=parent;
                
		parent.left=link;
		parent.leftptr=tmp;
	}
	else	
	{
		tmp.leftptr=parent;
		tmp.rightptr=parent.rightptr;
		
                parent.right=link;
		parent.rightptr=tmp;
	}
}
void delet(int item)
{
	
	if(head==null)
	{
	           System.out.println("Tree is empty");
		return;
	}

        find(item);
        System.out.println(location.info);
	if(location==null)
	{
            System.out.println("Item not present in tree");
		return;
	}
	if((location.left==thread) && (location.right==thread))	casea(parent,location);
	if((location.left==link) && (location.right==thread))	caseb(parent,location);
	if((location.left==thread) && (location.right==link))	caseb(parent,location);
	if((location.left==link) && (location.right==link))	casec(parent,location);
	
}
void casea(node par, node loc)
{
	if(par==head)
	{
		head.left=thread;
		head.leftptr=head;
	}
	if(loc==par.leftptr)
	{
		par.left=thread;
		par.leftptr=loc.leftptr;
	}
	else
	{
		par.right=thread;
		par.rightptr=loc.rightptr;
	}

}
void caseb(node par, node loc)
{
	node child ,s,p;
	
	if(loc.left==link)	child=loc.leftptr;
	else child=loc.rightptr;
	
	if(par==head)	head.leftptr=child;
	else if(loc==par.leftptr)	par.leftptr=child;
	else par.rightptr=child;

	s = in_suc(loc);
	p = in_pred(loc);
	
	if(loc.right==link)		s.leftptr=p;
	else if(loc.left==link)	p.rightptr=s;
 
}
void casec(node par, node loc)
{// Find inorder successor and its parent. 
    node ptr=loc;
    node parsucc = ptr; 
   node succ = ptr.rightptr; 
  
    // Find leftmost child of successor 
    while (succ.left != thread) 
    { 
        parsucc = succ; 
        succ = succ.leftptr; 
    } 
  
    ptr.info = succ.info; 
  
   if((succ.left==thread) && (succ.right==thread))	casea(parsucc,succ);
    else
        caseb(parsucc,succ);
  
     
        
        
        
        
	
}
node in_suc(node ptr)
{
	node succ;
	if(ptr.right==thread)	succ=ptr.rightptr;
	else
	{
		ptr=ptr.rightptr;
		while(ptr.left==link)	ptr=ptr.leftptr;
		succ=ptr;
	}
	return succ;
}
node in_pred(node ptr)
{
	node pred;
	if(ptr.left==thread)	pred=ptr.leftptr;
	else
	{
		ptr=ptr.rightptr;
		while(ptr.left==link)	ptr=ptr.rightptr;
		pred=ptr;
	}
	return pred;
} 
void inorder()
{
	node ptr;
	if(head.leftptr==head)
	{
	System.out.println("Tree is empty");
		return;
	}
	ptr=head.leftptr;
	while(ptr.left==link)	ptr=ptr.leftptr;
	   System.out.print(ptr.info+" ");
	while(true)
	{
		ptr=in_suc(ptr);
		if(ptr==head)	break;
		 System.out.print(ptr.info+" ");
	}
}

void pre(node ptr){
    
    System.out.println(ptr.info);
    if (ptr.left!=thread)
        pre(ptr.leftptr);
    if (ptr.right!=thread)
        pre(ptr.rightptr);
}

void post(node ptr){
   
    
    if (ptr.left!=thread){
        post(ptr.leftptr);
    }
        
    if (ptr.right!=thread)
    {
        post(ptr.rightptr);
    }

    System.out.println(ptr.info);
}

}
