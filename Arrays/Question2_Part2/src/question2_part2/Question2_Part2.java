/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2_part2;

/**
 *
 * @author ossamamehmood
 */
public class Question2_Part2 {

    /**
     * @param args the command line arguments
     */
    
        static void sum(int arr[][]){
        int sum=arr[0][0];
        for(int i=1;i<arr.length;i++)
        for(int j=1;j<arr[i].length;j++)
            sum=sum+arr[i][j];
        System.out.println(sum);
    }
           
    public static void main(String[] args){
        // TODO code application logic here
        int arr[][]={{4,5,6,7,8,9},
            {15,18,17,16,19,20},
            {21,22,25,26,28,30},
            {20,40,60,80,90,50},
            {75,65,78,90,100,80}};
        sum(arr);
       
       
            
        }
}
