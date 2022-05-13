import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        StudentManage sm = new StudentManage();
        Scanner sc = new Scanner(System.in);
        int x;

        while (true) {
            System.out.println("\n-----------Menu------------");
            System.out.println("Choose the function you want:");
            System.out.println("1. Add student");
            System.out.println("2. Save students to list");
            System.out.println("3. Show student list");
            System.out.println("0. Exit");
            System.out.println("---------------------------");
            do {
                System.out.print("Please choose: ");
                x = sc.nextInt();
            } while (x < 0 || x > 3); {
                switch (x) {
                    case 1: {
                        try {
                            sm.addStudent();
                            System.out.println("\nYou have successfully added students");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    }
                    case 2: {
                        try {
                            sm.saveStudents();
                            System.out.println("\nYou have successfully saved the student to the file");
                        } catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    }
                    case 3: {
                        try {
                            sm.showStudent();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    }
                    case 0: {
                        System.out.println("Progress stopped");
                        return;
                    }

                }
            }
        }

    }
}
