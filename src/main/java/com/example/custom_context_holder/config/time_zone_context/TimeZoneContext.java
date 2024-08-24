package com.example.custom_context_holder.config.time_zone_context;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZoneContext {
    public static LocalDateTime get(LocalDateTime localDateTime){
        return getZoneId(localDateTime).toLocalDateTime();
    }

    public static ZonedDateTime getZoneId(LocalDateTime localDateTime){
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        return zonedDateTime.withZoneSameInstant(TimeZoneContextHolder.get());
    }


    public static LocalDateTime convertToDefaultTimeZoneId(LocalDateTime localDateTime){
        ZonedDateTime zonedDateTime=ZonedDateTime.of(localDateTime, TimeZoneContextHolder.get());
        return zonedDateTime.withZoneSameInstant(TimeZoneContextHolder.getDefaultTimeZoneId()).toLocalDateTime();
    }

    public static ZoneId getDefaultTimeZoneId(){
        return TimeZoneContextHolder.getDefaultTimeZoneId();
    }
}
