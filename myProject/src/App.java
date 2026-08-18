import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public static void printStudentMarks(ArrayList<ArrayList<Integer>> marks) {
        // marks = [[10, 70, 20], [-20, 30, 20], [10,20]]
        for (int i = 0; i < marks.size(); i++) {
            ArrayList<Integer> currentStudentMarks = marks.get(i);
            for (int j = 0; j < currentStudentMarks.size(); j++) {
                System.out.print(currentStudentMarks.get(i));
            }
        }
    }
}
