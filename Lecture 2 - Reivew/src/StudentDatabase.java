
// The class the represents a database and works with databases to holds student "objects"
public class StudentDatabase
{
    private Student[] studentDatabase;
    private int count;

    /*
    It's possible to carve out space in an array, like so:

    studentDatabase = new Student[10];
    */

    public StudentDatabase()
    {
        this.studentDatabase = new Student[0];
        this.count = 0;
    }

    // this takes in and connects to your demo class
    public void addStudent(String studentName, int studentID, double studentGPA)
    {
        Student s = new Student(studentName, studentID, studentGPA);

        // a temporary database that will dynamically resize, allowing the swapping out and resizing of the old array
        Student[] tempDatabase = new Student[this.studentDatabase.length + 1];
        for (int i = 0; i < studentDatabase.length; i++)
        {
            // swaps out the databases
            tempDatabase[i] = studentDatabase[i];
        }
        // inserts the new thing into the very last spot of the array
        tempDatabase[studentDatabase.length] = s;

        // updates the reference var so that it now point to an array that fits more
        studentDatabase = tempDatabase;

    }

    public void printDatabase()
    {
        // This prints out the MEMORY LOCATION, not the string value
        //      System.out.println(this.studentDatabase);

        for(Student s: this.studentDatabase)
        {
            System.out.println(s.getName() + " " + s.getId() + " " + s.getGpa());
        }
    }

    public double findHighestGPA()
    {
        // this var needs to not affect the answer if you switch it to a lowest_so_far method
        double highest_so_far = 0;
        for (Student s: this.studentDatabase)
        {
            if(s.getGpa() > highest_so_far)
            {
                // updates the highest
                highest_so_far = s.getGpa();
            }
        }
        return highest_so_far;
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
