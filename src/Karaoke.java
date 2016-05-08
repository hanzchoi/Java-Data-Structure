import treehouse.model.Song;
import treehouse.model.SongBook;

public class Karaoke {

    public static void main(String[] args){
        SongBook songBook = new SongBook();
        KaraokeMachine machine = new KaraokeMachine(songBook);
        machine.run();

    }

    private static void example(){
        Song song = new Song(
                "Michael Jackson",
                "Beat It",
                "https://www.youtube.com/watch?v=SaEC9i9QOvk"
        );
        SongBook songBook = new SongBook();
        System.out.printf("Adding %s %n",song);
        songBook.addSong(song);
        System.out.printf("There are %d songs.", songBook.getSongCount()); //%d is for the numbers
    }

}
