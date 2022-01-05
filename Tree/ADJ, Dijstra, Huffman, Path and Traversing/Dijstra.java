/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package di;

import java.util.Scanner;

/**
 *
 * @author Student
 */
class node{
    int pred,dest,status;
}
public class Main {

  static int MAX =10;
  int TEMP =0,PERM =1,infinity= 9999;
  int adj[][]=new int[MAX][MAX];
  int n;
  int origin,dest,shortdist;
  
    public static void main(String[] args) {
      Scanner in=new Scanner(System.in);
      Main o=new Main();
       int path[]=new int[MAX];
	int count,source,dest;
	o.create_graph();
	o.display();   

	while(true)
	{
		System.out.println("Enter source node");
		source=in.nextInt();
                System.out.println("Enter destination node");
		dest=in.nextInt();
		if(source==0 || dest==0)   return;
		
  		count=o.findpath(source,dest,path);

		if(o.shortdist!=0)
		{
			System.out.println("Shortest distance  "+o.shortdist);
			System.out.println("Shortest path is:");
                        int i;
			for( i=count;i>1;i--) System.out.print(path[i]+"->");   
			System.out.println(path[i]);
		}
		else System.out.println("There is no path from source to destination node");
	}
    }
int findpath(int s,int d,int path[])
{
	node state[]=new node[MAX];
	int i,min,count=0,current,newdist,u,v;
	shortdist=0;
	for(i=1;i<=n;i++)
	{       
                state[i]=new node();
		state[i].pred=0;
		state[i].dest=infinity;
		state[i].status=TEMP;
	}
	state[s].pred=0;
	state[s].dest=0;
	state[s].status=PERM;

	current=s;
	while(current!=d)
	{
		for(i=1;i<=n;i++)
		{
			if(adj[current][i]>0 && state[i].status==TEMP)
			{
				newdist=state[current].dest+adj[current][i];
				if(newdist<state[i].dest)
				{
					state[i].pred=current;
					state[i].dest=newdist;
				}
			}
		}
		min=infinity;
		current=0;
		for(i=1;i<=n;i++)
		{
			if(state[i].status==TEMP && state[i].dest<min)
			{
				min=state[i].dest;
				current=i;
			}
		}
		if(current==0) return 0;
		state[current].status=PERM;
}

while(current!=0)
{
	count++;
	path[count]=current;
	current=state[current].pred;
}

for(i=count;i>1;i--)
{
	u=path[i];
	v=path[i-1];
	shortdist+=adj[u][v];
}
return count;
}
void create_graph()
{
    Scanner inn=new Scanner(System.in);
	int i, max_edges,weight ;
	   System.out.println("Enter number of nodes:");
	n=inn.nextInt();
	max_edges=n*(n-1);   //directed graph)	
	for(i=1; i<=max_edges;i++)
	{
		          System.out.println("Enter edge (0 0 ) to quit");
                         
                          origin=inn.nextInt();
                          dest=inn.nextInt();
                           weight=inn.nextInt();
                          
		if((origin==0)&&(dest==0)) break;
		if(origin>n||dest>n||origin<=0||dest<=0)
		{
			System.out.println("Invalid edge");
			i--;
		}
		else adj[origin][dest]=weight;
	}
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





