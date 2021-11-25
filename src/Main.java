import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static String PetName;
    static String PetOwner;
    static int PetAge;

    public static void main(String[] args) {
        getDataFromInput();
    }

    private static void getDataFromInput() {
        boolean label = true;
        while (label) {
        Scanner s = new Scanner(System.in);
            int Input = s.nextInt();
            switch (Input) {
                case 1:
                    Pet pet = getPet();
                    saveToDatabase(pet);
                    break;
                case 2:
                    showPets();
                    break;
                case 3:
                    label = false;
                    break;
            }
        }
    }

    private static Pet getPet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Register your pet and its owner");
        System.out.println("Enter the name of pet:");
        PetName = scanner.next();
        System.out.println("Enter your pet owner:");
        PetAge = scanner.nextInt();
        System.out.println("Enter the name of the pet age:");
         PetOwner= scanner.next();
        return new Pet(PetName,PetOwner,PetAge);
    }

    private static void saveToDatabase(Pet pet) {
        boolean success = Customer.instance().savePet(pet);
        if (success)
            System.out.println("saved");
        else
            System.out.println("failed to save");
    }

    private static void showPets() {
        ArrayList<Pet> pets = Customer.instance().loadPets();
        for (Pet pet : pets) {
            System.out.println(pet);

        }

    }
}