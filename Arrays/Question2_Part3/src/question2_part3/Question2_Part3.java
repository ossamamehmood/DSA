/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2_part3;
import java.util.*;

/**
 *
 * @author ossamammehmood
 */
public class Question2_Part3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc= new Scanner(System.in);
        int row,col,i,j,sum=0;
        System.out.println("Enter number of rows:");
        row=sc.nextInt();
        System.out.println("Enter number of columns:");
        col=sc.nextInt();
        int [][] mat=new int[row][col];
        System.out.println("Enter elements of matrix:");
        for(i=0;i<row;i++)
        {
            for(j=0;j<col;j++)
            {
        
                mat[i][j]=sc.nextInt();
            }
        }
                System.out.println("The element of matrix:");
                for(i=0;i<row;i++)
                {
                    for(j=0;j<col;j++)
                    {
                        System.out.print(mat[i][j]+"\t");
                    }
                        System.out.println(" ");
                }
                for(i=0;i<row;i++)
                {
                    for(j=0;j<col;j++)
                    {
                        if(i==j){
                            sum=sum+mat[i][j];
                        }
                            
            }
        }
                System.out.println("Sum of elements in diagonal matrix is:"+sum);
                
    }
    
}
