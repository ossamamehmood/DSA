
package adjlinnklist;

import java.util.Scanner;

class node
{
	 node next;
	int name;
	edge adj;
}
class edge
{
	int dest;
	edge link;
}

public class ADJlinnklist {

  node start=null;
    public static void main(String[] args) {
        ADJlinnklist o=new ADJlinnklist();
       
       Scanner inn=new Scanner(System.in);
       int ch=0,origin,dest,nod;
       
     while(true)
     {
         
        System.out.println("1.Insert Node\n2.Insert edge\n3.Delete Node\n4.Delete Edge\n5.Display\n6.Exit");
        System.out.println("ENter you chooise");
        ch=inn.nextInt();
        
        switch(ch)
        {
            case 1: 
                System.out.println("Enter node ");
                nod=inn.nextInt();
                o.insert_node(nod);
                
                break;
            
            case 2: 
        while(true)
	{
		          System.out.println("Enter edge (0 0 ) to quit");
                          origin=inn.nextInt();
                          dest=inn.nextInt();
                          
		if((origin==0)&&(dest==0)) break;
		                o.insert_edge(origin,dest); 

	}
                
            break;
            case 3:
                System.out.println("Enter Node YOu want to Delete");
                nod=inn.nextInt();
                o.delete_node(nod); 
                o.delnode_edge(nod);
                
            break;
            case 4:
                System.out.println("Enter Origin and destination of Edge ");
                origin=inn.nextInt();
                dest=inn.nextInt();
                o.del_edge(origin,dest);
            break;
            case 5:
                
                o.display();
            break;
            case 6:
                
                return;  
            
            default:
                System.out.println("Invalid input");
            break;
        }
     }
        
}
    

void insert_node(int node_name)
{
	node tmp,ptr;
	tmp=new node();
	tmp.name=node_name;
	tmp.next=null;
	tmp.adj=null;
	if(start==null)
	{
		start=tmp;
		return;
	}
	ptr=start;
	while(ptr.next!=null) ptr=ptr.next;
	ptr.next=tmp;
}
void delete_node(int u)
{
	node tmp, q;
	if(start.name==u)
	{
		tmp=start;
		start=start.next;
		
		return;
	}
	q=start;
	while(q.next.next!=null)
	{
		if(q.next.name==u)
		{
			tmp=q.next;
			q.next=tmp.next;
			
			return;
		}
	q=q.next;
	}
	if(q.next.name==u)
	{
		
		q.next=null;
	}
}
void delnode_edge(int u)
{
	node ptr;
	edge q,start_edge,tmp;
	ptr=start;
	while(ptr!=null)
	{   
             if(ptr.adj!=null)
             {
		if(ptr.adj.dest==u)
		{
                    ptr.adj=ptr.adj.link;
                    break;
		}
		q=ptr.adj;
		while(q.link.link!=null)
		{
			if(q.link.dest==u)
			{
				tmp=q.link;
				q.link=tmp.link;
                                continue;
			}
			q=q.link;
		}
                if(q.link.dest==u)
		{
                    q.link=null;
		}
		ptr=ptr.next;
            }else
             {
                 break;
             }
	}
}
void insert_edge(int u, int v)
{
		node locu, locv;
		edge ptr, tmp;
		locu=find(u);
		locv=find(v);
		if(locu==null)
		{
			                 System.out.println("Source node not present");
                                         return;
		}
		if(locv==null)
		{
		                  System.out.println("Destination node not present");
			return;
		}
		tmp=new edge();
		tmp.dest=v;
		tmp.link=null;

		if(locu.adj==null)
		{
			locu.adj=tmp;
			return;
		}
		ptr=locu.adj;
		while(ptr.link!=null)   ptr=ptr.link;
		ptr.link=tmp;
}
void del_edge(int u, int v)
{
	node locu, locv;
	edge ptr, tmp, q;
	locu=find(u);
	if(locu==null)
	{
		          System.out.println("Source node not present");
		return;
	}
	if(locu.adj.dest==v)
	{
		
		locu.adj=locu.adj.link;
		
		return;
	}
	q=locu.adj;
	while(q.link.link!=null)
	{
		if(q.link.dest==v)
		{
			tmp=q.link;
			q.link=tmp.link;
			
			return;
		}
	q=q.link;
	{
	if(q.link.dest==v)
	{
		
		
		q.link=null;
		return;
	}
	           System.out.println("This edge is not present in the graph");
            }
}
}
node find(int item)
{
	node ptr, loc;
	ptr=start;
	while(ptr!=null)
	{
		if(item==ptr.name)
		{
			loc=ptr;
			return loc;
		}
		else ptr=ptr.next;
	}
loc=null;
return loc;
}
void display()
{
	node ptr;
	edge q;
	ptr=start;
	while(ptr!=null)
	{
		          System.out.print(ptr.name+" ");
		q=ptr.adj;
		while(q!=null)
		{
			                 System.out.print(q.dest +" ");
			q=q.link;
		}
		          System.out.println("");
	ptr=ptr.next;
	}
}


							



    
}
