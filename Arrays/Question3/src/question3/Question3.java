/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question3;
import java.util.*;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author ossamamehmood
 */
public class Question3 {

    /**
     * @param args the command line arguments
     */
    
   public static void main(String args[]){
    // TODO code application logic here
    
    ArrayList<Integer> evenarray=new ArrayList<Integer>();
    // declare variables 
    
    int Size1 = 3; 
    int Size2 = 4; 
    int Size3 = 2;
    
    // create Scanner class object to read input
    Scanner scan = new Scanner(System.in);
    
    // create 3D array with given sizes
    int[][][] arr = new int[Size1][Size2][Size3]; // 3D array
    
    // read input value 
    System.out.println("Enter array elements: ");
    for(int i=0; i<Size1; i++) {
      for(int j=0; j<Size2; j++) {
        for(int k=0; k<Size3; k++) {
          System.out.print("Element["+i+"]["+j+"]["+k+"]: ");
          arr[i][j][k] = scan.nextInt();
        }
      }
    }
    
    // displaying three dimensional array
    System.out.println("\nEntered 3D array,");
    for(int[][] i: arr){
      for(int[] j : i){
        for(int k: j){
          System.out.print(k + " ");
        }
        System.out.println(); // new line
      }
      System.out.println(); // new line
    }
    
    // print 3D array in list format
    System.out.println(Arrays.deepToString(arr));
    // close Scanner
    scan.close();
    
    int maxElement=-999999999;
    int neg_count=0;
    for(int[][] i: arr){
      for(int[] j : i){
        for(int k: j){
          //to get maximum value
          if (k > maxElement) {
                maxElement = k;
            }
          //to get even values and add to arraylist
          if(k%2==0)
          {
            evenarray.add(k);
          }
          //to check for negative number and increment its count
          if(k<0)
          {
              neg_count++;
          }
        }
      }
    }
    System.out.println("maximum element "+maxElement);
    System.out.println("Negative count "+neg_count);
    System.out.println("Even numbers in 3D array are "+Arrays.deepToString(evenarray.toArray()));
     
  }

}