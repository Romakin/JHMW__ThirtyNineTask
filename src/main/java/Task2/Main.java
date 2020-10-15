package Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long costPerSQMeter = -1;
        List<Deal> dealList = generateDeals(100);

        while(true) {

            System.out.println("Enter cost per square meter (<1000) or /exit or /print ");
            String input = scanner.nextLine();
            if (input.equals("/exit")) {
                break;
            }
            if (input.equals("/print")) {
                System.out.println("Deals: \n----");
                final long bufCost = costPerSQMeter;
                dealList.stream().forEach(d -> {
                    System.out.println(d.toString() + "\n   Is honest: " + isHonest(bufCost, d));
                });
                System.out.println("----");
                continue;
            }
            try {
                costPerSQMeter = Long.parseLong(input);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number! Try another.");
            }
        }
    }

    private static List<Deal> generateDeals(int dealsNum) {
        List<Deal> result = new ArrayList<>();
        while(dealsNum-- > 0) {
            int width = ThreadLocalRandom.current().nextInt(2, 1000 + 1),
                length = ThreadLocalRandom.current().nextInt(2, 1000 + 1);
            long cost = ThreadLocalRandom.current().nextLong(100L, 100000L);
            result.add(new Deal(width, length, cost));
        }
        return result;
    }

    // Clear function
    private static boolean isHonest(long costPerSQMeter, Deal deal) {
        long dealCostPerSQMeter = deal.getCost() / (deal.getLength() * deal.getWidth());
        if (Math.abs(dealCostPerSQMeter - costPerSQMeter) < Math.pow((Math.log10(costPerSQMeter) + 1), 10))
            return true;
        return false;
    }
}
