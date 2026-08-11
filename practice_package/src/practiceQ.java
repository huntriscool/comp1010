import java.util.Arrays;

public class practiceQ {
    public static void main(String[] args) throws Exception {
        System.out.println(mutuallyReversable(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 6, 5, 4, 3, 2, 1 })); // expect true
        System.out.println(Arrays.toString(getReverse(new int[] { 1, 2, 3, 4, 5, 6 }))); // expect 6,5,4,3,2,1
        System.out.println(delegation(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 6, 5, 4, 3, 2, 1 })); // expect true
    }
    //Define a function that when passed 2 integer arrays, returns true if they are mutally reversable.
    //False otherwise
    public static boolean mutuallyReversable(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a.length != b.length || a[i] != b[b.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
    
    //Define a function that when passed an integer array, returns the reverse of the array.
    public static int[] getReverse(int[] data) {
        for (int i = 0; i < data.length / 2; i++) {
            int temp = data[i];
            data[i] = data[data.length - 1 - i];
            data[data.length - 1 - i] = temp;
        }
        return data;
    }
    
    //using the above information make the first test easier
    public static boolean delegation(int[] a, int[] b) {
        int[] newArr = new int[a.length];
        newArr = getReverse(b);
        if (newArr == a) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] getPositives(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                count++;
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                result[i] = arr[i];
            }
        }

        return result;
    }

}
