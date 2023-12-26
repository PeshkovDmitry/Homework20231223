package Presenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BirthdayParser {

    public static Date parse(String birthdayString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = simpleDateFormat.parse(birthdayString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return birthday;
    }

}
