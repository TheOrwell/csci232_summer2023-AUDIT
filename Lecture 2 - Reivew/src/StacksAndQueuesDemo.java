import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class StacksAndQueuesDemo
{
    public static void main(String[] args)
    {
        // Stack Documentation: https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
        // Queue Documentation: https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
        Stack<String> stack = new Stack<String>();

        stack.push("A thing");
        stack.push("A thing that will be popped");

        // shows the thing that was popped
        System.out.println(stack.pop());

        // shows the stack
        System.out.println(stack.peek());

        // Queues are NOT classes, they are interfaces!
        Queue<String> queue = new LinkedList<String>();

        queue.add("Susan");
        queue.add("Isaac");
        queue.add("John");

        System.out.println("Removed " + queue.remove() + " from queue.");
    }
}
