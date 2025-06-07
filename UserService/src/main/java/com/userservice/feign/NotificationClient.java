package com.userservice.feign;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "NOTIFICATIONSERVICE")
public interface NotificationClient {

    @PostMapping("/notification/register-success")
    String sendRegistrationSuccessEmail(
            @RequestParam String emailId,
            @RequestParam String fullName
    );


}
