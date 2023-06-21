
package javaapplication42.osIdea;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;



public class ArrMatrix {
 
    public static void main(String[] args){
        
    int size,i,j,k,l,count,count2=0,bigMatrix=0,bigMatrix2=0;    
    
    Scanner input=new Scanner(System.in);
    System.out.println("please enter size of array");
    size=input.nextInt();
    int[] array=new int[size];
    int[][] matrix=new int[array.length][array.length];
    
    
    System.out.println("please enter elements of array");
    
    for( i=0;i<array.length;i++){
    array[i]=input.nextInt();
    }


    

    
    for(j=0;j<matrix.length;j++){
    
        for(i=matrix[j].length-1;i>=0;i--){
            
            if(count2<array[j]){
            matrix[i][j]=1;
            count2++;
            }else{
            matrix[i][j]=0;
            }
        }
        
        count2=0;
        
    }
    
    
       for(i=0;i<matrix.length;i++){
        for(j=0;j<matrix[i].length;j++){
            System.out.print(matrix[i][j]);
        }
        System.out.println("");
    }
    
    
            AtomicInteger maxsize = new AtomicInteger();
 
        findLargestSquare(matrix, matrix.length - 1, matrix[0].length - 1, maxsize);
        System.out.println("The size of largest square submatrix of 1's is " +
                maxsize.get());
    
    
    
    
 
    
    
   
}
    
        public static int findLargestSquare(int[][] M, int m, int n, AtomicInteger maxsize)
    {
        // base condition
        if (m == 0 || n == 0)
        {
            if (maxsize.get() != 0)
            {
                maxsize.set(Integer.max(maxsize.get(), M[m][n]));
                return M[m][n];
            }
 
            for (int i = 0; i <= m; i++)
            {
                if (M[i][n] == 1)
                {
                    maxsize.set(1);
                    break;
                }
            }
 
            for (int j = 0; j <= n; j++)
            {
                if (M[m][j] == 1)
                {
                    maxsize.set(1);
                    break;
                }
            }
 
            return maxsize.get();
        }
 
        // find the largest square matrix ending at `M[m][n-1]`
        int left = findLargestSquare(M, m, n - 1, maxsize);
 
        // find the largest square matrix ending at `M[m-1][n]`
        int top = findLargestSquare(M, m - 1, n, maxsize);
 
        // find the largest square matrix ending at `M[m-1][n-1]`
        int diagonal = findLargestSquare(M, m - 1, n - 1, maxsize);
 
        /* The largest square matrix ending at `mat[m][n]` will be 1 plus
            minimum of largest square matrix ending at `mat[m][n-1]`,
            mat[m-1][n] and mat[m-1][n-1] */
 
        int size = 0;
        if (M[m][n] != 0) {
            size = 1 + Integer.min(Integer.min(top, left), diagonal);
        }
 
        // update maximum size found so far
        maxsize.set(Integer.max(maxsize.get(), size));
 
        // return the size of the largest square matrix ending at `M[m][n]`
        return size;
    }

    
       
    }
    

