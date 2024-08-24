package com.example.custom_context_holder.config.time_zone_context;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZoneContext {
    public static LocalDateTime get(LocalDateTime localDateTime){
        return ZonedDateTime.of(localDateTime, TimeZoneContextHolder.get()).toLocalDateTime();
    }

    public static ZonedDateTime getZoneId(LocalDateTime localDateTime){
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        return zonedDateTime.withZoneSameInstant(TimeZoneContextHolder.get());
    }


    public static LocalDateTime convertToDefaultTimeZoneId(ZonedDateTime zonedDateTime){
        return zonedDateTime.withZoneSameInstant(TimeZoneContextHolder.getDefaultTimeZoneId()).toLocalDateTime();
    }

    public static ZoneId getDefaultTimeZoneId(){
        return TimeZoneContextHolder.getDefaultTimeZoneId();
    }
}
