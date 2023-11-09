import java.io.*;
import java.util.Scanner;

class Questions {
    private String[] questionText = new String[5];
    private char[] questionAns = new char[5];
    private int count = 0;
    private int wrong = 0;

    public Questions() {
        // Default constructor
    }

    public Questions(String[] text, char[] ans) {
        this.questionText = text;
        this.questionAns = ans;
    }

    public void setQuestionText(String[] text, char[] ans) {
        this.questionText = text;
        this.questionAns = ans;
    }

    public void displayQuestions() {
        char opt;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("\n" + questionText[i]);
            System.out.print("Enter the answer to question " + (i + 1) + ": ");
            opt = scanner.next().charAt(0);

            if (opt != 'a' && opt != 'A' && opt != 'b' && opt != 'B' && opt != 'c' && opt != 'C') {
                for (int x = 1; x <= 10; x++) {
                    System.out.println("\nInvalid input\nReinput the option");
                    opt = scanner.next().charAt(0);
                }
            }

            if (questionAns[i] == Character.toLowerCase(opt) || questionAns[i] == Character.toUpperCase(opt)) {
                count++;
            } else {
                wrong++;
            }
        }
    }

    public int getCount() {
        return count;
    }

    public int getWrong() {
        return wrong;
    }

    // Reset count and wrong
    public void resetCount() {
        count = 0;
        wrong = 0;
    }
}

public class Open_ended_lab {
    private static Questions englishQuestions;
    private static Questions mathsQuestions;
    private static Questions physicsQuestions;
    private static Questions chemistryQuestions;

