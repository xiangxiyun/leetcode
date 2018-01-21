import java.util.*;

public class ReverseInteger {

    public static void main(String[] args){

        int x = 2147483647;
        x = 123;
        int res = solution2(x);
        System.out.println(x);
        System.out.println(res);
    }

    private static int solution0(int x){
        /* convert the input to a string and then compute the reverse from the string*/
        return 0;
    }

    private static int solution1 (int x) {
        /* Divide x with 0 until remaining equals 0. 
        Save the remainder of x modulo 10 in a arraylist.
        Traverse the arraylist in reverse order and generate the result.*/
        int flag = 1;

        if(x < 0){
            flag = -1;
            x = -x;
        }


        ArrayList<Integer> a = new ArrayList<Integer>();

        while(x!= 0){
            a.add(x%10);
            x=x/10;
            
        }
        
        double res = 0;
        for(int i = a.size()-1; i >=0; i--){
            res += a.get(i)* Math.pow(10, a.size()-i-1);
            // System.out.println(res);
        }
        res *= flag;

        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;
        return (int)res;

    }

    private static int solution2(int x){
        /* Enhanced version of solution1.
         * Do not need arraylist.
         * Time Complexity O(n)
         * Space Complexity: O(1)
        */
        double result = 0;
        int remain = Math.abs(x);
        while(remain != 0){
            result = result*10 + remain % 10;
            remain /= 10;
        }

        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;

        return (int) (x<0 ? -result:result);
    }


}