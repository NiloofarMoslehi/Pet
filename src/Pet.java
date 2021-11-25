public class Pet {
    String PetName;
    String PetOwner;
    int PetAge;

    public Pet(String PetName,String PetOwner,int PetAge){
        this.PetName = PetName;
        this.PetOwner = PetOwner;
        this.PetAge = PetAge;

    }

    public String toString() {
        return"Pet{" +
                "petName='" + PetName + '\'' +
                ", petAge=" + PetOwner +'\'' +
                ", petOwner='" +PetAge +
                '}';
       }
    }

