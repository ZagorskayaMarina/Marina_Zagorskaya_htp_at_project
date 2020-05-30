package application_items.booking;

import java.util.Random;
import java.util.stream.Collectors;

public class MailGenerator {
    public static String generateRandomMail(){
        String symbols = "abcdefghijklmnopqrstuvwxyz123456789";
        String ramdomMail = new Random().ints(9, 0, symbols.length())
                .mapToObj(symbols::charAt)
                .map(character -> character.toString())
                .collect(Collectors.joining());
        return ramdomMail;
    }
}
