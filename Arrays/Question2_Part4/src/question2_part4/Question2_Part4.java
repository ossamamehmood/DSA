/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2_part4;
import java.util.*;

/**
 *
 * @author ossamamehmood
 */
public class Question2_Part4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            // TODO code application logic here
        int row,col,i,j,sumofrow1,sumofcol2,sum=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of rows:");
        row=sc.nextInt();
        System.out.println("Enter number of colum:");
        col=sc.nextInt();
        
        int[][] mat= new int[row][col];
        System.out.println("Enter element of matrix:");
        for(i=0;i<row;i++)
        {
            for(j=0;j<col;j++)
            {
                mat[i][j]=sc.nextInt();
            }
        }
        
       
     System.out.println("The elements of the matrix") ;
     for(i=0;i<row;i++)
     { 
      for(j=0;j<col;j++)
      { 
        System.out.print(mat[i][j]+"\t");
     }
       System.out.println("");
 }
  
 
     for(i=0;i<row;i++)
     { 
         sumofrow1=0;
         
     for(j = 0; j < col; j++){    
              sumofrow1 = sumofrow1 + mat[i][j];    
            }    
            System.out.println("Sum of " + (i+1) +" row: " + sumofrow1);    
        }    
                
        for( i = 0; i < col; i++){    
            sumofcol2 = 0;    
            for( j = 0; j < row; j++){    
              sumofcol2 = sumofcol2 + mat[j][i];    
               }    
            System.out.println("Sum of " + (i+2) +" column: " + sumofcol2);    
        }     
        
    }
    
    }