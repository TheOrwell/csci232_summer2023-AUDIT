public class StudentDatabaseDemo
{
    public static void main(String[] args)
    {
        // creates a new instance of your 'database'
        StudentDatabase database = new StudentDatabase();
        System.out.println("Array Database: ");
        database.addStudent("Joe", 12345, 3.5);
        database.addStudent("Sally", 56789, 2.1);
        database.addStudent("Ron", 98765, 5.1);
        database.addStudent("Billy", 22222, 8.1);
        database.printDatabase();

        double answer = database.findHighestGPA();
        System.out.println("Highest GPA is: " + answer);

        StudentDatabaseLinkedList databaseLL = new StudentDatabaseLinkedList();
        System.out.println("\nLinked List Database: ");
        databaseLL.addStudent("Joe", 12345, 3.5);
        databaseLL.addStudent("Sally", 56789, 2.1);
        databaseLL.addStudent("Ron", 98765, 5.1);
        databaseLL.addStudent("Billy", 22222, 8.1);

        databaseLL.printDatabase();

        // See the Challenge TODOs in each of the 4 methods below.
        database.getStudentByName("Joe");
        databaseLL.getStudentByName("Joe");

        database.removeStudent("Joe");
        databaseLL.removeStudent("Joe");
    }
}








// An object is a container that holds information