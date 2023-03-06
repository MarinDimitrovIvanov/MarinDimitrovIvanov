import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class secondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> friends = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        String blacklisted = "";
        int countBlacklisted = 0;
        int countLostName = 0;
        String input = scanner.nextLine();
        while (!"Report".equals(input)){
            String command = input.split(" ")[0];
            switch (command){
                case "Blacklist":
                    String name = input.split(" ")[1];
                    if (friends.contains(name)){
                        int index = friends.indexOf(name);
                        friends.set(index,"Blacklisted");
                        blacklisted +=name;
                        countBlacklisted++;
                        System.out.printf("%s was blacklisted.%n",name);
                    }else {
                        System.out.printf("%s was not found.%n",name);
                    }
                    break;
                case "Error":
                    int index = Integer.parseInt(input.split(" ")[1]);
                    if (isValid(index, friends) && !(friends.get(index).equals("Blacklisted"))
                    && !(friends.get(index).equals("Lost"))){
                        System.out.printf("%s was lost due to an error.%n",friends.get(index));
                        friends.set(index, "Lost");
                        countLostName++;
                    }
                    break;
                case "Change":
                    int indexToChange = Integer.parseInt(input.split(" ")[1]);
                    String newName = input.split(" ")[2];
                if(isValid(indexToChange, friends)){
                    System.out.printf("%s changed his username to %s.%n",friends.get(indexToChange), newName);
                    friends.set(indexToChange,newName);
                }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Blacklisted names: %d%n",countBlacklisted);
        System.out.printf("Lost names: %d%n",countLostName);
        for (String name:friends) {
            System.out.print(name+ " ");

        }



    }
   public static boolean isValid(int index, List<String> friends){
        if (index >=0 && index <= friends.size()-1){
            return true;
        }
        return false;
   }
}
