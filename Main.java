//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.Month;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {
    static LocalDate calcBirthdate(int yearsOld, String birthSeason) {
        int birthYear = LocalDate.now().getYear() - yearsOld;
        LocalDate birthDate;

        switch (birthSeason.trim().toLowerCase()) {
            case "spring":
                birthDate = LocalDate.of(birthYear, Month.MARCH, 21);
                break;
            case "summer":
                birthDate = LocalDate.of(birthYear, Month.JUNE, 21);
                break;
            case "fall":
                birthDate = LocalDate.of(birthYear, Month.SEPTEMBER, 21);
                break;
            case "winter":
                birthDate = LocalDate.of(birthYear, Month.DECEMBER, 21);
                break;
            default:
                birthDate = LocalDate.of(birthYear, Month.JANUARY, 1);
                break;
        }
        return birthDate;
    }

    static String genUniqueID(String speciesName, int numOfSpecies) {
        String uniqueID;

        switch (speciesName) {
            case "hyena":
                uniqueID = "Hy" + String.format("%02d", numOfSpecies);
                break;
            case "lion":
                uniqueID = "Li" +  String.format("%02d", numOfSpecies);
                break;
            case "tiger":
                uniqueID = "Ti" +  String.format("%02d", numOfSpecies);
                break;
            case "bear":
                uniqueID = "Be" +  String.format("%02d", numOfSpecies);
                break;
            default:
                uniqueID = "error";
                break;
        }
        return uniqueID;
    }

    static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("\n Number of animals is: " + Animal.getNumOfAnimals());
        LocalDate birthDate = calcBirthdate(4, "spring");
        LocalDate arrivalDate = LocalDate.now(); // Assuming today's date as arrival
        Period age = Period.between(birthDate, arrivalDate);
        System.out.println("Birthdate: " + birthDate);
        System.out.println("Arrival Date: " + arrivalDate);
        System.out.println("Age: " + age.getYears() + " years, " + age.getMonths() + " months, "
                + age.getDays() + " days");
        ArrayList<String> hyenaNames = new ArrayList<>();
        ArrayList<String> lionNames = new ArrayList<>();
        ArrayList<String> tigerNames = new ArrayList<>();
        ArrayList<String> bearNames = new ArrayList<>();
        ArrayList<Hyena> hyenaList = new ArrayList<>();
        ArrayList<Lion> lionsList = new ArrayList<>();
        ArrayList<Tiger> tigersList = new ArrayList<>();
        ArrayList<Bear> bearsList = new ArrayList<>();
        String aFilePath = "C:/2024_Spring/midtermFiles/animalNames.txt";
        File aFile = new File(aFilePath);
        try (Scanner scanner = new Scanner(aFile)) {
            while (scanner.hasNextLine()) {
                String aLine = scanner.nextLine();
                System.out.println("\n aLine = " + aLine);
                if (aLine.contains("Hyena")) {
                    scanner.nextLine();
                    String[] myHyenaNamesArray = scanner.nextLine().split(", ");
                    for (String someName : myHyenaNamesArray)
                        System.out.println(someName);
                    for (String someName : myHyenaNamesArray)
                        hyenaNames.add(someName);
                    String firstHyenaName = hyenaNames.remove(0);
                    System.out.println("First hyena name: " + firstHyenaName);
                    firstHyenaName = hyenaNames.remove(0);
                    System.out.println("First hyena name: " + firstHyenaName);
                    firstHyenaName = hyenaNames.remove(0);
                    System.out.println("First hyena name: " + firstHyenaName);
                }
                if (aLine.contains("Lion")) {
                    scanner.nextLine();
                    String[] myLionNamesArray = scanner.nextLine().split(", ");
                    for (String someName : myLionNamesArray)
                        System.out.println(someName);
                    for (String someName : myLionNamesArray)
                        lionNames.add(someName);
                    String firstLionName = lionNames.remove(0);
                    System.out.println("First lion name: " + firstLionName);
                    firstLionName = lionNames.remove(0);
                    System.out.println("First lion name: " + firstLionName);
                    firstLionName = lionNames.remove(0);
                    System.out.println("First lion name: " + firstLionName);
                }
                if (aLine.contains("Tiger")) {
                    scanner.nextLine();
                    String[] myTigerNamesArray = scanner.nextLine().split(", ");
                    for (String someName : myTigerNamesArray)
                        System.out.println(someName);
                    for (String someName : myTigerNamesArray)
                        tigerNames.add(someName);
                    String firstTigerName = tigerNames.remove(0);
                    System.out.println("First tiger name: " + firstTigerName);
                    firstTigerName = tigerNames.remove(0);
                    System.out.println("First tiger name: " + firstTigerName);
                    firstTigerName = tigerNames.remove(0);
                    System.out.println("First tiget name: " + firstTigerName);
                }
                if (aLine.contains("Bear")) {
                    scanner.nextLine();
                    String[] myBearNamesArray = scanner.nextLine().split(", ");
                    for (String someName : myBearNamesArray)
                        System.out.println(someName);
                    for (String someName : myBearNamesArray)
                        bearNames.add(someName);
                    String firstBearName = bearNames.remove(0);
                    System.out.println("First bear name: " + firstBearName);
                    firstBearName = bearNames.remove(0);
                    System.out.println("First lion name: " + firstBearName);
                    firstBearName = bearNames.remove(0);
                    System.out.println("First lion name: " + firstBearName);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + aFilePath);
            e.printStackTrace();
        }

        String filePath = "C:/2024_Spring/midtermFiles/arrivingAnimals.txt";
        File file = new File(filePath);

        String species = null;
        String animalSex = null;
        String animalColor = null;
        String animalOrigin = null;
        String animalSound = null;
        int ageInYears = 0;
        int animalWeight = 0;
        LocalDate animalBirthDate = null;
        LocalDate animalArrivalDate = null;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split(", ");
                if (parts.length > 0) {


                    String ageAndSpecies = parts[0];
                    System.out.println("ageAndSpecies: " + ageAndSpecies);

                    String[] ageSpeciesWords = ageAndSpecies.split(" ");

                    if (ageSpeciesWords.length >= 4) {

                        ageInYears = Integer.parseInt(ageSpeciesWords[0]);

                        System.out.println("\n ageInYears is: " + ageInYears);

                        animalSex = ageSpeciesWords[3];
                        System.out.println("\n animalSex is: " + animalSex);


                        species = ageSpeciesWords[4];
                        System.out.println("\n ********* species is: " + species);
                    } else {
                        System.out.println("\n Error in data input file.\n");
                    }
                    String animalBirthSeason = parts[1];
                    System.out.println("animalBirthSeason: " + animalBirthSeason);

                    String[] animalBirthSeasonWords = animalBirthSeason.split(" ");

                    String aniBirthSeason = null;
                    if (animalBirthSeasonWords.length >= 3) {

                        aniBirthSeason = animalBirthSeasonWords[2];

                        System.out.println("\n aniBirthSeason is: " + aniBirthSeason);
                    }

                    animalBirthDate = calcBirthdate(ageInYears, aniBirthSeason);
                    System.out.println("\n animalBirthDate is: " + animalBirthDate);


                    animalColor = parts[2];
                    System.out.println("animalColor: " + animalColor);


                    String animalWeightStr = parts[3];

                    String[] theAnimalWeight = animalWeightStr.split(" ");
                    animalWeight = Integer.parseInt(theAnimalWeight[0]);
                    System.out.println("animalWeight: " + animalWeight);

                    animalOrigin = parts[4] + ", " + parts[5];
                    System.out.println("\n animalOrigin is: " + animalOrigin);

                    LocalDate theBirthDate = calcBirthdate(ageInYears, aniBirthSeason);
                    System.out.println("\n theBirthDate is: " + theBirthDate + "\n");
                } else {
                    System.out.println("\nError in data file: right after scanning a next line.\n");
                }
                if (species.equals("hyena")) {

                    String aHyenaName = hyenaNames.remove(0);

                    int howManyHyenas = Hyena.getNumOfHyenas();
                    String animalID = genUniqueID("hyena", howManyHyenas+1);

                    animalArrivalDate = LocalDate.now();

                    String hyenaSound = null;
                    for (int i = 1; i <= howManyHyenas+1; i++) {
                        switch (i % 4) {
                            case 1:
                                hyenaSound = "haha";
                                break;
                            case 2:
                                hyenaSound = "hehe";
                                break;
                            case 3:
                                hyenaSound = "xaxa";
                                break;
                            case 0:
                                hyenaSound = "chachachachahchachacac";
                                break;
                        }
                    }

                    Hyena newHyena = new Hyena(aHyenaName, animalSex, animalColor, animalID, animalOrigin, animalWeight,
                            animalBirthDate, animalArrivalDate,hyenaSound);

                    hyenaList.add(newHyena);
                }

                if (species.equals("lion")) {

                    String aLionName = lionNames.remove(0);

                    int howManyLions = Lion.getNumOfLions();
                    String animalID = genUniqueID("lion", howManyLions+1);

                    animalArrivalDate = LocalDate.now();

                    String lionSound = null;
                    for (int i = 1; i <= howManyLions+1; i++) {
                        switch (i % 4) {
                            case 1:
                                lionSound = "Roaasdrrr";
                                break;
                            case 2:
                                lionSound = "RoooarRoooar";
                                break;
                            case 3:
                                lionSound = "Rawr!";
                                break;
                            case 0:
                                lionSound = "Rrrrroarrrr";
                                break;
                        }
                    }

                    Lion newLion = new Lion(aLionName, animalSex, animalColor, animalID, animalOrigin, animalWeight,
                            animalBirthDate, animalArrivalDate,lionSound);

                    lionsList.add(newLion);
                }

                if (species.equals("tiger")) {
                    String aTigerName = tigerNames.remove(0);

                    int howManyTigers = Tiger.getNumOfTigers();
                    String animalID = genUniqueID("tiger", howManyTigers+1);

                    animalArrivalDate = LocalDate.now();

                    String tigerSound = null;
                    for (int i = 1; i <= howManyTigers+1; i++) {
                        switch (i % 4) {
                            case 1:
                                tigerSound = "Meeeewwww";
                                break;
                            case 2:
                                tigerSound = "Meowww";
                                break;
                            case 3:
                                tigerSound = "Mrrrrewmeow!";
                                break;
                            case 0:
                                tigerSound = "Mew! Mew!";
                                break;
                        }
                    }

                    Tiger newTiger = new Tiger(aTigerName, animalSex, animalColor, animalID, animalOrigin, animalWeight,
                            animalBirthDate, animalArrivalDate,tigerSound);

                    tigersList.add(newTiger);
                }

                if (species.equals("bear")) {

                    String aBearName = bearNames.remove(0);

                    int howManyBears = Bear.getNumOfBears();
                    String animalID = genUniqueID("bear", howManyBears+1);

                    animalArrivalDate = LocalDate.now();

                    String bearSound = null;
                    for (int i = 1; i <= howManyBears+1; i++) {
                        switch (i % 4) {
                            case 1:
                                bearSound = "Grrrrr";
                                break;
                            case 2:
                                bearSound = "RrrrRrrr";
                                break;
                            case 3:
                                bearSound = "Gruff!";
                                break;
                            case 0:
                                bearSound = "Rrruff";
                                break;
                        }
                    }

                    Bear newBear = new Bear(aBearName, animalSex, animalColor, animalID, animalOrigin, animalWeight,
                            animalBirthDate, animalArrivalDate,bearSound);

                    bearsList.add(newBear);
                }


            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            e.printStackTrace();
        }

        for (Hyena hyena : hyenaList) {

            int animalAgeInYears = calculateAge(hyena.getBirthDate(), hyena.getArrivalDate());
            System.out.println(hyena.getId() + "; " +  animalAgeInYears + " years old; " + hyena.getName()
                    + "; birthDate: " + hyena.getBirthDate() + "; " + hyena.getColor() + "; " + hyena.getSex()
                    + "; " + hyena.getWeight() + " pounds" + "; " + "laugh: " + hyena.getLaughSound()
                    + "; from: " + hyena.getOrigin() + "; " + "arrived: " + hyena.getArrivalDate());
        }
        System.out.println("\n");

        for (Lion lion : lionsList) {

            int animalAgeInYears = calculateAge(lion.getBirthDate(), lion.getArrivalDate());
            System.out.println(lion.getId() + "; " +  animalAgeInYears + " years old; " + lion.getName()
                    + "; birthDate: " + lion.getBirthDate() + "; " + lion.getColor() + "; " + lion.getSex()
                    + "; " + lion.getWeight() + " pounds" + "; " + "roar: " + lion.getRoarSound()
                    + "; from: " + lion.getOrigin() + "; " + "arrived: " + lion.getArrivalDate());
        }
        System.out.println("\n");

        for (Tiger tiger : tigersList) {

            int animalAgeInYears = calculateAge(tiger.getBirthDate(), tiger.getArrivalDate());
            System.out.println(tiger.getId() + "; " +  animalAgeInYears + " years old; " + tiger.getName()
                    + "; birthDate: " + tiger.getBirthDate() + "; " + tiger.getColor() + "; " + tiger.getSex()
                    + "; " + tiger.getWeight() + " pounds" + "; " + "mew: " + tiger.getMewSound()
                    + "; from: " + tiger.getOrigin() + "; " + "arrived: " + tiger.getArrivalDate());
        }
        System.out.println("\n");

        for (Bear bear : bearsList) {

            int animalAgeInYears = calculateAge(bear.getBirthDate(), bear.getArrivalDate());
            System.out.println(bear.getId() + "; " +  animalAgeInYears + " years old; " + bear.getName()
                    + "; birthDate: " + bear.getBirthDate() + "; " + bear.getColor() + "; " + bear.getSex()
                    + "; " + bear.getWeight() + " pounds" + "; " + "mew: " + bear.getGrowlSound()
                    + "; from: " + bear.getOrigin() + "; " + "arrived: " + bear.getArrivalDate());
        }
        System.out.println("\n");




        try (BufferedWriter writer = new BufferedWriter(new FileWriter(
                "C:/2024_Spring/midtermFiles/zooPopulation.txt", true))) {
            writer.write("\n ******* Zoo Population and Habitat Assignment Report ******** \n\n");
            writer.write("Hyena Habitat:\n\n");
            for (Hyena hyena : hyenaList) {

                int animalAgeInYears = calculateAge(hyena.getBirthDate(), LocalDate.now());
                writer.write(hyena.getId() + "; " + animalAgeInYears + " years old; " + hyena.getName()
                        + "; birthDate: " + hyena.getBirthDate() + "; " + hyena.getColor() + "; " + hyena.getSex()
                        + "; " + hyena.getWeight() + " pounds" + "; " + "laugh: " + hyena.getLaughSound()
                        + "; from: " + hyena.getOrigin() + "; " + "arrived: " + hyena.getArrivalDate() + "\n");
            }
            writer.write("\nLion Habitat:\n\n");
            for (Lion lion : lionsList) {

                int animalAgeInYears = calculateAge(lion.getBirthDate(), LocalDate.now());
                writer.write(lion.getId() + "; " + animalAgeInYears + " years old; " + lion.getName()
                        + "; birthDate: " + lion.getBirthDate() + "; " + lion.getColor() + "; " + lion.getSex()
                        + "; " + lion.getWeight() + " pounds" + "; " + "roar: " + lion.getRoarSound()
                        + "; from: " + lion.getOrigin() + "; " + "arrived: " + lion.getArrivalDate() + "\n");
            }
            writer.write("\nTiger Habitat:\n\n");
            for (Tiger tiger : tigersList) {

                int animalAgeInYears = calculateAge(tiger.getBirthDate(), LocalDate.now());
                writer.write(tiger.getId() + "; " + animalAgeInYears + " years old; " + tiger.getName()
                        + "; birthDate: " + tiger.getBirthDate() + "; " + tiger.getColor() + "; " + tiger.getSex()
                        + "; " + tiger.getWeight() + " pounds" + "; " + "roar: " + tiger.getMewSound()
                        + "; from: " + tiger.getOrigin() + "; " + "arrived: " + tiger.getArrivalDate() + "\n");
            }
            writer.write("\nBear Habitat:\n\n");
            for (Bear bear : bearsList) {

                int animalAgeInYears = calculateAge(bear.getBirthDate(), LocalDate.now());
                writer.write(bear.getId() + "; " + animalAgeInYears + " years old; " + bear.getName()
                        + "; birthDate: " + bear.getBirthDate() + "; " + bear.getColor() + "; " + bear.getSex()
                        + "; " + bear.getWeight() + " pounds" + "; " + "roar: " + bear.getGrowlSound()
                        + "; from: " + bear.getOrigin() + "; " + "arrived: " + bear.getArrivalDate() + "\n");
            }





            writer.flush();
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }



    }
}