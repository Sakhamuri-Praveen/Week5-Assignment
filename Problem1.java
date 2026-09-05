import java.util.*;

public class Problem1 {
    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++)
            scores[i] += bonus;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++)
            scores[i] = sc.nextInt();

        int bonus = sc.nextInt();

        curveScores(scores, bonus);
        System.out.println(Arrays.toString(scores));
    }
}