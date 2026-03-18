import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataCollections {

  public static Map<Integer, Double> frequencyCount(List<Integer> numbers) {
    if (numbers == null) {
      throw new IllegalArgumentException("Input list cannot be null.");
    }

    Map<Integer, Double> result = new HashMap<>();

    if (numbers.isEmpty()) {
      return result;
    }

    Map<Integer, Integer> counts = new HashMap<>();

    for (Integer num : numbers) {
      counts.put(num, counts.getOrDefault(num, 0) + 1);
    }

    int total = numbers.size();

    for (Integer key : counts.keySet()) {
      result.put(key, counts.get(key) / (double) total);
    }

    return result;
  }
}