    public static void main(String[] args) {
        System.out.println("\t\t\t\tTotal marks are 20\n");
        System.out.print("\nEnter name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        File file = new File("a.txt");
        boolean fileExists = file.exists();

        if (!fileExists) {
            System.out.print("\nEnter password: ");
            String password = scanner.next();
            menu();
            Questions englishQuestions = new Questions();
            englishQuestions.setQuestionText(
                new String[]{
                    "Antonym of hurt is.\nA.healthy\nB.heal\nC.love\n",
                    "Genocide meaning.\nA.Murder of King.\nB.Murder of father.\nC.Murder of Race\n",
                    "You_______not worry about me.\nA.would\nB.need\nC.could\n",
                    "Translate the passage____English.\nA.to\nB.in\nC.into\n",
                    "Who is known as the point of nature?\nA.William Wordsworth\nB.Williams Shakespeare\nC.William Black\n"
                },
                new char[]{'b', 'c', 'b', 'c', 'a'}
            );
            englishQuestions.displayQuestions();
            loadingAnimation();
            menu();

            Questions mathsQuestions = new Questions();
            mathsQuestions.setQuestionText(
                new String[]{
                    "A universal set is_____\nA.The superset of every under consideration\nB.The subset of every set under consideration\nC.The set of all real numbers\n",
                    "{2(-3)^n-1} Represent the sequence of\nA.-2,6,-18,54.....\nB.-2,6,-18,-54.....\nC.2,-6,18,-54.....\n",
                    "Two coins are tossed simultaneously, then the probability of getting at least one tail is\nA.2/4\nB.1/4\nC.3/4\n",
                    "The value of cos 30 degree is\nA.0.866\nB.0.55\nC.1\n",
                    "A' U B'\nA.A' U B'\nB.(A U B)'\nC.(A n B)'\n"
                },
                new char[]{'a', 'c', 'a', 'a', 'c'}
            );
            mathsQuestions.displayQuestions();
            loadingAnimation();
            menu();

            Questions physicsQuestions = new Questions();
            physicsQuestions.setQuestionText(
                new String[]{
                    "What is the unit of energy?\nA.joule\nB.watt\nC.Newton\n",
                    "Free fall motion is caused by ____Force.\nA.Week\nB.Strong\nC.Gravitational\n",
                    "MKS unit of pressure\nA.Pascal\nB.Atmosphere\nC.Torr\n",
                    "Equation of Newton's second law of motion\nA.a=Fm\nB.F=ma\nC.m=Fa\n",
                    "Resistance of a conductor is directly proportional to\nA.Length\nB.Cross sectional area\nC.Magnetic field\n"
                },
                new char[]{'a', 'c', 'a', 'b', 'a'}
            );
            physicsQuestions.displayQuestions();
            loadingAnimation();
            menu();

            Questions chemistryQuestions = new Questions();
            chemistryQuestions.setQuestionText(
                new String[]{
                    "SI unit of pressure\nA.Pascal\nB.Torr\nC.Joule\n",
                    "Water molecule mass\nA.8\nB.36\nC.18\n",
                    "In Ethane all the bond angles are off\nA.217\nB.180\nC.109.5\n",
                    "Boiling point of HNO3\nA.83 degrees Centigrade\nB.96 degrees centigrade\nC.98 Kelvin\n",
                    "In ordinary hydrogen gas the percentage of protium is\nA.0.156%\nB.99.98%\nC.15.5%\n"
                },
                new char[]{'a', 'c', 'c', 'a', 'b'}
            );
            chemistryQuestions.displayQuestions();
            loadingAnimation();

            System.out.println("\nTotal marks are 20:\nYour test score is " + getTotalScore(englishQuestions, mathsQuestions, physicsQuestions, chemistryQuestions) + ":");
            System.out.println("Your wrong number of answers are: " + getTotalWrong(englishQuestions, mathsQuestions, physicsQuestions, chemistryQuestions));

            try (PrintWriter writer = new PrintWriter(new FileWriter("a.txt", true))) {
                writer.println(name + " " + getTotalScore(englishQuestions, mathsQuestions, physicsQuestions, chemistryQuestions) + " " + getTotalWrong(englishQuestions, mathsQuestions, physicsQuestions, chemistryQuestions));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            try (Scanner fileScanner = new Scanner(new File("a.txt"))) {
                String line;
                while (fileScanner.hasNextLine()) {
                    line = fileScanner.nextLine();
                    String[] parts = line.split(" ");
                    if (parts.length == 3 && name.equals(parts[0])) {
                        System.out.println("You have already attempted the test.");
                        System.out.println("Name: " + parts[0]);
                        System.out.println("Correct: " + parts[1]);
                        System.out.println("Wrong: " + parts[2]);
                        return;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }

            englishQuestions.resetCount();
            mathsQuestions.resetCount();
            physicsQuestions.resetCount();
            chemistryQuestions.resetCount();

            System.out.print("\nEnter password: ");
            String password = scanner.next();
            menu();

            Questions englishQuestions = new Questions();
            englishQuestions.setQuestionText(
                new String[]{
                    "Antonym of hurt is.\nA.healthy\nB.heal\nC.love\n",
                    "Genocide meaning.\nA.Murder of King.\nB.Murder of father.\nC.Murder of Race\n",
                    "You_______not worry about me.\nA.would\nB.need\nC.could\n",
                    "Translate the passage____English.\nA.to\nB.in\nC.into\n",
                    "Who is known as the point of nature?\nA.William Wordsworth\nB.Williams Shakespeare\nC.William Black\n"
                },
                new char[]{'b', 'c', 'b', 'c', 'a'}
            );
            englishQuestions.displayQuestions();
            loadingAnimation();
            menu();

            Questions mathsQuestions = new Questions();
            mathsQuestions.setQuestionText(
                new String[]{
                    "A universal set is_____\nA.The superset of every under consideration\nB.The subset of every set under consideration\nC.The set of all real numbers\n",
                    "{2(-3)^n-1} Represent the sequence of\nA.-2,6,-18,54.....\nB.-2,6,-18,-54.....\nC.2,-6,18,-54.....\n",
                    "Two coins are tossed simultaneously, then the probability of getting at least one tail is\nA.2/4\nB.1/4\nC.3/4\n",
                    "The value of cos 30 degree is\nA.0.866\nB.0.55\nC.1\n",
                    "A' U B'\nA.A' U B'\nB.(A U B)'\nC.(A n B)'\n"
                },
                new char[]{'a', 'c', 'a', 'a', 'c'}
            );
            mathsQuestions.displayQuestions();
            loadingAnimation();
            menu();

            Questions physicsQuestions = new Questions();
            physicsQuestions.setQuestionText(
                new String[]{
                    "What is the unit of energy?\nA.joule\nB.watt\nC.Newton\n",
                    "Free fall motion is caused by ____Force.\nA.Week\nB.Strong\nC.Gravitational\n",
                    "MKS unit of pressure\nA.Pascal\nB.Atmosphere\nC.Torr\n",
                    "Equation of Newton's second law of motion\nA.a=Fm\nB.F=ma\nC.m=Fa\n",
                    "Resistance of a conductor is directly proportional to\nA.Length\nB.Cross sectional area\nC.Magnetic field\n"
                },
                new char[]{'a', 'c', 'a', 'b', 'a'}
            );
            physicsQuestions.displayQuestions();
            loadingAnimation();
            menu();

            Questions chemistryQuestions = new Questions();
            chemistryQuestions.setQuestionText(
                new String[]{
                    "SI unit of pressure\nA.Pascal\nB.Torr\nC.Joule\n",
                    "Water molecule mass\nA.8\nB.36\nC.18\n",
                    "In Ethane all the bond angles are off\nA.217\nB.180\nC.109.5\n",
                    "Boiling point of HNO3\nA.83 degrees Centigrade\nB.96 degrees centigrade\nC.98 Kelvin\n",
                    "In ordinary hydrogen gas the percentage of protium is\nA.0.156%\nB.99.98%\nC.15.5%\n"
                },
                new char[]{'a', 'c', 'c', 'a', 'b'}
            );
            chemistryQuestions.displayQuestions();
            loadingAnimation();

            System.out.println("\nTotal marks are 20:\nYour test score is " + getTotalScore(englishQuestions, mathsQuestions, physicsQuestions, chemistryQuestions) + ":");
            System.out.println("Your wrong number of answers are: " + getTotalWrong(englishQuestions, mathsQuestions, physicsQuestions, chemistryQuestions));

            try (PrintWriter writer = new PrintWriter(new FileWriter("a.txt", true))) {
                writer.println(name + " " + getTotalScore(englishQuestions, mathsQuestions, physicsQuestions, chemistryQuestions) + " " + getTotalWrong(englishQuestions, mathsQuestions, physicsQuestions, chemistryQuestions));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void menu() {
        System.out.println("\t\t\t\tTotal marks are 20\n");
        System.out.println("Sequence of tests:\n");
        System.out.println("1. English test");
        System.out.println("2. Maths test");
        System.out.println("3. Physics test");
        System.out.println("4. Chemistry test");
    }

    static void loadingAnimation() {
        String[] animation = {".", "..", "...", "...."};
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; ++i) {
                System.out.print("Loading " + animation[i]);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        }
    }

    static int getTotalScore(Questions... subjects) {
        int totalScore = 0;
        for (Questions subject : subjects) {
            totalScore += subject.getCount();
        }
        return totalScore;
    }

    static int getTotalWrong(Questions... subjects) {
        int totalWrong = 0;
        for (Questions subject : subjects) {
            totalWrong += subject.getWrong();
        }
        return totalWrong;
    }
}