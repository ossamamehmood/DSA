/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question1;

import java.util.*;

/**
 *
 * @author ossamamehmood
 */
public class Question1 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner br = new Scanner(System.in);
        int i,j,count_g=0,count_b=0;
        double sum=0,avg;
        double arr[][] = new double [4][2];
        for(i=0;i<4;i++)
            for(j=0;j<2;j++)
            {
                arr[i][j]=br.nextInt();
           if(arr[i][j]>100) 
                {
                    System.out.println("Enter a value less than 100: ");
                    System.exit(0);
            } 
    }
    for(i=0;i<4;i++)
            for(j=0;j<2;j++)
                sum=sum+arr[i][j];
    avg=sum/8;
    for(i=0;i<4;i++)
            for(j=0;j<2;j++)
            {
                if(arr[i][j]>=avg)
                    count_g++;
                else
                    count_b++;
            }
        System.out.println("The number of values above or equal to average: "+count_g);
        System.out.println("The number of values above less than average: "+count_b);
}
}