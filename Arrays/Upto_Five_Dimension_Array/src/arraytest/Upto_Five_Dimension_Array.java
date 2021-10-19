/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraytest;

import java.util.Arrays;

/**
 *
 * @author ossam
 */
public class Upto_Five_Dimension_Array {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        int [][] Two_Dimension = new int[10][5];
        int [][] Two_Dimension_Initialization = {{1,2,3},
                {4,5,6},
                {7,8,9},
                {0,6,9}
        };
        
        
        int [][][] Three_Dimension = new int[15][5][2];
        int [][][] Three_Dimension_Initialization = {{{1,2,3},{4,5,6},{7,8,9},{1,2,4}},
            {{4,2,1},{3,4,1},{1,4,3},{4,3,2}}
        };
        
        
        int [][][][] Four_Dimension = new int[15][5][2][1];
        int [][][][] Four_Dimension_Initialization = {{{{1,2,3},{4,5,6},{7,8,9},{1,2,4}},
            {{4,2,1},{3,4,1},{1,4,3},{4,3,2}}},
            {{{1,2,3},{4,5,6},{7,8,9},{1,2,4}},
            {{4,2,1},{3,4,1},{1,4,3},{4,3,2}}}
        };       


        int [][][][][] Five_Dimension = new int[15][5][2][1][0];
        int [][][][][] Five_Dimension_Initialization = {{{{{1,2,3},{4,5,6},{7,8,9},{1,2,4}},
            {{4,2,1},{3,4,1},{1,4,3},{4,3,2}}},
            {{{1,2,3},{4,5,6},{7,8,9},{1,2,4}},
            {{4,2,1},{3,4,1},{1,4,3},{4,3,2}}},
            {{{1,2,3},{4,5,6},{7,8,9},{1,2,4}},
            {{4,2,1},{3,4,1},{1,4,3},{4,3,2}}},
            {{{1,2,3},{4,5,6},{7,8,9},{1,2,4}},
            {{4,2,1},{3,4,1},{1,4,3},{4,3,2}}}}
        };            
        
        // 2D Array
        System.out.println("\n\n\t\t\t\t\t\t\t\t Two Dimension Array");     
        System.out.println("\n\n\t Two Dimension Array : " + Arrays.deepToString(Two_Dimension)); 
        System.out.println("\n\t Two Dimension Array With Initialization : " + Arrays.deepToString(Two_Dimension_Initialization)); 
        
        // 3D Array
        System.out.println("\n\n\t\t\t\t\t\t\t\t Three Dimension Array");                     
        System.out.println("\n\n\t Three Dimension Array : " + Arrays.deepToString(Three_Dimension)); 
        System.out.println("\n\t Three Dimension Array With Initialization : " + Arrays.deepToString(Three_Dimension_Initialization)); 
        
        // 4D Array
        System.out.println("\n\n\t\t\t\t\t\t\t\t Four Dimension Array");                     
        System.out.println("\n\n\t Four Dimension Array : " + Arrays.deepToString(Four_Dimension)); 
        System.out.println("\n\t Four Dimension Array With Initialization : " + Arrays.deepToString(Four_Dimension_Initialization)); 
        
        // 5D Array
        System.out.println("\n\n\t\t\t\t\t\t\t\t Five Dimension Array");         
        System.out.println("\n\n\t Five Dimension Array : " + Arrays.deepToString(Five_Dimension)); 
        System.out.println("\n\t Five Dimension Array With Initialization : " + Arrays.deepToString(Five_Dimension_Initialization));         
           
        
}
}