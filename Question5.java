import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question5
{
  public static void main(String[] args)
  {
    /**
     * Prompt the user for number. This input indicates the number of integers the user will be entering next. 
     * Print out the mode (highest occurrence) from the set of integers. 
     *    e.g.
     *     > 5
     *     > 2
     *     > 4
     *     > 1
     *     > 3
     *     > 4
     *     4
     * 
     *    e.g.
     *     > 4
     *     > 2
     *     > 2
     *     > 3
     *     > 3
     *     2
     * Hint: Use a loop to get input. Use another 2 loops to find the mode
     */

    Scanner in = new Scanner(System.in);

    System.out.print("Enter the count of integers: ");
    int count = in.nextInt();

    int[] numbers = new int[count];
    System.out.println("Enter the integers:");
    for (int i = 0; i < count; i++) {
      numbers[i] = in.nextInt();
    }

    int mode = calculateMode(numbers);
    System.out.println("Mode: " + mode);

    in.close();
  }

  public static int calculateMode(int[] numbers) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();

    for (int number : numbers) {
      ((HashMap<?, ?>) frequencyMap).put(number, ((HashMap<?, ?>) frequencyMap).getOrDefault(number, 0) + 1);
    }

    int mode = 0;
    int maxFrequency = 0;

    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
      int number = entry.getKey();
      int frequency = entry.getValue();

      if (frequency > maxFrequency) {
        mode = number;
        maxFrequency = frequency;
      }
    }

    return mode;
  }
}
