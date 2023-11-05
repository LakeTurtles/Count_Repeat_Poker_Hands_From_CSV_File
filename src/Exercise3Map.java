import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Exercise3Map {

        public static void main(String[] args) throws Exception {


            Map<String, Map<String, Integer>> playerCardCounts = new HashMap<>();

            Set<String> pokerHands = new HashSet<>();

            String fileName = "./src/PokerHands/PokerHands.csv";

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
                String input = bufferedReader.readLine();

                while((input = bufferedReader.readLine()) != null){
                    String[] info = input.split(",");

                    String playerName = info[0];
                    String PokerHand = info[1];

                    pokerHands.add(PokerHand);


                    

                    // Get the player's card counts map from the main map
                    Map<String, Integer> cardCounts = playerCardCounts.computeIfAbsent(playerName, k -> new HashMap<>());


                    // Update the card count for the specific winning hand
                    cardCounts.put(PokerHand, cardCounts.getOrDefault(PokerHand, 0) + 1);
                }





                System.out.println("\u001B[35m//////////////////////////////////////////////////////");

                for (String playerName : playerCardCounts.keySet()) {
                    System.out.println(playerName + " - " + playerCardCounts.get(playerName));
                }


                System.out.println("\u001B[34m//////////////////////////////////////////////////////");


                printToConsole(pokerHands);


                System.out.println("\u001B[36m//////////////////////////////////////////////////////");

                System.out.println(pokerHands);

            }



        }


        public static void printToConsole(Set<String> set) {
            for(String player: set ){
                System.out.println(player);
            }
            System.out.println("------------------------------------------------------------------");
        }


}
