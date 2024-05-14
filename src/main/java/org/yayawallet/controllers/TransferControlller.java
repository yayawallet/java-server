package org.yayawallet.controllers;

import com.yaya.sdk.ApiRequest.ApiClient;
import com.yaya.sdk.Services.Transaction;
import com.yaya.sdk.Services.Transfer;
import org.springframework.web.bind.annotation.*;
import org.yayawallet.Model.InstitutionAccount;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/transfer")
public class TransferControlller {
    @GetMapping("/list")
    public com.yaya.sdk.Models.Transfer[] getTransferList() throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        Transfer transfer = new Transfer(apiClient);
        return transfer.getTransferList();
    }
    @PostMapping("/lookup-external")
    public com.yaya.sdk.Models.ExternalAccount externalAccountLookup(@RequestBody InstitutionAccount institutionAccount) throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        Transfer transfer = new Transfer(apiClient);
        return transfer.externalAccountLookup(institutionAccount.getInstitutionCode(), institutionAccount.getAccountNumber());
    }
}
