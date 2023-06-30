import java.util.Scanner;

public class FileTreeManager
{
    // Instance field
    private FileTree tree;
    // Constructor
    public FileTreeManager()
    {
        // calling aconstructor inside of a constuctor
        this.tree = new FileTree();

    }

    public void run()
    {
        String command = " ";
        Scanner scanner = new Scanner(System.in);

        while (!command.equals("exit"))
        {
            System.out.println(tree.getCurrentLocation() + "$: ");
            command = scanner.nextLine();
            executeCommand(command);

        }

    }

    // Copy pasted method that checks and executes the commands given by the user, and calls the correct commands accordingly
    private void executeCommand(String command) {
        int breakPoint = command.indexOf(" ");
        String argument = null;
        if (breakPoint != -1) {
            argument = command.substring(breakPoint + 1, command.length());
            command = command.substring(0, breakPoint);
        }

        if (command.equals("cd")) {
            if (!move(argument)) {
                System.out.println("cd: no such file or directory: " + argument + "\n");
            }
        } else if (command.equals("ls")) {
            System.out.println(tree.getChildrenDirectories());
        } else if (command.equals("mkdir")) {
            if (!tree.insert(argument)) {
                System.out.println("Invalid file name.\n");
            }
        } else if (command.equals("rm")) {
            if (!tree.remove(argument)) {
                System.out.println("File not found.\n");
            }
        } else if (command.equals("exit")) {

        } else if (command.equals("pwd")) {
            System.out.println(tree.getPath());
        } else {
            System.out.println("'" + command + "' is not a recognized command");
        }
    }


    // Inserts dummy data to mimic a created file tree
    public void test() {
        tree.insert("School");
        tree.moveDown("School");
        tree.insert("CSCI338");
        tree.insert("CSCI232");
        tree.moveDown("CSCI232");
        tree.insert("Labs");
        tree.goHome();

        tree.insert("Skiing");
        tree.moveDown("Skiing");
        tree.insert("Pictures");
        tree.insert("Trips");
        tree.insert("Gear");
        tree.moveDown("Trips");
        tree.insert("Summer");
        tree.moveDown("Summer");
        tree.insert("Tetons");
        tree.insert("AK");
        tree.moveUp();
        tree.insert("Winter");
        tree.goHome();

        tree.insert("Work");
        tree.moveDown("Work");
        tree.insert("Reviews");
        tree.insert("Paystubs");
        tree.moveDown("Paystubs");
        tree.insert("2014");
        tree.insert("2015");
        tree.goHome();

        tree.insert("Personal");
        tree.moveDown("Personal");
        tree.insert("Resume");
        tree.insert("Taxes");
        tree.goHome();

        System.out.println("Breadth First");
        tree.breadthFirst();

        // TODO: Implement a search method for the commented section out below
        //tree.searchForDirectory("Tetons");

        //System.out.println("Depth First");
        //tree.depthFirst();
        
        run();
    }

    private boolean move(String file) {
        if (file == null || file.equals("") || file.equals("~")) {
            tree.goHome();
            return true;
        }

        if (file.equals("..")) {
            tree.moveUp();
            return true;
        }

        return tree.moveDown(file);
    }

}
