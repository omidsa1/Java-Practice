package Cinema;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 1. most populated city of each country
        // 2. movies count of each director


        Map<String, Long> collect = populateMoviePOJOsFromDB().stream()
                .map(Main::populateMoviePOJOsFromDB)
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Director::getName, Collectors.counting()));

        System.out.println(collect);
    }
        public static List<Movie> populateMoviePOJOsFromDB () {
            Connection connection = JDBCUtil.getConnection();
            List<Movie> movies = new ArrayList<>();

            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM Movie");
                while (rs.next()) {
                    Integer id = rs.getInt("id");
                    String title = rs.getString("title");
                    String year = rs.getString("year");
                    Movie movie = new Movie(id, title, year);
                    movies.add(movie);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return movies;
        }

        public static List<Director> populateDirectorPOJOsFromDB () {
            Connection connection = JDBCUtil.getConnection();
            List<Director> directors = new ArrayList<>();

            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM Director");
                System.out.println("rs" + rs);
                while (rs.next()) {
                    System.out.println("hi");
                    Integer id = rs.getInt("id");
                    String name = rs.getString("name");
                    Director director = new Director(id, name);
                    System.out.println();
                    directors.add(director);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println(directors);
            return directors;
        }

        public static List<Director> populateDirectorListFromQuery(){
            Connection connection = JDBCUtil.getConnection();
            List<Director> directors = new ArrayList<>();

            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM Director");
                while (rs.next()) {
                    Integer id = rs.getInt("id");
                    String name = rs.getString("name");
                    Director director = new Director(id, name);
                    directors.add(director);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return directors;
        }


//        public static List<Director> populateDirectorListOfEachMovieFromQuery(List<Movie> movies){
//            List<Director> directors = populateDirectorPOJOsFromDB();
//            for(Movie movie : movies) {
//                List<Director> movieDirectors = new ArrayList<>();
//                for(Director director : directors) {
//                    if(movie.getId() == director.getId()) {
//                        movieDirectors.add(director);
//                    }
//                }
//                movie.setDirectors(movieDirectors);
//            }
//            return directors;
//        }

    public static List<Director> populateMoviePOJOsFromDB(Movie movie){
        List<Director> directors=new ArrayList<>();
        try (Connection conn=JDBCUtil.getConnection()){
            PreparedStatement ps=conn.prepareStatement("select Director.id, Director.name, Movie.title\n" +
                    "from Director\n" +
                    "join Director_Movie ON Director.id = Director_Movie.Director_id\n" +
                    "join Movie On Movie.id = Director_Movie.Movie_id\n" +
                    "where movie.id=?");

            ps.setInt(1,movie.getId());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Director director=new Director(resultSet.getInt(1),resultSet.getString(2));
                directors.add(director);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return directors;
    }

}

