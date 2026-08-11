public class App {
    public static void main(String[] args) throws Exception {
        //TEST
        System.out.println(isEven(3)); // EXPECT FALSE
        System.out.println(isOdd(3)); // EXPECT TRUE
        System.out.println(sumOf(3,5)); // EXPECT 8
    }

    //sum 2 numbers
    public static int sumOf(int a, int b) {
        return a + b;
    }

    //is number even
    public static boolean isEven(int a) {
        if (a % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    //is number odd
    public static boolean isOdd(int a) {
        return !isEven(a);
    }
}
