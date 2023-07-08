import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    // TODO CHALLENGE: move down the tree via an entire list, using the .split method
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
        // you don't need to provide the name for the dir because there is always exactly 1 parent, ALWAYS
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
            files += c.getName() + " ";
        }
        return files;
    }

    public boolean remove (String directory)
    {
        // TODO CHALLENGE: Remove dir from child
        return false;
    }

    // AUTHOR: Isaac Yauk, 07/07/2023
    // SOURCE: Nodes included in class and ChatGPT for string slicing examples.
    /**
     * Gets the path taken from the starting (or "root") directory by returning to the root, and
     *      navigating back down to the directory in which the recording the path taken back down
     *      command was run.
     * @return the string of the path taken from the "root" node
     */
    public String getPath()
    {
        String dirUpPath = "";
        String startDir = this.getCurrentLocation();
        String pathFromHome = "";

        dirUpPath += this.getCurrentLocation();

        // Moves up to the root node, recording the path taken
        while (!dirUpPath.contains(root.getName()))
        {
            moveUp();
            dirUpPath = dirUpPath + "/" + this.getCurrentLocation();
        }

        // moves back down to original location, slicing off the recorded paths as the 'moveDown' parameter
        while (this.getCurrentLocation() != startDir)
        {
            if (dirUpPath.contains("/"))
            {
                // Gets the index of the last '/' and then uses it to peel off the location taken, from within the string
                int lastIndex = dirUpPath.lastIndexOf("/");
                String moveLoc = dirUpPath.substring(lastIndex + 1);

                // Moves down and constructs the return string on the way back
                moveDown(moveLoc);
                pathFromHome = pathFromHome + "/" + moveLoc;
                dirUpPath = dirUpPath.substring(0, dirUpPath.lastIndexOf("/"));
            }
            else
            {
                // The case in which there are no more '/' chars in the path taken
                moveDown(dirUpPath);
            }
        }

        // The final return path (including the current directory), properly formatted.
        return pathFromHome + "/" + getCurrentLocation();
    }

    public void breadthFirst()
    {
        // use a que to keep track of all the children correctly
        Queue<Node> queue = new LinkedList<Node>();

        // if the tree is empty
        if (root != null)
        {
            queue.add(root);

            // .isEmpty returns true if the queue is empty; so: "while the queue is not empty, keep doing this action"
            while (!queue.isEmpty())
            {
                // node is the node we are visiting
                Node node = queue.remove();
                System.out.println(node.getName());

                // Iteratively adds the children nodes to the queue
                for (Node n : node.getChildren())
                {
                    queue.add(n);
                }
            }
        }
    }

    public void depthFirst()
    {
        Stack<Node> stack = new Stack<Node>();

        // If the root is not null, add it to the stack
        if (root != null)
        {
            stack.add(current);

            // keeps looping as lng as the stack has stuff inside it
            while (!stack.isEmpty())
            {
                Node removedNode = stack.pop();
                System.out.println(removedNode.getName());

                // this gives you an array list that you can iterate through
                for (Node child : removedNode.getChildren())
                {
                    // add the child to the stack
                    stack.add(child);

                }
            }
        }


    }
}