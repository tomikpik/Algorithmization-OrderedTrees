/*
    To avoid voluminous input data the following simplifying concept is used. 
    Let X, A, M, D be positive integers. For the input tree T it hods: 
    1. X is the key value of the root of T.
    2. The depth of T is less or equal to D.
    3. When the key value of a node is greater or equal to A than the node is a leaf. 
    4. When the depth of a node is less than D and its key value k is less than A then there are 
    two children of this node in T. The key value of the left child is 2 + (k2 mod M) and 
    the key value of the right child is 3 + (k2 mod M). 

    The input contains one text line with the values X, A, M, D in this order separated by space. 
    The value of D is less than 25, the other input values do not exceed 109.
 */

package alg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long x,a,m,d,count;
    static long[] path;
    
    
    public static void main(String[] args) throws IOException {
        quidoLoadsInput();
        quidosRecursion(x,0);
        System.out.println(count);
    }
    
    public static void quidosRecursion(long value,long depth){
        path[(int)(depth)]=value;       
        
        
        count+=count(depth);
        if((value<a)&&(depth<d)){    
            quidosRecursion(leftChild(value),depth+1);
            quidosRecursion(rightChild(value),depth+1);           
        }
        
    }
            
    private static void quidoLoadsInput() throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        x=Long.parseLong(st.nextToken());
        a=Long.parseLong(st.nextToken());
        m=Long.parseLong(st.nextToken());
        d=Long.parseLong(st.nextToken());
        path=new long[30]; 
        count=0;
    }
    
    private static long leftChild(long value){
        return 2+((value*value)%m);
    }

    private static long rightChild(long value){
        return 3+((value*value)%m);
    }
    
    private static long count(long depth){
        long compareValue=path[(int)(depth)];
        long count=0;
        for(long i=depth-1;i>=0;i--){
            if(path[(int)(i)]>compareValue){
                count++;
            }
        }
        return count;
    }
    
}
