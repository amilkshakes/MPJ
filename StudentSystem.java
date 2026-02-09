// This is the "Blueprint" or Class
class Student {
    String name;
    int rollNumber;
    double grade;

    // 1. Constructor: Initializes the object when 'new' is called
    public Student(String studentName, int studentRoll, double studentGrade) {
        name = studentName;
        rollNumber = studentRoll;
        grade = studentGrade;
    }

    // 2. Method: A behavior to display student details
    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade + "%");
        System.out.println("---------------------------");
    }
}

// The Main class where the program starts
public class StudentSystem {
    public static void main(String[] args) {
        
        // 3. Object Creation: Creating instances of the Student class
        Student student1 = new Student("Alice", 101, 92.5);
        Student student2 = new Student("Bob", 102, 88.0);

        // 4. Calling Methods on those objects
        System.out.println("--- Student Records ---");
        student1.displayInfo();
        student2.displayInfo();
    }
}