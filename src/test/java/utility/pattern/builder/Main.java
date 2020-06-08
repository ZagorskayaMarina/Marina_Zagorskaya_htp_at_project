package utility.pattern.builder;

public class Main {
    public static void main(String[] args) {
        Person myPerson = new Person.Builder()
                .withName("Monika")
                .withSurname("Kuper")
                .withAge(39)
                .build();
    }
}
