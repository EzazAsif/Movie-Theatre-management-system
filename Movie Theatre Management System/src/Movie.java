public class Movie  {

    private String title;

    private int duration;

    private String genre;

    public Movie(String title) {
        this.title = title;
    }

    public Movie(String title, int duration, String genre) {

        this.title = title;

        this.duration = duration;

        this.genre = genre;

    }

    public String getTitle() {
        return title;
    }

    public void displayDetails() {

        System.out.println("Title: " + title);

        System.out.println("Duration: " + duration + " minutes");

        System.out.println("Genre: " + genre);

    }

}