package algorithmAndDataStructure.array;

public class App {
    public static void main(String[] args) {
        //Arrays are not dynamic data structure, so we have to define the size in advance.
        int[] nums = new int[10];

        for(int i=0 ; i<10 ; ++i)
            nums[i] = i;

        //If we do not know the index of the item
        //Linear search O(N)
        //We have to find the index of item 6
        for(int i=0 ; i<10 ; ++i)
            if(i == 6)
                System.out.println("We have found the item at the index: " + i);
    }
}
