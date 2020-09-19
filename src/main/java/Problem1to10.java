
public class Problem1to10 {
    private static int answer = 0;


    /*
    Problem 1
    If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
    Find the sum of all the multiples of 3 or 5 below 1000.

    https://projecteuler.net/problem=1
    */
    static void problem1(){
        for (int i = 0; i < 1000; i++) {
            if( (i % 3 == 0) || ( i % 5 == 0 ) )
                answer += i;
        }

        System.out.println(answer);
    }


    /*
    Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
    1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
    By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
    https://projecteuler.net/problem=2
     */
    static void problem2(){
        int next = 3;
        int first = 1;
        int second = 2;
        int sum = 2;

        while(next < 4000000){
            if(next % 2 == 0)
                sum += next;

            first = second;
            second = next;
            next = first + second;
        }

        System.out.println(sum);
    }


    /*
    Integer factorization
    The prime factors of 13195 are 5, 7, 13 and 29.
    What is the largest prime factor of the number 600851475143 ?
    https://projecteuler.net/problem=3
     */

    static void problem3(long number){

        int i = 2;

        while(number != i){
            if(number % i != 0){
                i++;
            } else {
                number = number / i;
            }
        }
        System.out.println(number);
    }

    /*
    A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
    Find the largest palindrome made from the product of two 3-digit numbers.

    https://projecteuler.net/problem=4
     */
    static void problem4(){
        int multi;

        for(int i = 10; i < 100; i++){
            for(int j = 10; j < 100; j++){
                multi = i * j;
            }
        }
    }

    boolean checkPolindrome(int number){
        int length = String.valueOf(number).length();
        return true;
    }
}
