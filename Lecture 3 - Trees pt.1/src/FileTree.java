import java.util.ArrayList;

public class FileTree
{
    private Node root; // tracks the root node
    private Node current; // the node that we use to traverse the file tree; it'll tell you what "dir" you're currentl;y in

    public FileTree()
    {
        // Instanciates the starting roots
        this.root = new Node("~"); // this will reperenset the parent node
        //this.current = new Node("~"); These are NOT pointing to the same thing.

        // This is the way you want to set it up; have the two nodes pointing to THE SAME THING
        this.current = root;
    }

    // Inserts soemthing into the tree; the bool is to denote sucess of adding someithng into the tree
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
            newNode.setParent(current); // sets the new node's parent; current will reperesent the new node that we created
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

    // TODO: continue to fill out notes from lecture 3! (MoveUp method @ 1:16:18)
}
