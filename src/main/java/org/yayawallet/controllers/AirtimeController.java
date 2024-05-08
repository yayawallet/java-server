package org.yayawallet.controllers;
import com.yaya.sdk.ApiRequest.ApiClient;
import com.yaya.sdk.Services.Airtime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/airtime")
public class AirtimeController {
    @GetMapping("/list")
    public com.yaya.sdk.Models.Airtime[] listRecharges() throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        Airtime airtime = new Airtime(apiClient);
        return airtime.listRecharges();
    }
}

