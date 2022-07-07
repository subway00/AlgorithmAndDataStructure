package algorithmAndDataStructure.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayListApp {
    public static void main(String[] args) {

        //ArrayList use standard arrays under the hood
        //Default capacity : 10
        List<String> names = new ArrayList<>();

        names.add("Kevin");
        names.add("Daniel");
        names.add("Adam");
        names.add("Ana");

        System.out.println(names.size());   //print : 4


    }
}

