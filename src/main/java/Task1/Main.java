package Task1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println("Say something");
            System.out.println("Or /print or /exit");

            String input = scanner.nextLine();

            if (input.equals("/exit")){
                break;
            }
            if (input.equals("/print")) {
                System.out.println("Dictionary: \n----");
                dictionary.stream().sorted().forEach(System.out::println);
                System.out.println("----");
                continue;
            }

            Function<String, Set<String>> dictFunc = s -> Arrays.stream(s.trim().split("\\s"))
                    .collect(Collectors.toSet());

            dictionary.addAll(dictFunc.apply(input));
        }
    }

}
