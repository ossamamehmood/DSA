/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2_part1;

/**
 *
 * @author ossamamehood
 */
public class Question2_Part1 {
    
    static void min(int arr[][]){
        int min=arr[0][0];
        for(int i=1;i<arr.length;i++)
        for(int j=1;j<arr[i].length;j++)
            if(min>arr[i][j])
                min=arr[i][j];
        System.out.println(min);
    }
    public static void main(String[] args){
        // TODO code application logic here
        int arr[][]={{5,7,8,9,13,45},
        {25,54,67,89,65},
        {67,99,86,73,100},
        {5,6,15,25,30,18},
        {20,40,60,80,100,60}};
        min(arr);
    
    }
}
