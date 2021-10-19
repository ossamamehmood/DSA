/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlelinklist;
import java.util.Scanner;

/**
 *
 * @author ossamamehmood
 */

class node
{
    int info;
    node link;
    private String elements;
    
    public void create_list(int data)
    {
        node q,temp,start=this;
	temp=new node();
        
	temp.info=data;
	temp.link=null;

	if(this==null)	  
            start=temp;	
	else    	
	{
		q=this;
		while(q.link!=null)	q=q.link;
		q.link=temp;
	}
    }

public void display()
{
    node q;
    node start=this.link;
    
    
    
	if(start==null)
	{
		System.out.println("List is empty");
		return;
	}
	q=start;
	System.out.println("\nList is:");
	while(q!=null)
	{
		System.out.print(q.info+"   ");
		q=q.link;
	}
	System.out.println();
}

void addatbeg(int data){
    
    node start=this.link;
    node temp;
    temp=new node();
    temp.info=data;
    temp.link=start;
    this.link=temp;
    
}

void addafter(int data,int pos){
    
    node start=this;
    node tmp;
    node q;
    int i;
  
    q=start;
    for(i=0;i<pos;i++){
        q=q.link;
        if(q==null){
            System.out.println("There Are less then "+pos + elements);
            return;
            
        }
        tmp=new node();
        tmp.link=q.link;
        tmp.info=data;
        q.link=tmp;
    }
}

void count(){
    node q=this.link;
    int Cnt=0;
    while(q!=null){
        q=q.link;
        Cnt++;
    }
    System.out.println("No Of Elements Are" + Cnt);
    
    }


void Search(int data){
    
    node start=this.link;
    node q=start;
    int pos=1;
    while(q!=null)
    {
        if(q.info==data){
            System.out.println("Data Founded"+ data+"At Position" +pos);
        }
    }
}
}


public class SingleLinklist {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        
        Scanner cin=new Scanner (System.in);
        
       int choice,n = 0,m = 0,position,i;
	node start=new node();
	while(true)
	{
            
                System.out.println("\t - - - - - - - - - - - - - - ");
            
            	System.out.println("\n\t  Peform Linklist Operation\n");
                
                System.out.println("\t - - - - - - - - - - - - - - ");
                
		System.out.println("\n\t Choose (1) To Create List");
		
		System.out.println("\n\t Choose (2) To Display");
                
                System.out.println("\n\t Choose (3) To Add At Beginning");
                
                System.out.println("\n\t Choose (4) To Add At After");
                
                System.out.println("\n\t Choose (5) To Count ");
                
                System.out.println("\n\t Choose (7) To Searching");
		
		System.out.println("\n\t Choose (8) To Quit");
                 

		System.out.print("\nEnter yours choice : ");
		choice=cin.nextInt();
		switch(choice)
		{
			case 1:
				System.out.print("\nHow many nodes you want : ");
				n=cin.nextInt();
				for(i=0;i<n;i++)
				{
					System.out.print("\nEnter the element : ");
					m=cin.nextInt();
					start.create_list(m);
                                        start.display();
				}
				break;
			
			
			case 2:
				start.display();
				break;
                                
                        case 3:
                            int a;
                            Scanner sc=new Scanner(System.in);
                            System.out.println("\nEnter The Element You Want To Insert In Beginning");
                            a = sc.nextInt();
                            start.addatbeg(a);
                            start.display();
                            break;
                            
                        case 4:
                            int h,l;
                            sc = new Scanner(System.in);
                            System.out.println("\nEnter The Number Of Element You Want To Add");
                            h=sc.nextInt();
                            System.out.println("\nEnter The Number Of Element ");
                            l=sc.nextInt();
                            start.addafter(h, l);
                            start.display();
                            
                            break;
                            
                        case 5:
                            System.out.println("\nCounts No Of Element");
                            start.count();
                            start.display();
                            break;
                            
                        case 6:
                            int c;
                            sc=new Scanner(System.in);
                            c=sc.nextInt();
                            System.out.println("\nEnter The No To Search Element");
                            start.Search(c);
                            start.display();
                        case 7:
				break;
			default:
				System.out.println("\nWrong choice");
		}
	}
        
    }
    
}