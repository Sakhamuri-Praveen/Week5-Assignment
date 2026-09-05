import java.util.*;

public class Problem4 {
    static double rowAverage(int[] row) {
        int sum = 0;

        for (int value : row)
            sum += value;

        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        String result = "";

        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);

            if (avg < threshold)
                result += "Row " + i + ": Quiet Zone";
            else
                result += "Row " + i + ": Buzzing Zone";

            if (i < seatingScores.length - 1)
                result += " | ";
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int[][] seatingScores = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int columns = sc.nextInt();
            seatingScores[i] = new int[columns];

            for (int j = 0; j < columns; j++)
                seatingScores[i][j] = sc.nextInt();
        }

        int threshold = sc.nextInt();

        System.out.println(classifyRows(seatingScores, threshold));
    }
}