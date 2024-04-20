public abstract class MusicComposition {
    private String title;
    private int duration; // продолжительность композиции в секундах

    public MusicComposition(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public abstract String getStyle ();
}
