public class BinarySearchTreeDemo
{
    public static void main(String[] args)
    {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(44);
        bst.insert(17);
        bst.insert(88);
        bst.insert(8);
        bst.insert(32);
        bst.insert(66);

        // Example here of using an instance field that was not set to private.
        bst.depthFirstPrint(bst.root);

        //bst.find(88);
        //bst.find(420);
        //bst.getMin();
        //bst.getMax();
    }

}
