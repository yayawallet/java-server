package org.yayawallet.controllers;
import com.yaya.sdk.ApiRequest.ApiClient;
import com.yaya.sdk.Services.Airtime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

@RestController
public class AirtimeController {
    @GetMapping("/airtime")
    public com.yaya.sdk.Models.Airtime[] listRecharges() throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        Airtime airtime = new Airtime(apiClient);
        return airtime.listRecharges();
    }
}

