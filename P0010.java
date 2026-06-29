package p0010;

import java.util.Random;
import java.util.Scanner;

public class P0010 {

    public static void main(String[] args) {
        //step 1: input number of array 
        int num = inputNumOfArr();
        //step 2: input search number
        int search = inputSearchNum();
        //step 3: generate array
        int[] array = GenerateArray(num);
        //step 4: display array
        displayArray(array);
        //step 5: display index of search number
        int i = linnerSearch(array, search);
        displayIndex(i, search);
    }

    public static int inputNumOfArr() {
        int num;
        Scanner sc = new Scanner(System.in);
        // loop infinite
        while (true) {
            try {
                System.out.println("Enter a number of array: ");
                num = Integer.parseInt(sc.nextLine());
                // if num is negative or zero
                if (num <= 0) {
                    System.out.println("Please enter a number greater than 0");
                    continue;
                }
                break;
            } catch (Exception e) {   
                System.out.println("Please enter a integer");
            }
        }
        return num;
    }

    public static int inputSearchNum() {
        int s;
        Scanner sc = new Scanner(System.in);
        // loop infinite
        while (true) {
            try {
                System.out.println("Enter search value: ");
                s = Integer.parseInt(sc.nextLine());
                //if search num is negative or zero
                if (s <= 0) {
                    System.out.println("Please enter a number greater than 0: ");
                    continue;
                }
               
                break;
            } catch (Exception e) {
                System.out.println("Input again!!!");
            }
        }
        return s;
    }

    public static int[] GenerateArray(int num) {
        int[] array = new int[num];
        Random rd = new Random();
        // loop through array
        for (int i = 0; i < num; i++) {
            array[i] = rd.nextInt(num);
        }
        return array;
    }

    public static void displayArray(int[] array) {
        System.out.print("The array:");
        System.out.print("[");
        // loop through array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            // if it not final element 
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void displayIndex(int i, int s) {
        //if i not equal -1
            if (i != -1) {
                System.out.println("Found " + s + " at index: " + i);
            } else {System.out.println("Cannot found!!!");
            }
        
    }
    
    public static int linnerSearch(int[] arr, int s){
        // loop through array
        for (int i = 0; i < arr.length; i++) {
            // if element equal search number 
            if (arr[i] == s) {
                return i;
            }
        }
        return -1;
    }
}
