import java.util.*;

public class Problem1to10 {

    /*
    Problem 1
    If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
    Find the sum of all the multiples of 3 or 5 below 1000.
    */
    static void problem1(){
        int answer = 0;

        for (int i = 0; i < 1000; i++) {
            if( (i % 3 == 0) || (i % 5 == 0) )
                answer += i;
        }

        System.out.println(answer);
    }


    /*
    Problem 2
    Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
    1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
    By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
     */
    static void fibonacciEvenValuedSum(int limit){
        int next = 3;
        int first = 1;
        int second = 2;
        int sum = 2;

        while(next <= limit){
            if(next % 2 == 0)
                sum += next;

            first = second;
            second = next;
            next = first + second;
        }

        System.out.println(sum);
    }


    /*
    Problem 3
    Integer factorization
    The prime factors of 13195 are 5, 7, 13 and 29.
    What is the largest prime factor of the number 600851475143 ?
     */

    static int largestPrimeFactor(long number){

        int i = 2;

        while(number != i){
            if(number % i != 0){
                i++;
            } else {
                number = number / i;
            }
        }
        return (int)number;
    }

    static List<Integer> allPrimeFactors(int number){

        int i = 2;
        List<Integer> arr = new ArrayList<Integer>();

        while(number != i){
            if(number % i != 0){
                i++;
            } else {
                number = number / i;
                arr.add(i);
            }
        }
        arr.add(i);

        return arr;
    }

    /*
    Problem 4
    A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
    Find the largest palindrome made from the product of two 3-digit numbers.
     */
    static void findLargestPolindrome(int lowerLimit, int upperLimit){
        for(int i = lowerLimit; i < upperLimit; i++){
                for(int j = lowerLimit; j < upperLimit; j++){
                    checkPoli(i * j) ;
                }
            }
    }

    static void checkPoli(int polindrome) {
        int length = (int)(Math.log10(polindrome)+1);
        char[] arr = String.valueOf(polindrome).toCharArray();

        for(int i = 0; i < arr.length / 2; i++){

            if( arr[i] != arr[length - i - 1] )
                return;

        }
        System.out.println(polindrome);
    }


    /*
    Problem5
    2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
    What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
     */
    static void problem5(int deviders){
        long start = System.currentTimeMillis();

        boolean numberFound ;
        int number = deviders;

        do{
            number++;
            numberFound = true;
            for(int i = 1; i <= deviders; i++){
                if(number % i != 0){
                    numberFound = false;
                }
            }
        }while(!numberFound);

        System.out.println(number);
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println(elapsedTime);
    }


    static void problem5v2(int deviders){
        //long start = System.currentTimeMillis();
        List<Integer> allDevidersPrime = new ArrayList<Integer>();
        List<Integer> tmpDeviders;
        int result = 1;

        for(int i = 2 ; i <= deviders; i++){
            tmpDeviders = allPrimeFactors(i);
            combineDeviders(tmpDeviders, allDevidersPrime);
        }

        for (Integer digit: allDevidersPrime) {
            result *= digit;
        }

        System.out.println("Smallest positive number: " + result);
        //long end = System.currentTimeMillis();
        //long elapsedTime = end - start;
        // System.out.println("time: " + elapsedTime);

    }

    static void combineDeviders(List<Integer> tmp, List<Integer> all){
        for(int i = 0; i < all.size(); i++){
            for(int j = 0; j < tmp.size(); j++){
                if(all.get(i) == tmp.get(j))
                        tmp.remove(j);
                        break;
            }
        }
        all.addAll(tmp);
    }

    static void printArrayList(List<Integer> arr){
        for (Integer i : arr) {
            System.out.print(i);
        }
    }

    /*
    Problem6
    The sum of the squares of the first ten natural numbers is,
    1^2 + 2^2 + ... + 10^2 = 385
    The square of the sum of the first ten natural numbers is,
    (1 + 2 + ... + 10)^2 = 55^2 = 3025
    Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is .
    3025 - 385 = 2640
    Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
     */

    static void problem6(){
        int sumOfSquares = 0;
        int squareOfSum = 0;
        for(int i = 1; i <= 100; i++){
            squareOfSum += ( i * i );
            sumOfSquares += i;
        }
        sumOfSquares *= sumOfSquares;

        System.out.println( sumOfSquares - squareOfSum);
    }

    /*
    Problem7
    By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
    What is the 10 001st prime number?
     */
    static void findNprimeNumber(int n){
        long start = System.currentTimeMillis();
        int i = 1;
        int number = 1;
        while(n >= i){
               number++;
               if(largestPrimeFactor(number) == number){
                   i++;
               }
        }
        System.out.println(number);
        System.out.println("Time spent: " + ( System.currentTimeMillis() - start));
    }
}

