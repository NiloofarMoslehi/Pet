import java.sql.*;
import java.util.ArrayList;

public class Customer {
    Connection connection;
    private static Customer instance;

    public static Customer instance() {
        if (instance == null)
            instance = new Customer();
        return instance;
    }

    private Customer() {
        try {
            String fsc = "jdbc:sqlite:Pet.db";
            connection = DriverManager.getConnection(fsc);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean savePet(Pet pet) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("INSERT INTO \"pets\" (PetName,PetAge,PetOwner)" +
                    " VALUES( '%s', '%s', '%s', '%s');", pet.PetName, pet.PetAge, pet.PetOwner);
            statement.execute(query);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public ArrayList<Pet> loadPets() {
        ArrayList<Pet> pets = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM \"pets\" ;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String PetName = resultSet.getString("PetName");
                String PetOwner = resultSet.getString("PetOwner");
                int PetAge = resultSet.getInt("PetAge");
                Pet pet = new Pet(PetName, PetOwner,PetAge);
                pets.add(pet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pets;
    }
}
