package org.yayawallet.controllers;
import com.yaya.sdk.ApiRequest.ApiClient;
import com.yaya.sdk.Services.Saving;
import org.springframework.web.bind.annotation.*;
import org.yayawallet.Model.Amount;
import org.yayawallet.Model.Scheduled;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/scheduled-payment")
public class ScheduledController {
    @PostMapping("/create")
    public com.yaya.sdk.Models.Scheduled create(@RequestBody Scheduled scheduled) throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        com.yaya.sdk.Services.Scheduled scheduledResponse = new com.yaya.sdk.Services.Scheduled(apiClient);
        return scheduledResponse.create(scheduled.getAccountNumber(), scheduled.getAmount(), scheduled.getReason(), scheduled.getRecurring(), scheduled.getStartAt(), scheduled.getMetaData());
    }

    @GetMapping("/list")
    public com.yaya.sdk.Models.Scheduled[] getList() throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        com.yaya.sdk.Services.Scheduled scheduled= new com.yaya.sdk.Services.Scheduled(apiClient);
        return scheduled.getList();
    }

    @GetMapping("/archive/{id}")
    public com.yaya.sdk.Models.Scheduled archive(@PathVariable String id) throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        com.yaya.sdk.Services.Scheduled scheduled= new com.yaya.sdk.Services.Scheduled(apiClient);
        return scheduled.archive(id);
    }
}
