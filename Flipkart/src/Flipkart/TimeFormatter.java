package Flipkart;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TimeFormatter {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);

    public static String format(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).format(formatter);
    }
}