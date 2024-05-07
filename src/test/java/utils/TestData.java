package utils;

import com.github.javafaker.Faker;

import java.time.Month;
import java.time.Year;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestData {
    public Faker faker = new Faker();

    public static final String[] genders = {"Male","Female","Other"};
    public static final String[] listOfMonths = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
    public static final String[] subjects =
            new String[]{"Maths", "Accounting", "Arts", "Social Studies", "Physics", "Chemistry"};
    public static final String[] hobbies =
            new String[] { "Sports","Reading", "Music" };
    public static String[] states =
            new String[]{"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    public static Map<String, String[]> statesAndCityMap = new HashMap<>();

    public String firstName = getRandomName();
    public String lastName = getRandomLastName();
    public String email = getRandomEmail();
    public String gender = getRandomGender();
    public String phone = getRandomPhoneNumber();
    public String[] subjectList = getRandomSubjectList();
    public String[] hobbiesList = getRandomHobbiesList();
    public String picture = "selenide-logo-big.png";
    public String address = getRandomAddress();
    public String state = getRandomState();
    public String city = fillStatesAndGetCity(state);
    public String year = String.valueOf(getRandomYear());
    public String month = getRandomMonth();
    public String day = getRandomDay(month);

    public static String[] getRandomSelection(String[] list){
        int numberOfElements = (int) ((Math.random() * list.length)+1);
        String[] selection = new String[numberOfElements];
        for (int i = 0; i < numberOfElements;){
            int randomIndex = (int) (Math.random() * numberOfElements);
            String randomSubject = list[randomIndex];
            if (!Arrays.asList(selection).contains(randomSubject)){
                selection[i] = randomSubject;
                i++;
            }
        }
        return selection;
    }

    public String getRandomEmail(){
        return faker.internet().emailAddress();
    }

    public String getRandomAddress(){
        return faker.address().fullAddress();
    }

    public int getRandomYear(){
        return faker.number().numberBetween(1900, Year.now().getValue());
    }

    public String getRandomMonth(){
        return faker.options().option(listOfMonths);
    }

    public String getRandomDay(String month){
        Month aMonth = Month.valueOf(month.toUpperCase());
        int daysInMonth = aMonth.length(true);
        return Integer.toString(faker.number().numberBetween(1, daysInMonth));
    }

    public String getRandomName() {

        return faker.name().firstName();
    }

    public String getRandomLastName() {

        return faker.name().lastName();
    }

    public String getRandomGender()
    {
        return faker.options().option(genders);
    }

    public String getRandomPhoneNumber() {
        return faker.number().digits(10);
    }

    public String[] getRandomSubjectList(){
        return getRandomSelection(subjects);
    }

    public String[] getRandomHobbiesList(){
        return getRandomSelection(hobbies);
    }

    public String getRandomState()
    {
        return faker.options().option(states);
    }

        public String fillStatesAndGetCity(String state){
        statesAndCityMap.put(states[0], new String[]{"Delphi", "Gurgaon", "Noida"});
        statesAndCityMap.put(states[1], new String[]{"Agra", "Lucknow", "Merrut"});
        statesAndCityMap.put(states[2], new String[]{"Karnal", "Panipat"});
        statesAndCityMap.put(states[3], new String[]{"Jaipur", "Jaiselmer"});
        String[] cityArray = statesAndCityMap.get(state);

        return cityArray[faker.number().numberBetween(0, cityArray.length)];

    }
}
