package com.userservice.feign;

import org.springframework.stereotype.Component;

@Component
public class NotificationClientFallback implements NotificationClient {

    @Override
    public String sendRegistrationSuccessEmail(String emailId, String fullName) {
        // Fallback logic for success email failure
        return "⚠️ Notification Service is currently unavailable. Success email could not be sent to " + fullName + " (" + emailId + ").";
    }
}
