public class Node
{
    private int value;
    private Node left;
    private Node right;
    private Node parent;

    public Node (int newValue)
    {
        this.value = newValue;
    }

    // --- Getter Methods (these return something!) ---
    public int getValue()
    {
        return this.value;
    }

    public Node getLeft()
    {
        return this.left;
    }

    public Node getRight()
    {
        return this.right;
    }

    public Node getParent()
    {
        return this.parent;
    }

    // --- Setter Methods (these update something!) ---

    public void setParent(Node newParent)
    {
        this.parent = newParent;
    }

    public void setLeft(Node newNode)
    {
        this.left = newNode;
    }

    public void setRight(Node newNode)
    {
        this.right = newNode;
    }

    public void setValue(int newValue)
    {
        this.value = newValue;
    }
}
