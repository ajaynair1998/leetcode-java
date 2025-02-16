import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 1 };

        Boolean result = containsDuplicateWithHashmap(nums);
        System.out.println(result);
    }

    public static boolean containsDuplicateWithSets(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        return false;
    }

    public static boolean containsDuplicateWithIterator(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            Integer current = it.next();

            if (set.contains(current)) {
                return true;
            }
            set.add(current);

        }

        return false;

    }

    public static Boolean containsDuplicateWithHashmap(int[] nums) {

        // List (Interface)
        // Definition: List is an interface in Java that represents an ordered
        // collection (or sequence) of elements. It is part of the java.util package.
        // Key Characteristics:
        // Can contain duplicate elements.
        // Provides methods like add(), remove(), get(), size(), etc.
        // It's not directly instantiable (you cannot do new List()).
        // Implementation: ArrayList, LinkedList, Vector, and Stack are all
        // implementations of the List interface.
        // Flexibility: Using List as a reference type allows you to switch between
        // different implementations (e.g., ArrayList or LinkedList) without changing
        // your code.

        // Internally, boxed() converts each primitive element to its corresponding
        // wrapper class using autoboxing. For example:

        // int → Integer
        // long → Long
        // double → Double

        List<Integer> arrayListOfNumbers = Arrays.stream(nums).boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        Iterator<Integer> iterator = arrayListOfNumbers.iterator();

        while (iterator.hasNext()) {
            Integer valueAtIterator = iterator.next();

            if (hashMap.get(valueAtIterator) != null) {
                return true;
            }

            hashMap.put(valueAtIterator, 1);
        }
        return false;
    }

}