import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ParseDate {
    public static LocalDateTime parseIsoFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        return LocalDateTime.parse(stringDate);
    }

    public static LocalDate parseFullTextFormat(String stringDate) {

        if (stringDate == null) {
            return null;
        }

        DateTimeFormatter french =
                DateTimeFormatter.ofPattern("EEEE d MMMM yyyy", Locale.FRENCH);

        DateTimeFormatter english =
                DateTimeFormatter.ofPattern("EEEE d MMMM yyyy", Locale.ENGLISH);

        try {
            return LocalDate.parse(stringDate, french);
        } catch (Exception e) {
            return LocalDate.parse(stringDate, english);
        }
    }

    public static LocalTime parseTimeFormat(String stringDate) {

        if (stringDate == null) {
            return null;
        }

        String[] parts = stringDate.split(" ");
        int hour = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[5]);
        int seconds = Integer.parseInt(parts[8]);

        if (stringDate.contains("du soir") || stringDate.contains("in the evening")) {
            if (hour != 12) {
                hour += 12;
            }
        }

        if ((stringDate.contains("du matin") || stringDate.contains("in the morning")) && hour == 12) {
            hour = 0;
        }

        return LocalTime.of(hour, minutes, seconds);
    }
}