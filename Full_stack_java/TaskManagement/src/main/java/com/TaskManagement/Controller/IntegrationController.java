package com.TaskManagement.Controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.TaskManagement.Service.IntegrationService;

@RestController
@RequestMapping("/api/integrations")
public class IntegrationController {

    @Autowired
    private IntegrationService integrationService;

    
    @PostMapping("/github")
    public ResponseEntity<?> processGithubEvent(
            @RequestHeader(value = "X-GitHub-Event", required = false) String event,
            @RequestBody Map<String, Object> payload) {

        if (event == null) {
            return ResponseEntity.badRequest().body("Missing header: X-GitHub-Event");
        }

        System.out.println("GitHub Event Received: " + event);
        integrationService.processGithubEvent(event.toUpperCase(), payload);

        return ResponseEntity.ok("GitHub Event Processed Successfully");
    }

    // ------------------------------------------------------------------
    // JENKINS WEBHOOK
    // ------------------------------------------------------------------
    @PostMapping("/jenkins")
    public ResponseEntity<?> processJenkinsEvent(@RequestBody Map<String, Object> payload) {

        System.out.println("Jenkins Event Received");
        integrationService.processJenkinsEvent(payload);

        return ResponseEntity.ok("Jenkins Event Processed Successfully");
    }

     
    
    @PostMapping("/docker")
    public ResponseEntity<?> processDockerEvent(@RequestBody Map<String, Object> payload) {

        System.out.println("Docker Event Received");
        integrationService.processDockerEvent(payload);

        return ResponseEntity.ok("Docker Event Processed Successfully");
    }

    
    @PostMapping("/commit")
    public ResponseEntity<?> handleCommit(
            @RequestParam String message,
            @RequestParam String author) {

        integrationService.handleCommitMessage(message, author);
        return ResponseEntity.ok("Commit processed");
    }

    
    @PostMapping("/pullRequest")
    public ResponseEntity<?> handlePR(
            @RequestParam String title,
            @RequestParam String author) {

        integrationService.handlePullRequest(title, author);

        return ResponseEntity.ok("Pull Request processed");
    }
}
