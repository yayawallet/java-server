package org.yayawallet.controllers;

import com.yaya.sdk.ApiRequest.ApiClient;
import com.yaya.sdk.Services.Transaction;
import org.springframework.web.bind.annotation.*;
import org.yayawallet.Model.Fee;
import org.yayawallet.Model.QRGenerate;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

@RestController
public class TransactionController {
    @GetMapping("/transaction/find-by-user")
    public com.yaya.sdk.Models.TransactionList getTransactionListByUser() throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        Transaction transaction = new Transaction(apiClient);
        return transaction.getTransactionListByUser();
    }

    @PostMapping("/transaction/create")
    public com.yaya.sdk.Models.TransactionAltered createTransaction(@RequestBody org.yayawallet.Model.Transaction createTransaction) throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        Transaction transaction = new Transaction(apiClient);
        return transaction.createTransaction(createTransaction.getReceiver(), createTransaction.getAmount(), createTransaction.getCause(), createTransaction.getMetaData());
    }

    @PostMapping("/transaction/Fee")
    public com.yaya.sdk.Models.Fee transactionFee(@RequestBody Fee transactionFee) throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        Transaction transaction = new Transaction(apiClient);
        return transaction.transactionFee(transactionFee.getReceiver(), transactionFee.getAmount());
    }

    @PostMapping("/transaction/qr-generate")
    public com.yaya.sdk.Models.QR generateQrUrl(@RequestBody QRGenerate qrGenerate) throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        Transaction transaction = new Transaction(apiClient);
        return transaction.generateQrUrl(qrGenerate.getAmount(), qrGenerate.getCause());
    }

    @GetMapping("/transaction/find/{id}")
    public com.yaya.sdk.Models.Transaction getTransactionById(@PathVariable String id) throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        Transaction transaction = new Transaction(apiClient);
        return transaction.getTransactionById(id);
    }
}
