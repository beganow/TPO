public class Main {
    public static void main(String[] args) {
        Song song1 = new Song("Композиция 1", 180, "рок");
        Song song2 = new Song("Композиция 2", 240, "джаз");
        Song song3 = new Song("Композиция 3", 200, "классика");

        Disc disc = new Disc();
        disc.addSong(song1);
        disc.addSong(song2);
        disc.addSong(song3);

        Menu menu = new Menu(disc);
        menu.display();
        }
    }
