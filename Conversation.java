import java.util.Scanner;
import java.util.Random;
/**
 * Very simple ChatBot that carries out a conversation with a resquested number of rounds
 * @author Robbie
 */
class Conversation {

  String sentence;

  public Conversation(String sentence) {
    this.sentence = sentence;
  }

  /**
   * Randomly pick a string from a list of strings
   * @return
   */
  private String cannedResponse() {
    String[] list = {"Uh-huh.",
    "Oh wow!",
    "Interesting!",
    "Go on.",
    "Oh really?",
    "Okay."};
    int x;
    Random rnd = new Random();
    x = rnd.nextInt(6); 
    this.sentence = list[x];
    return this.sentence;
  };
  
  /**
   * Mirror words from orginal phrase and replace them with desired words
   * @param input user input
   * @return new string
   */  
  private String mirrorWords(String input) {
    input = input.toLowerCase();
    String[] wordsToReplace = {"i ", "me ", "am ", "you ", "my ", "your ", "i'm "};
    String[] replacementWords = {"you ", "you ", "are ", "me ", "your ", "my ", "you're "};
    for (int i = 0; i < wordsToReplace.length; i++) {
        String currentWord = wordsToReplace[i];
        if (input.contains(currentWord)) {
            input = input.replaceAll(currentWord, replacementWords[i]);
        }
    }
    input = input.substring(0, 1).toUpperCase() + input.substring(1);
    return input;
  }

  
  /**
   * Carries out the conversation and records it into a transcript. Prints the transcript at the end of the conversation.
   * @param arguments
   */
  public static void main(String[] arguments) {
    // You will start the conversation here.

    Conversation chatBot = new Conversation("How many rounds? (Enter an integer)");
    System.out.println(chatBot.sentence);

    StringBuilder transcript = new StringBuilder();
    transcript.append("****** Here's a transcript for the conversation ******\n");
    
    Scanner scanner = new Scanner(System.in);
    int rounds;
    rounds = scanner.nextInt();

    System.out.println("Hello! What's on your mind?");
    transcript.append("Hello! What's on your mind?\n");

    String user_input;
    String response;
    scanner.nextLine();

    for (int i = 0; i < rounds; i++) { 
      user_input = scanner.nextLine();
      transcript.append(user_input + "\n");
      
      if (user_input.equals(chatBot.mirrorWords(user_input))) {
        System.out.println(response = chatBot.cannedResponse());
      }
      else {
        response = chatBot.mirrorWords(user_input); 
        if (response.endsWith(".")) {
          response = response.replace(".", "?");
        }  
        System.out.println(response);
      }
      
      transcript.append(response + "\n"); }
      
  
    scanner.close();
    System.out.println("Bye!");
    transcript.append("Bye!");
    System.out.println(transcript);
    
  }
}
  

      
  
  