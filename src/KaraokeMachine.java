import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import treehouse.model.SongBook;

public class KaraokeMachine {
    private SongBook mSongBook;
    private BufferedReader mReader;
    private Map<String, String> mMenu;

    public KaraokeMachine(SongBook songBook){
        mSongBook = songBook;
        mReader = new BufferedReader(new InputStreamReader(System.in));
        mMenu = new HashMap<>();
        mMenu.put("add", "Add a new song to the song book");
        mMenu.put("quit", "Give up. Exit the program");
    }

    private String promptAction() throws IOException{
        System.out.printf("There are %d songs available. Your option are: %n",
                          mSongBook.getSongCount());
        for(Map.Entry<String, String> option : mMenu.entrySet()){
            System.out.printf("%s - %s %n",
                              option.getKey(),
                              option.getValue());
        }
        System.out.print("What do you want to do: ");
        String choice = mReader.readLine();
        return choice.trim().toLowerCase();
    }

    public void run(){
        String choice = "";

        do {
            try {
                choice = promptAction();

                switch(choice){
                    case "add":
                        //TODO: Add a new song
                        break;
                    case "quit":
                        System.out.println("Thanks for playing!");
                        break;
                    default:
                        System.out.printf("Unknown choice:  '%s'. Try again. %n%n%n" , choice);

                }
            }catch(IOException ioe){
                System.out.println("Problem with input");
                ioe.printStackTrace();
            }

        }while(!choice.equals("quit"));
    }
}