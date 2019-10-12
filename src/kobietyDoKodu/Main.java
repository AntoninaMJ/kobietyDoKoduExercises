package kobietyDoKodu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {

    static CatDAO cats = new CatDAO();

    public static void main(String[] args) {
        String userChoice;
        do {
            System.out.println();
            System.out.println("#########################################################");
            System.out.println("######                 MENU                        ######");
            System.out.println("#########################################################");
            System.out.println("Wybierz z menu potrzebną opcję:");
            System.out.println("[1] - dodaj kota;");
            System.out.println("[2] - pokaż wszystkie koty;");
            System.out.println("[x] - wyjście z programu;");

            userChoice = input();
            if (userChoice.equals("1")){
                addCats();
            } else if (userChoice.equals("2")){
                showCats();
            }
        } while (!userChoice.equalsIgnoreCase("x"));
    }

    private static void addCats(){
        System.out.println();
        System.out.println("#########################################################");
        System.out.println("######                 DODAJ  KOTA                 ######");
        System.out.println("#########################################################");
        Cat cat = new Cat();
        System.out.println("Podaj imię kota:");
        cat.setName(input());
        System.out.println(("Podaj, kto jest opiekunem kota:"));
        cat.setOwner(input());

        Pattern datePattern = Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        do{
            System.out.println("Podaj datę urodzenia kota w formacie RRRR.MM.DD: ");
            String dateOfBirthInput = input();
            if (datePattern.matcher(dateOfBirthInput).matches()){
                try {
                    cat.setDateOfBirth(sdf.parse(dateOfBirthInput));
                } catch (ParseException e) {
                    System.out.println("Coś jest nie tak z datą! Przykładowa data: 2014.01.05");
                }
            }
        } while (cat.getDateOfBirth()==null);

        Pattern weightPattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        do {
            System.out.println("Podaj wagę kota:");
            String weightInput = input();
            if (weightPattern.matcher(weightInput).matches()){
                cat.setWeight(Float.valueOf(weightInput));
            } else {
                System.out.println("Coś jest nie tak z formatem wagi! Przykładowa waga: 10.0");
            }
        } while (cat.getWeight()==null);

        System.out.println("Dziękuję, teraz wiem o kocie naprawdę wszystko! " + cat.introduceYourself());
        cats.addCat(cat);
    }

    private static void showCats(){
        System.out.println();
        System.out.println("#########################################################");
        System.out.println("######                 LISTA KOTÓW                 ######");
        System.out.println("#########################################################");

        for (int i=0; i<cats.getCats().size(); i++){
            System.out.println("[" + i + "] " + cats.getCats().get(i).getName() + " ;");
        }

        Pattern catNumberPattern = Pattern.compile("[0-9]+");
        String catNumberInput;
        do {
            System.out.println("Wprowadź numer kota: ");
            catNumberInput = input();
        } while (!catNumberPattern.matcher(catNumberInput).matches());

        Integer choiceCat = Integer.parseInt(catNumberInput);
        if (choiceCat<cats.getCats().size()){
            System.out.println(cats.getCats().get(choiceCat).introduceYourself());
        } else {
            System.out.println("Niestety, nie znalazłem kota o wybranym numerze :( Sprobój ponownie lub go dodaj!");
        }
    }

    private static String input () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
