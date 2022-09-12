package Hard;

public class Sno_06_Find_the_element_that_appears_once_and_others_thrice {
    public static void main(String[] args) {
        int[] arr = {-2,-2,1,1,4,1,4,4,-4,-2};
        int n = arr.length;

        int result = onceAppear(arr,n);
        System.out.println(result);

    }

    static int onceAppear(int[] arr, int n) {
        int n3 = -1, n3p1 = 0, n3p2 = 0;

        for (int i = 0; i < n ; i++) {
            int cwn3 = arr[i] & n3;
            int cwn3p1 = arr[i] & n3p1;
            int cwn3p2 = arr[i] & n3p2;

            n3 = n3 & (~cwn3);
            n3p1 = n3p1 | cwn3;

            n3p1 = n3p1 & (~cwn3p1);
            n3p2 = n3p2 | cwn3p1;

            n3p2 = n3p2 & (~cwn3p2);
            n3 = n3 | cwn3p2;
        }

        return n3p1;
    }
}
