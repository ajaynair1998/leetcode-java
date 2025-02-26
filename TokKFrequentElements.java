import java.util.*;

public class TokKFrequentElements {
  public int[] topKFrequent(int[] nums, int k) {

    Map<Integer, Integer> hashMapOfFrequency = new HashMap<>();

    for (int number : nums) {
      int currentValue = hashMapOfFrequency.getOrDefault(number, 0);
      hashMapOfFrequency.put(number, currentValue + 1);
    }

    Queue<Integer> heap = new PriorityQueue<>(
        (n1, n2) -> hashMapOfFrequency.get(n1) - hashMapOfFrequency.get(n2));

    for (int n : hashMapOfFrequency.keySet()) {
      heap.add(n);
      if (heap.size() > k)
        heap.poll();
    }

    int[] topMostFrequentElements = new int[k];

    for (int i = 0; i < k; i++) {
      topMostFrequentElements[i] = heap.poll();
    }

    return topMostFrequentElements;

  }

}
