public class Student
{
    // Instance fields
    private String name;
    private int student_id;
    private double gpa;

    // Methods
    public Student(String in_name, int in_id, double in_gpa )
    {
        // This sets (or builds) the attributes of the object defined
        this.name = in_name;
        this.student_id = in_id;
        this.gpa = in_gpa;
    }

    // A getter method;
    public String getName()
    {
        return  this.name;
    }

    public int getId()
    {
        return this.student_id;
    }

    public double getGpa()
    {
        return this.gpa;
    }
}
