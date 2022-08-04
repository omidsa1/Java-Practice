import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;



public class Main {

    public static void main(String[] args) {
        List<City> highestPopulationCityOfEachCountry = retriveAndAddCitiesToTheCountryPOJOs().stream()
                .map(country -> country.getCities().stream()
                .max(Comparator.comparing(City::getPopulation)))
                .filter(Optional::isPresent)
                .map(Optional::get).toList();
        System.out.println(highestPopulationCityOfEachCountry);

        countryPOJOToJson();
    }

//    private static void jsonToCountryPOJO() {
//        Reader input = new FileReader("./output.json");
//        Gson gson = new Gson();
//        Type type = new TypeToken<Country>(){}.getType();
//        Country country = gson.fromJson(input, type);
//    }

    public static void countryPOJOToJson(){
        List<Country> Countries = retriveAndAddCitiesToTheCountryPOJOs();


        JSONArray jsonArray = new JSONArray();
        for (Country country : Countries) {
            jsonArray.put(new JSONObject(country));
        }

        try {

            FileWriter file = new FileWriter("./output.json");
            file.write(jsonArray.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


        }

    public static List<City> populateCityPOJOsFromDB() {


        Connection connection = JDBCUtil.getConnection();
        List<City> cities = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM City");
            while(rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                Integer population = rs.getInt("population");
                String countryCode = rs.getString("countryCode");
                City city = new City(id, name, countryCode, population);
                cities.add(city);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return cities;
    }

    public static List<Country> populateCountryPOJOsFromDB(){
        Connection connection = JDBCUtil.getConnection();
        List<Country> countries = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Country");
            while(rs.next()) {
                String code = rs.getString("countrycode");
                String name = rs.getString("name");
                String continent = rs.getString("continent");
                Integer population = rs.getInt("population");
                Double surfaceArea = rs.getDouble("surfaceArea");
                Double gnp = rs.getDouble("gnp");
                String capital = rs.getString("capital");
                Country country = new Country(code, name, continent, population, surfaceArea, gnp, capital);
                countries.add(country);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return countries;
    }


    public static List<Country> retriveAndAddCitiesToTheCountryPOJOs(){
        List<Country> countries = populateCountryPOJOsFromDB();
        List<City> cities = populateCityPOJOsFromDB();
        for (Country country : countries) {
            for (City city : cities) {
                if(country.getCode().equals(city.getCountryCode())){
                    country.getCities().add(city);
                }
            }
        }
        return countries;
    }
    }

