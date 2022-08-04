package Cinema;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private int id;
    private String title;
    private String year;
    private List<Genre> genres;
    private List<Director> directors;

    {
        genres = new ArrayList<>();
        directors = new ArrayList<>();
    }

    public Movie() {
    }

    public Movie(int id, String title, String year) {
        this.id = id;
        this.title = title;
        this.year = year;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    @Override
    public String toString() {
        return "Cinema.Movie [title=" + title + ", year=" + year + "]";
    }
}