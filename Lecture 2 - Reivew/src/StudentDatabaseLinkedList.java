import java.util.LinkedList;

public class StudentDatabaseLinkedList
{
    // you MUST specify what type of data a LL holds!
    private LinkedList<Student> studentDatabase;
    private int count;

    public StudentDatabaseLinkedList()
    {
        studentDatabase = new LinkedList<Student>();
        this.count = 0;
    }

    public void addStudent(String studentName, int studentID, double studentGPA)
    {
        // Refer to documentation as needed! See: https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html
        Student s = new Student(studentName, studentID, studentGPA);
        this.studentDatabase.add(s);
    }

    public void printDatabase()
    {
        for(Student s: this.studentDatabase)
        {
            System.out.println(s.getName() + " " + s.getId() + " " + s.getGpa());
        }
    }

    public void getStudentByName(String searchName)
    {
        // TODO CHALLENGE: use a for-loop that searches for the denoted string, passed in via the parameter
    }

    public void removeStudent(String searchName)
    {
        // TODO CHALLENGE: use a for-loop that searches for the denoted string, passed in via the parameter AND REMOVE IT!
    }
}