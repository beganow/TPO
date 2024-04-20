import java.util.List;
import java.util.ArrayList;

public class Disc {
    private List<Song> songs;

    public Disc() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }
    public List<Song> getSongs() {
        return songs;
    }

    public int getDuration(){
        int duration = 0;
        for (Song song : songs) {
            duration += song.getDuration();
        }
        return duration;
    }
    public void StyleChange(String style) {
        List<Song> newDisc = new ArrayList<>();
        for (Song song : songs) {
            if (song.getStyle().equals(style)) {
                newDisc.add(song);
            }
        }

        songs = newDisc;
    }
    public List<Song> searchForLenght(int minLength, int maxLength) {
        List<Song> resault = new ArrayList<>();
        for (Song song : songs) {
            int duration = song.getDuration();
            if (duration >= minLength && duration <= maxLength) {
                resault.add(song);
            }
        }
        return resault;
    }

}
