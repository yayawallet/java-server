package org.yayawallet.controllers;
import com.yaya.sdk.ApiRequest.ApiClient;
import com.yaya.sdk.Services.Airtime;
import org.springframework.web.bind.annotation.*;
import org.yayawallet.Model.Phone;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/airtime")
public class AirtimeController {
    @PostMapping("/buy")
    public com.yaya.sdk.Models.Airtime buyAirtime(@RequestBody org.yayawallet.Model.Airtime airtime) throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        com.yaya.sdk.Services.Airtime airtimeService = new com.yaya.sdk.Services.Airtime(apiClient);
        if(airtime.getPackageCode() != null){
            return airtimeService.buyPackage(airtime.getPhone(), airtime.getPackageCode());
        }
        return airtimeService.buyAirtime(airtime.getPhone(), airtime.getAmount());
    }
    @GetMapping("/list")
    public com.yaya.sdk.Models.Airtime[] listRecharges() throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        Airtime airtime = new Airtime(apiClient);
        return airtime.listRecharges();
    }

    @PostMapping("/packages")
    public com.yaya.sdk.Models.Package[] listPackages(@RequestBody Phone phone) throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        com.yaya.sdk.Services.Airtime airtimeService = new com.yaya.sdk.Services.Airtime(apiClient);
        return airtimeService.listPackages(phone.getPhone());
    }
}

