public class StudentDatabaseDemo
{
    public static void main(String[] args)
    {
        // this creates some objects; the new keyword creates a new instance of the denoted class
        Student student1 = new Student("Joe", 12345, 3.5);

        System.out.println(student1.getName());
        System.out.println(student1.getGpa());
        System.out.println(student1.getId());

        Student student2 = new Student("Sally", 67890, 2.1);

        System.out.println(student2.getName());
        System.out.println(student2.getGpa());
        System.out.println(student2.getId());
    }
}








// An object is a container that holds information
