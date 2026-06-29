
package p0006;

import java.util.Random;
import java.util.Scanner;

public class P0006 {

    public static void main(String[] args) {
        //step 1: input number of array 
        int num = inputNumOfArr();
        //step 2: input search number
        int search = inputSearchNum();
        //step 3: generate array
        int[] array = GenerateArray(num);
        // sort array
        int[] sortArr = SortArray(array);
        //step 4: display Sorted array
        displaySortedArray(array);
        //use binary search
        int index = BinarySearch(sortArr, search);
        //step 5: display index of search number
        displayIndex(index, search);
        DisplayBinarySearch(sortArr, search);
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
                //// if search num is negative or zero
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

    public static void displaySortedArray(int[] array) {
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

   
    private static int[] SortArray(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j]>arr[j+1]) {
                    int tmp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
        return arr;
    }
    
    public static int BinarySearch(int[] arr, int s){
        int left=0, right=arr.length-1, mid;
        //loop if left smaller or equal than right num
        while(left<=right){
            mid = (left+right)/2;
            //if search num equal mid
            if (s == arr[mid]) {
                return mid;
            }
            //if search num smaller than mid
            if (s < arr[mid]) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    
    
     public static void displayIndex(int i, int s) {
        //if i not equal -1
            if (i != -1) {
                System.out.println("Found " + s + " at index: " + i);
            } else {System.out.println("Cannot found!!!");
            }
        
    }
     
    public static void DisplayBinarySearch(int[] arr, int s){
        System.out.print("\nFind "+s+" in " );
        displaySortedArray(arr);
        int left=0, right=arr.length-1, mid;
        int k = 1;
        //
        while(left<=right){
            mid = (left+right)/2;
            System.out.print("\nStep " + k +" ");
            //
            if (s == arr[mid]) {
                System.out.println("(middle element is" +  arr[mid] + "=="+ s+" ): return index mid ");
                return;
            }
            //
            if (s < arr[mid]) {
                System.out.print("(middle element is" +  arr[mid] + ">"+ s+" ): ");
                right = mid-1;
            } else {
                System.out.print("(middle element is" +  arr[mid] + "<"+ s+" ): ");
                left = mid+1;
            }
            //
            for (int i = left; i <= right; i++) {
                System.out.print(arr[i]+" ");
            }
            k++;
        }
        System.out.println(" (searched value is absent)");
    }
}
