

package pathmtrix;

import java.util.Scanner;

public class Path {
    
    static int n;
     int MAX=20;
     int w_adj[][]=new int[MAX][MAX], adj[][]=new int[MAX][MAX], 	adjp[][]=new int[MAX][MAX],x[][]=new int[MAX][MAX], path[][]=new int[MAX][MAX];
    public static void main(String[] args) {
        Path o=new Path();
         Scanner in=new Scanner(System.in);
         
       int i, j, p=1;
        System.out.println("Enter number of nodes");
        n=in.nextInt();
        System.out.println("Input no. of vertices Weighted adjancy matrix");
for(i=0;i<n;i++)
	for(j=0;j<n;j++)  o.w_adj[i][j]=in.nextInt();
o.display(o.w_adj);
o.to_boolean(o.w_adj,o.adj);
o.display(o.adj);
while(true)
{
	   System.out.println("Enter the path length to be searched 0 to exit");
	p=in.nextInt();
	if(p==0) break;
	o.pow_matrix(o.adj,p,o.adjp);
	o.display(o.adjp);
}

for(i=0;i<n;i++)
	for(j=0;j<n;j++) o.x[i][j]=0;
for(p=1;p<=n;p++)
{
	o.pow_matrix(o.adj,p,o.adjp);
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)	o.x[i][j]=o.x[i][j]+o.adjp[i][j];
}

o.display(o.x);
o.to_boolean(o.x,o.path);
o.display(o.path);
o.Connected(o.path);
    }
void display(int matrix[][])
{
	int i,j;
	for (i=0;i<n;i++)
	{
		for(j=0;j<n;j++) System.out.print(matrix[i][j]+" ");
		          System.out.println();
	}
}
void to_boolean(int mat[][],int boolmat[][])
{
	int k,j;
	for(k=0;k<n;k++)
		for(j=0;j<n;j++) 
			if(mat[k][j]==0) boolmat[k][j]=0;
			else boolmat[k][j]=1;
}

void pow_matrix(int adj[][], int p, int adjp[][])
{
	int i,j,k,tmp[][]=new int[MAX][MAX];
	for(i=0;i<n;i++)
		for(j=0;j<n;j++) adjp[i][j]=adj[i][j];
	for(k=1;k<p;k++)
	{
		multiply(adjp,adj,tmp);
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)	adjp[i][j]=tmp[i][j];
	}
}
void multiply(int mat1[][], int mat2[][], int mat3[][])
{
	int i,j,k;
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
		{
			mat3[i][j]=0;
			for(k=0;k<n;k++) mat3[i][j]=mat3[i][j]+mat1[i][k]*mat2[k][j];
		}
}
void Connected(int mat[][])
{   int i,j;
    for(i=0;i<n;i++)
		for(j=0;j<n;j++)
                {
                    if(mat[i][j]!=1)
                    {
                        System.out.println("Weekly connected ");
                        return;
                    }
                }    
    System.out.println(" Strongly conneted ");
}
}
