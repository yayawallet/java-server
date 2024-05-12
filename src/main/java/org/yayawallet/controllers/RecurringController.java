package org.yayawallet.controllers;
import com.yaya.sdk.ApiRequest.ApiClient;
import com.yaya.sdk.Models.ContractAltered;
import com.yaya.sdk.Models.PaymentRequest;
import com.yaya.sdk.Models.PaymentRequestAltered;
import com.yaya.sdk.Models.TransactionAltered;
import org.springframework.web.bind.annotation.*;
import org.yayawallet.Model.Contract;
import org.yayawallet.Model.Payment;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/recurring-contract")
public class RecurringController {
    @PostMapping("/create")
    public ContractAltered createContract(@RequestBody Contract contract) throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        com.yaya.sdk.Services.RecurringContract recurringContract = new com.yaya.sdk.Services.RecurringContract(apiClient);
        return recurringContract.createContract(contract.getContractNumber(), contract.getServiceType(), contract.getCustomerAccountName(), contract.getMetaData());
    }

    @PostMapping("/request-payment")
    public PaymentRequestAltered requestPayment(@RequestBody Payment payment) throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        com.yaya.sdk.Services.RecurringContract recurringContract= new com.yaya.sdk.Services.RecurringContract(apiClient);
        return recurringContract.requestPayment(payment.getContractNumber(), payment.getAmount(), payment.getCurrency(), payment.getCause(), payment.getNotificationUrl(), payment.getMetaData());
    }

    @GetMapping("/subscriptions")
    public com.yaya.sdk.Models.Contract getSubscription() throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        com.yaya.sdk.Services.RecurringContract recurringContract= new com.yaya.sdk.Services.RecurringContract(apiClient);
        return recurringContract.getSubscriptions();
    }

    @GetMapping("/payment-requests")
    public PaymentRequest[] getListOfpaymentRequests() throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        com.yaya.sdk.Services.RecurringContract recurringContract= new com.yaya.sdk.Services.RecurringContract(apiClient);
        return recurringContract.getListOfpaymentRequests();
    }

    @GetMapping("/approve-payment/{ID}")
    public TransactionAltered approvePaymentRequest(@PathVariable String ID) throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        com.yaya.sdk.Services.RecurringContract recurringContract= new com.yaya.sdk.Services.RecurringContract(apiClient);
        return recurringContract.approvePaymentRequest(ID);
    }

    @GetMapping("/reject-payment/{ID}")
    public PaymentRequestAltered rejectPaymentRequest(@PathVariable String ID) throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        com.yaya.sdk.Services.RecurringContract recurringContract= new com.yaya.sdk.Services.RecurringContract(apiClient);
        return recurringContract.rejectPaymentRequest(ID);
    }

    @GetMapping("/activate/{ID}")
    public com.yaya.sdk.Models.Contract activateSubscription(@PathVariable String ID) throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        com.yaya.sdk.Services.RecurringContract recurringContract= new com.yaya.sdk.Services.RecurringContract(apiClient);
        return recurringContract.activateSubscription(ID);
    }

    @GetMapping("/deactivate/{ID}")
    public com.yaya.sdk.Models.Contract deactivateSubscription(@PathVariable String ID) throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        com.yaya.sdk.Services.RecurringContract recurringContract= new com.yaya.sdk.Services.RecurringContract(apiClient);
        return recurringContract.deactivateSubscription(ID);
    }
}
