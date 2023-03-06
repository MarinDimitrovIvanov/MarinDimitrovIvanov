import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class chatLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> chatMessages = new ArrayList<>();
        String input = scanner.nextLine();
        while (!"end".equals(input)){
            String command = input.split("\\s+")[0];
            String massage = input.split("\\s+")[1];
            switch (command){
                case "Chat":
                     chatMessages.add(massage);
                    break;
                case "Delete":
                    if (chatMessages.contains(massage)){
                        int index = chatMessages.indexOf(massage);
                        chatMessages.remove(index);
                    }
                    break;
                case "Edit":
                    String newMessage = input.split("\\s+")[2];
                    if (chatMessages.contains(massage)){
                        int index = chatMessages.indexOf(massage);
                        chatMessages.set(index,newMessage);
                    }
                    break;
                case "Pin":
                    if (chatMessages.contains(massage)){
                    int index = chatMessages.indexOf(massage);
                    String current = chatMessages.get(index);
                    chatMessages.remove(index);
                    chatMessages.add(current);
                    }
                    break;
                case "Spam":
                    List<String> messagesList = Arrays.stream(input.split("\\s+"))
                            .collect(Collectors.toList());
                    for (int i = 1; i <= messagesList.size()-1 ; i++) {
                        String current = messagesList.get(i);
                        chatMessages.add(current);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (String message:chatMessages) {
            System.out.println(message);
        }
    }
}
