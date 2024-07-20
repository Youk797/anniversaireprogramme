import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
    public static String removeYear(String date) {
        return date.substring(5); // assuming date format is yyyy-MM-dd
    }

    public static String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        return removeYear(formattedDate);
    }
}

