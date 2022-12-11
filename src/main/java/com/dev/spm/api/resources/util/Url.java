package com.dev.spm.api.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Url {

    public static String decoder(String text) {
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }

    public static Date convertDate(String stringDate, Date defaultDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            Date date = sdf.parse(stringDate);
            return new Date(date.getTime() + 24 * 60 * 60 * 1000);
        } catch (ParseException e) {
            return defaultDate;
        }
    }
}
