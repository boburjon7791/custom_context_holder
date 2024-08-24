package com.example.custom_context_holder.config.time_zone_context;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.ZoneId;

public class TimeZoneInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(@NonNull HttpServletRequest request,
                             @NonNull HttpServletResponse response,
                             @NonNull Object handler) throws Exception {
        String timeZone = request.getParameter("time-zone");
        ZoneId zoneId = ZoneId.of(timeZone != null && !timeZone.isBlank() ? timeZone : "Asia/Tashkent");
        TimeZoneContextHolder.set(zoneId);
        return true;
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request,
                                @NonNull HttpServletResponse response,
                                @NonNull Object handler, Exception ex) throws Exception {
        TimeZoneContextHolder.remove();
    }
}
