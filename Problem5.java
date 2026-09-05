import java.util.*;

public class Problem5 {
    static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }

        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        double compositeScore() {
            return cgpa * 10 + codingScore * 0.5;
        }

        public int compareTo(Candidate other) {
            return Double.compare(other.compositeScore(), this.compositeScore());
        }

        static String shortlistAndRank(Candidate[] candidates) {
            Candidate[] shortlisted = new Candidate[candidates.length];
            int count = 0;

            for (Candidate c : candidates) {
                if (isEligible(c.cgpa) ||
                    isEligible(c.cgpa, c.codingScore)) {
                    shortlisted[count++] = c;
                }
            }

            shortlisted = Arrays.copyOf(shortlisted, count);
            Arrays.sort(shortlisted);

            String result = "";

            for (int i = 0; i < shortlisted.length; i++) {
                result += (i + 1) + ". " + shortlisted[i].name +
                          " (" + shortlisted[i].compositeScore() + ")";

                if (i < shortlisted.length - 1)
                    result += " | ";
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            double cgpa = sc.nextDouble();
            int codingScore = sc.nextInt();
            sc.nextLine();

            candidates[i] = new Candidate(name, cgpa, codingScore);
        }

        System.out.println(Candidate.shortlistAndRank(candidates));
    }
}