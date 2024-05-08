package org.yayawallet.controllers;
import com.yaya.sdk.ApiRequest.ApiClient;
import com.yaya.sdk.Services.Saving;
import org.springframework.web.bind.annotation.*;
import org.yayawallet.Model.Amount;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/saving")
public class SavingController {
    @PostMapping("/create")
    public com.yaya.sdk.Models.Saving createSaving(@RequestBody Amount amount) throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        Saving saving = new Saving(apiClient);
        return saving.createSaving(amount.getAmount());
    }

    @GetMapping("/withdrawals")
    public com.yaya.sdk.Models.Withdrawal[] withdrawals() throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        Saving saving = new Saving(apiClient);
        return saving.withdrawals();
    }
}
