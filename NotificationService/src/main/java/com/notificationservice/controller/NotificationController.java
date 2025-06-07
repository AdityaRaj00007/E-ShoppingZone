package com.notificationservice.controller;
import com.notificationservice.dto.NotificationDetails;
import com.notificationservice.service.NotificationServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationServiceImpl notificationService;

    @Operation(summary = "Send email notification")
    @PostMapping("/sendMail")
    public ResponseEntity<?> sendMail(@RequestBody NotificationDetails details) {
        System.out.println(details);
        return notificationService.sendMail(details);
    }

    @Operation(summary = "Send registration email with token")
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody String email, @RequestParam String token) {
        notificationService.registerUser(email, token);
        return ResponseEntity.ok("User registered successfully and email sent");
    }


    @Operation(summary = "Send registration success email")
    @PostMapping("/register-success")
    public ResponseEntity<?> sendRegistrationSuccess(@RequestParam String emailId) {
        notificationService.sendRegistrationSuccessEmail(emailId);
        return ResponseEntity.ok("Success email sent");
    }
}
