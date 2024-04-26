package org.yayawallet.controllers;

import com.yaya.sdk.ApiRequest.ApiClient;
import com.yaya.sdk.Services.Airtime;
import com.yaya.sdk.Services.Institution;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yayawallet.Model.Country;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

@RestController
public class InstitutionController {
    @PostMapping("/financial-institution/list")
    public com.yaya.sdk.Models.Institution[] listInstitution(@RequestBody Country listInstitution) throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        Institution institution = new Institution(apiClient);
        return institution.listInstitution(listInstitution.getCountry());
    }
}
