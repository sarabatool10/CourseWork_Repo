import java.util.HashMap;
import java.util.ArrayList;

public class FindRepeatedFive {
    public static void main(String[] args) {
        int[] B = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6, 7};

        ArrayList<Integer> repeated = findRepeatedFive(B);
        System.out.println("The repeated integers are: " + repeated);
    }

    public static ArrayList<Integer> findRepeatedFive(int[] array) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        ArrayList<Integer> repeatedNumbers = new ArrayList<>();

        for (int num : array) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int num : countMap.keySet()) {
            if (countMap.get(num) > 1) {
                repeatedNumbers.add(num);
                if (repeatedNumbers.size() == 5) {
                    break;
                }
            }
        }

        return repeatedNumbers;
    }
}
