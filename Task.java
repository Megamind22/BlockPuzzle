/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task;

/**
 *
 * @author vip
 */
import java.util.*;
public class Task {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner read=new Scanner(System.in).useLocale(Locale.US);
        System.out.println("enter ur N number..!");
        int x=read.nextInt();
        int a[]=new int[x];
        for (int i = 0; i < x; i++) {
            a[i]=read.nextInt();
        }
        int[][] aa=new int [a.length][a.length];
      int size=aa.length-1;
            for (int j = 0; j < aa[0].length; j++) {
                if (a[j]<=1)
                 aa[aa.length -1][j]=a[j];
                else{
                    for (int i = 0;i <a[j]; i++) {
                        aa[size-i][j]=1;
                    }
                
                }   
            }
        for (int i = 0; i < aa.length; i++) {
            for (int j = 0; j < aa[0].length; j++) {
                System.out.print(aa[i][j]+" ");//black ==1s..
            }
            System.out.println("");
        }
        
        System.out.println("the side length of the biggest black square is"+BlockPuzzle(aa));
        
    }
    public static int BlockPuzzle(int [][]z){
        
    int[][] cache=z.clone();
   
      int s=0;
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {
                if(i==0 || j==0){}
                else if (cache[i][j]>0){
                    cache[i][j]=1+Math.min(Math.min(cache[i][j-1],cache[i-1][j]),cache[i-1][j-1]);
                }
                s=Math.max(s,cache[i][j]);// n*n 
            }  
        }
        return s;
    
    
    
    }
    
}
