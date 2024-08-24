package com.example.custom_context_holder.config.time_zone_context;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZoneId;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class TimeZoneContextHolder {

    private static final ThreadLocal<ZoneId> timeZoneContext=new ThreadLocal<>();

    @Getter
    private static final ZoneId defaultTimeZoneId=ZoneId.of("Asia/Tashkent");

    static ZoneId get(){
        return timeZoneContext.get();
    }

    static void set(ZoneId timeZone){
        timeZoneContext.set(timeZone);
    }

    static void remove(){
        timeZoneContext.remove();
    }
}
