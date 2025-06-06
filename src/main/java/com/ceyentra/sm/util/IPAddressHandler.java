/**
 * @author :  Dinuth Dheeraka
 * Created : 8/5/2023 1:20 AM
 */
package com.ceyentra.sm.util;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class IPAddressHandler {

    private final HttpServletRequest httpServletRequest;

    public IPAddressHandler(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public String getClientIP() {
        String xfHeader = httpServletRequest.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return httpServletRequest.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }

}
