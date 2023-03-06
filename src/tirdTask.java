import java.util.Scanner;

public class tirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCities = Integer.parseInt(scanner.nextLine());
        double total = 0;
        for (int i = 1; i <= numberOfCities; i++) {
            String nameOfCities = scanner.nextLine();
            double income = Double.parseDouble(scanner.nextLine());
            double expenses = Double.parseDouble(scanner.nextLine());
            if (i % 3 == 0) {
                if (i % 5 != 0) {
                    expenses += 0.5*expenses;
                }
            }
            if (i % 5 == 0){
                income *= 0.9;
            }
            double profit = income - expenses;
            total += profit;
            System.out.printf("In %s Burger Bus earned %.2f leva.%n",nameOfCities,profit);
        }
        System.out.printf("Burger Bus total profit: %.2f leva.",total);

    }
}
