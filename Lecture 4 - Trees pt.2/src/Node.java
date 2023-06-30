import java.util.ArrayList;
public class Node {
    private String name; // dir name
    private Node parent;
    private ArrayList<Node> children;

    public Node(String name)
    {
        this.name = name;
        children = new ArrayList<Node>(); // This is not required due to inferrence
    }

    public String getName()
    {
        return this.name;
    }

    public ArrayList<Node> getChildren()
    {
        return this.children;
    }

    public Node getParent()
    {
        return this.parent;
    }

    // this gets called on a node obnject; it will atd  a child to that node's array list
    public void addChild(Node newChild)
    {
        this.children.add(newChild);
    }

    public void setParent (Node newParent)
    {
        this.parent = newParent;
    }
}