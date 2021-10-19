/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question4;

/**
 *
 * @author ossamamehmood
 */
public class Question4 {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
    // Initialize array
    int[][][] arr = {{{1, 2, 3}, {4, 5, 6}, {7, 8, 7}, {8, 9, 1}}, {{2, 3, 4}, {5, 7, 8}, {9, 1, 2}, {3, 4, 5}}};
    int count=2*4*3;
    int Sum=0;
    //calculate avg of numbers
    for(int[][] i: arr){
      for(int[] j : i){
        for(int k: j){
          Sum+=k;
        }
      }
    }
    //average is given by total sum divided by total number of counts
    float avg=(Sum/count);
    //prints average
    System.out.println("Average "+avg);
    
  }
    
}
