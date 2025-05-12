/**
 * @author :  Dinuth Dheeraka
 * Created : 8/4/2023 11:22 PM
 */
package com.ceyentra.sm.config.throttling_config;

import com.ceyentra.sm.util.IPAddressHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserIdProvider {

    private final IPAddressHandler ipAddressHandler;

    public UserIdProvider(IPAddressHandler ipAddressHandler) {
        this.ipAddressHandler = ipAddressHandler;
    }

    public Optional<String> getCurrentUserId() {
        return Optional.of(this.ipAddressHandler.getClientIP());
    }

}
