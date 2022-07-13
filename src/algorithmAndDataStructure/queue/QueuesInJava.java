package algorithmAndDataStructure.queue;


import java.util.LinkedList;
import java.util.Queue;

public class QueuesInJava {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();

        // Add method inserts a new item into the queue in O(1)
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // Return the first element without remove it
        System.out.println(queue.element());

        // Remove method is a dequeue() method in O(1)
        while (! queue.isEmpty())
            System.out.println(queue.remove());
    }
}
