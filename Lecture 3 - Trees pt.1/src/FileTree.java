import java.util.ArrayList;

public class FileTree
{
    private Node root; // tracks the root node
    private Node current; // the node that we use to traverse the file tree; it'll tell you what "dir" you're currently in

    public FileTree()
    {
        // Instantiates the starting roots
        this.root = new Node("~"); // this will represent the parent node
        //this.current = new Node("~"); These are NOT pointing to the same thing.

        // This is the way you want to set it up; have the two nodes pointing to THE SAME THING
        this.current = root;
    }

    // Inserts something into the tree; the bool is to denote success of adding something into the tree
    public boolean insert(String directory)
    {
        // Logic to check if the insertion is valid; in this case, if it's empty or a space or if it's the name of the home dir
        if (directory == null || directory.equals(" ") || directory.equals("~"))
        {
            return false;
        }
        else // a valid insertion
        {
            // Create the node
            Node newNode = new Node(directory);
            newNode.setParent(current); // sets the new node's parent; current will represent the new node that we created
            current.addChild(newNode);
            return true;
        }
    }

    public boolean moveDown(String directory)
    {
        ArrayList<Node> children = current.getChildren();

        // for each child in our children array list, look for a match
        for(Node child : children)
        {
            if(child.getName().equals(directory))
            {
                // move down in the tree
                current = child;
                return true;
            }
        }
        return false; // if the loop finishes and nothing comes back; add an error message here!
    }

    // This could be a boolean, if you wanted
    public void moveUp()
    {
        // you don't need to provide the name fo the dir because there is always exactly 1 parent, ALWAYS
        // Check to see if you're in the edge case of moving up from the root directory
        if(current != root)
        {
            current = current.getParent();
        }
    }

    // return to the home directory
    public void goHome()
    {
        current = root;
    }

    // returns the current working directory; NOT the file path
    public String getCurrentLocation()
    {
        return current.getName();
    }

    // You can also return the ArrayList, for easier printing
    public String getChildrenDirectories()
    {
        // create an empty string, and then iterate through the arrayList, appending each element to a string that is returned.
        String files = "";
        ArrayList<Node> children = current.getChildren();
                for(Node c: children)
                {
                    files  += c.getName() + " ";
                }
                return files;
    }
}






// test
