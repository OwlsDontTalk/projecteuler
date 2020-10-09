import org.w3c.dom.ls.LSOutput;

import java.math.BigInteger;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
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

        System.out.println(number);
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

    static void adjacentDigitsMultiply(int number){
        String arr = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
        String[] digitsArr = arr.split("");
        int[] intArr = new int[arr.length()];
        int[] tmpArr = new int[number];
        long tmpProduct = 1;
        long maxProduct = 1;

        for(int i = 0; i < digitsArr.length; i++){
            intArr[i] = Integer.parseInt(digitsArr[i]);
        }

        for (int i = 0; i <= intArr.length - number; i++) {
            tmpProduct = 1;
            for (int j = 0; j < number; j++) {
                tmpArr[j] = intArr[i + j];
            }

            for (int tmpInt : tmpArr) {
                tmpProduct *= tmpInt;
            }

            if(tmpProduct > maxProduct) maxProduct = tmpProduct;

        }

        System.out.println(maxProduct);
    }


    static void problem9(){
        for(int i = 1; i < 1000; i++){
            for (int j = 1; j < 1000; j++) {
                for (int k = 1; k < 1000; k++) {
                    if( ((i*i) + (j*j)) == k*k){
                        if((i+j+k) == 1000 ){
                            System.out.println(i * j * k);
                            return;
                        }
                    }
                }
            }
        }

    }

    //Problem 10
    static void findAllPrimesBelow(long number){
        long sum = 0;

        for(int i = 1; i < number; i++){
            System.out.println(i + " " + sum);
            if(isNumberPrime(i))
                sum += i;
        }
        System.out.println(sum);
    }

    static boolean isNumberPrime(int n){
        // Corner case
        if (n <= 1) return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }


    //Problem 11
    //To-Do list: find soultion whatever it costs
    static void findMaxDirection(){
        int[][] arr = new int[20][20];

        arr[0] = new int[]{8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8};
        arr[1] = new int[]{49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 00};
        arr[2] = new int[]{81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65};
        arr[3] = new int[]{52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91};
        arr[4] = new int[]{22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80};
        arr[5] = new int[]{24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50};
        arr[6] = new int[]{32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70};
        arr[7] = new int[]{67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21};
        arr[8] = new int[]{24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72};
        arr[9] = new int[]{21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95};
        arr[10] = new int[]{78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92};
        arr[11] = new int[]{16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57};
        arr[12] = new int[]{86, 56, 0, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58};
        arr[13] = new int[]{19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40};
        arr[14] = new int[]{4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66};
        arr[15] = new int[]{88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69};
        arr[16] = new int[]{4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36};
        arr[17] = new int[]{20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16};
        arr[18] = new int[]{20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54};
        arr[19] = new int[]{1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48};



//        for(int i = 0; i < 20; i++){
//            System.out.println("");
//            for (int j = 0; j < 20; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//        }

        findMaxDirectionRow(arr);
        findMaxDirectionColumns(arr);
        findMaxDirectionDiagonally(arr);
    }

    static void findMaxDirectionRow(int[][] arr){
        int maxTmp = 1;
        int max = 1;

        for (int i = 0; i < 20; i++) {
            maxTmp = 1;

            for (int j = 0; j <=16; j++) {
                maxTmp = arr[i][j] * arr[i][j+1] * arr[i][j+2] * arr[i][j+3];
                if (max < maxTmp)
                    max = maxTmp;
            }
        }
        System.out.println(max);

    }

    static void findMaxDirectionColumns(int[][] arr){
        int maxTmp = 1;
        int max = 1;

        for (int i = 0; i < 20; i++) {
            maxTmp = 1;

            for (int j = 0; j <= 16; j++) {
                maxTmp = arr[j][i] * arr[j+1][i] * arr[j+2][i] * arr[j+3][i];
                if (max < maxTmp)
                    max = maxTmp;
            }
        }
        System.out.println(max);

    }

    static void findMaxDirectionDiagonally(int[][] arr){
        int maxTmp = 1;
        int max = 1;

        for (int i = 0; i <= 16; i++) {
            maxTmp = 1;

            for (int j = 0; j <= 16; j++) {
                maxTmp = arr[j][i] * arr[j+1][i+1] * arr[j+2][i+2] * arr[j+3][i+3];
                if (max < maxTmp)
                    max = maxTmp;
            }
        }
        System.out.println(max);

    }
    //------------------------------------------------------------


    //Problem 12


    //Problem 16

    //Problem 20
    static void factorialNumberDigitsSum(){
        int number = 100;
        int sum = 0;
        BigInteger factorial = BigInteger.valueOf(1);


        for(int i = number; i > 1; i--){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        String factorialString = factorial.toString();
        char[] factorialChar =  factorialString.toCharArray();

        for (int i = 0; i < factorialChar.length; i++) {
            sum += Character.getNumericValue(factorialChar[i]);
        }

        System.out.println(factorial);
        System.out.println(sum);
    }


}

