package com.TaskManagement.Client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;

import com.TaskManagement.Enum.IssueStatus;

@FeignClient(name = "issue_service", url = "${issue_service.url}")
public interface IssueClient {

    @PutMapping("/{id}/status")
    void updateStatus(@PathVariable("id") Long id,
                      @RequestParam("status") IssueStatus status,
                      @RequestParam("author") String author);

    @PostMapping("/{id}/commit")
    void addCommit(@PathVariable("id") Long id,
                   @RequestParam("author") String author,
                   @RequestParam("message") String message);
}
