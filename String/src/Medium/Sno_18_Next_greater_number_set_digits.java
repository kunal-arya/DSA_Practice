package Medium;

public class Sno_18_Next_greater_number_set_digits {
    public static void main(String[] args) {
     int num  = 18468;

        System.out.println(nextPerm(num));
    }

    static int nextPerm(int num ) {
        String str = String.valueOf(num);
        char[] arr = str.toCharArray();

        int n = arr.length;
        int pivot = -1;

        for (int i = n - 1; i > 0 ; i--) {
            if(arr[i] > arr[i - 1]) {
                pivot = i - 1;
                break;
            }
        }

        if(pivot == -1) {
            return pivot;
        }

        int next = -1;

        for (int i = n - 1; i > pivot; i--) {
            if (arr[i] > arr[pivot]) {
                next = i;
                break;
            }
        }

        // swap the element
        swap(arr,next,pivot);

        // reverse the array from pivot + 1 to n - 1
        int i = pivot + 1;
        int j = n - 1;

        while (i <= j) {
            swap(arr,i,j);
            i++;
            j--;
        }


        return Integer.parseInt(String.valueOf(arr));
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
