import java.util.Arrays;

public class Sorting_Algorithms {
    public static void main(String[] args) {
        int[] arr = {4,5,1,2,3};

        // Bubble Sort
        bubbleSort(arr);

        // selection sort
        selectionSort(arr);

        // Insertion Sort
         insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Insertion Sort
    static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0 ; i < n - 1; i++) {
            for (int j = i + 1; j > 0 ; j--) {
                if(arr[j] < arr[j - 1]) {
                    swap(arr,j,j - 1);
                } else {
                    break;
                }
            }
        }
    }

    // Selection Sort
    static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int max = 0;
            int last = n - 1 - i;
            for (int j = 1; j <= last; j++) {
                if(arr[max] < arr[j]) {
                    max = j;
                }
            }
            swap(arr,max,last);
        }
    }

    // Bubble Sort
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n ; i++) {
            boolean swapped = false;
            for (int j = 1; j < n - i ; j++) {
                if(arr[j] < arr[j - 1]){
                    swap(arr,j,j - 1);
                    swapped = true;
                }
            }
            // if not a single element in j loop is swapped ,
            // that means array is sorted, break the i loop here
            if(!swapped) {
                break;
            }
        }
    }

    static void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
