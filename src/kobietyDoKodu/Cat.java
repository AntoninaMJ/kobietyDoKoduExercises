package kobietyDoKodu;

import java.util.Date;

public class Cat {

    private String name;
    private Date dateOfBirth;
    private String owner;
    private Float weight;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weigth) {
        this.weight = weigth;
    }

    public String introduceYourself(){
        return "Cześć, jestem " + name + ", urodziłem się " + dateOfBirth + ", ważę " + weight + " kg, moim właścicielem jest " + owner;
    }

}
