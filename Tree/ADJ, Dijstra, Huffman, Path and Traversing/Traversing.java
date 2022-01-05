/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traversing;

import java.util.Scanner;

/**
 *
 * @author hasna
 */
public class Traversing {
Scanner in=new Scanner(System.in);
    int  MAX=20;
    int adj[][]=new int[MAX][MAX];
 enum bool{FALSE,TRUE} 
  bool visited[]=new bool[MAX];
  int origin=0, dest=0;
 static int n;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
      Traversing o=new Traversing();
    o.create_graph(); 
    
    int ch=0,v=0;    
   while(true){
       System.out.println("");
        System.out.println("1.Display\n2.breadth first search\n3.depth first search  \n4.depth first serah using recursion\n5.Exit");
        System.out.println("ENter you chooise");
        ch=in.nextInt();
        
switch(ch)
{
    case 1:
        o.display();
        break;
    case 2:
        System.out.println("Enter starting node");
        v=in.nextInt();
        for(int i=1;i<=n;i++)
        o.visited[i]=bool.FALSE;
        o.bfs(v);
        
        break;
    case 3:
        System.out.println("Enter starting node");
        v=in.nextInt();
        for(int i=1;i<=n;i++)
        o.visited[i]=bool.FALSE;
        o.dfs(v);
        
         break;
    case 4:    
       System.out.println("Enter starting node");
        v=in.nextInt();
        for(int i=1;i<=n;i++)
        o.visited[i]=bool.FALSE;
        o.dfs_rec(v);
        
         break;
    case 5:
        
      return; 
        
    default:
        System.out.println("Invalid Input");
        
        break;
        
}
   }

    }
    
    
    
void create_graph()
{
    Scanner inn=new Scanner(System.in);
	int i, max_edges ;
	   System.out.println("Enter number of nodes:");
	n=inn.nextInt();
	max_edges=n*(n-1);   //directed graph)	
	for(i=1; i<=max_edges;i++)
	{
		          System.out.println("Enter edge (0 0 ) to quit");
                          origin=inn.nextInt();
                          dest=inn.nextInt();
                          
		if((origin==0)&&(dest==0)) break;
		if(origin>n||dest>n||origin<=0||dest<=0)
		{
			System.out.println("Invalid edge");
			i--;
		}
		else adj[origin][dest]=1;
	}
}    

void bfs(int v)
{
	int i,front,rear;
	int que[]=new int[MAX];
	front=rear=-1;
	 System.out.print(v+" - ");
	visited[v]=bool.TRUE;
	rear++;
	front++;
	que[rear]=v;
	while(front<=rear)
	{
		v=que[front];
		front++;
		for(i=1;i<=n;i++)
		{
			if(adj[v][i]==1 && visited[i]==bool.FALSE)
			{
				 System.out.print(i+"  ");
				visited[i]=bool.TRUE;
				rear++;
				que[rear]=i;
			}
		}
	}
}
void dfs(int v)
{
	int i,stack[]=new int[MAX], top=-1,popv,j,t,ch;
	top++;
	stack[top]=v;
	while(top>=0)
	{
		popv=stack[top];
		top--;
		if(visited[popv]==bool.FALSE)
		{
			System.out.print(popv+"  ");
			visited[popv]=bool.TRUE;
		}
		else	continue;
		for(i=n;i>=1;i--)
		{
			if(adj[popv][i]==1 && visited[i]==bool.FALSE)
			{
				top++;
				stack[top]=i;
			}
		}
	}
}
void dfs_rec(int v)
{
	int i;
	visited[v]=bool.TRUE;
	   System.out.print(v+"  ");
	for(i=1;i<=n;i++)
		if(adj[v][i]==1 && visited[i]==bool.FALSE)   dfs_rec(i);
}
void display()
{
	int i,j;
	for (i=1; i<=n;i++)
	{
		for(j=1;j<=n;j++)	System.out.print(adj[i][j]);
		System.out.println();
	}
}		

}
