import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManage {
    private ArrayList<Students> studentsList = new ArrayList<Students>();
    Scanner sc = new Scanner(System.in);

    //getter & setter



    //input
    public String inputID() {
        System.out.print("Input student ID: ");
        String ID = sc.next();
        return ID;
    }
    public String inputFirstName() {
        System.out.print("Input student first name: ");
        String firstname = sc.next();
        return firstname;
    }
    public String inputLastName() {
        System.out.print("Input student last name: ");
        String lastname = sc.next();
        return lastname;
    }
    public int inputAge() {
        System.out.print("Input student age: ");
        while (true) {
            try {
                int age = sc.nextInt();
                if (age < 0 && age > 150) {  //ít hơn 150 tuổi cho đỡ tài nguyên :v
                    throw new NumberFormatException("age is greater than 0 and must be less than 200");
                }
                return age;
            } catch (NumberFormatException ex) {
                System.out.print("Invalid! Input student ID again: ");
            }
        }
    }

    //phương thức
    public void addStudent(){
        String ID = inputID();
        String firstname = inputFirstName();
        String lastname = inputLastName();
        int age = inputAge();

        Students student = new Students(ID, firstname, lastname, age);
        studentsList.add(student);
    }

    //save students
    public void saveStudents() throws FileNotFoundException, IOException {
        File f = new File("students.dat");
        FileOutputStream fout = new FileOutputStream(f);
        ObjectOutputStream ojbout = new ObjectOutputStream(fout);

        ojbout.writeObject(studentsList);

        ojbout.close();
        fout.close();
    }
    //read files -> show student
    public void readFiles() throws IOException, ClassNotFoundException {
        File f = new File("students.dat");
        FileInputStream fin = new FileInputStream(f);
        ObjectInputStream objin = new ObjectInputStream(fin);

        studentsList = new ArrayList<Students>();
        studentsList = (ArrayList)objin.readObject();
        showStudent();

        objin.close();
        fin.close();
    }

    public void showStudent() {
        if (studentsList.size()==0){
            System.out.println("List is empty");
        }
        else{
            System.out.println("|   EnrolID   |      Full name      |  Age  |");
            System.out.print("\n========================================\n\n");
            for (Students st : studentsList) {
                System.out.format("| %12s | %20s | %6d |\n",st.getEnrolID(),st.getFirstName() + " " + st.getLastName(),st.getAge());
            }
        }
    }
}
