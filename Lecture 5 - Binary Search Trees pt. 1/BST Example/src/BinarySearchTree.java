public class BinarySearchTree
{
    // need to keep track of the root node!
    Node root;

    public BinarySearchTree()
    {
        root = null;
    }

    
    public void insert (int newValue)
    {
        // a check to make sure that you're not working with an empty tree
        if(root == null)
        {
            // send in a node with the given value if now
            root = new Node(newValue);
        }
        else // if tree is not empty
        {
            // the thing we iterate on
            Node currentNode = root;
            // the thing we use to check if the inset thing has been place
            boolean placed = false;

            while (!placed)
            {
                // if you're trying to insert a value already equal to a value the tree ()
                if (newValue == currentNode.getValue())
                {
                    placed = true;
                    System.out.println("Cannot have a duplicate value in the BST, per class example restrictions");
                }
                // left path
                // comparing the thing we're trying to insert vs the node we are at in the tree
                else if (newValue < currentNode.getValue())
                {
                    // if a path/space does not exist on the left
                    if (currentNode.getLeft() == null)
                    {
                        // inserts the child node in the "empty space"
                        currentNode.setLeft(new Node(newValue));
                        currentNode.getLeft().setParent(currentNode);
                        placed = true;
                    }
                    else // if a path/space DOES exist on the left
                    {
                        // continues to follow the left path
                        currentNode = currentNode.getLeft();
                    }
                }
                // right path
                else
                {
                    // if a path/space does not exist on the right
                    if (currentNode.getRight() == null)
                    {
                        // inserts the child node in the "empty space"
                        currentNode.setRight(new Node (newValue));
                        currentNode.getLeft().setParent(currentNode);
                        placed = true;
                    }
                    else // if a path/space DOES exist on the right
                    {
                        // continues to follow the right path
                        currentNode = currentNode.getRight();
                    }
                }
            }
        }
    }
}
