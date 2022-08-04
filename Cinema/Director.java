package Cinema;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private int id;
    private String name;
    private List<Movie> movies= new ArrayList<>();


    public Director(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Cinema.Director [id=" + id + ", name=" + name + "]";
    }
}