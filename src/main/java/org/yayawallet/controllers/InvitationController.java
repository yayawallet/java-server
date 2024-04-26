package org.yayawallet.controllers;

import com.yaya.sdk.ApiRequest.ApiClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yayawallet.Model.Invitation;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

@RestController
public class InvitationController {
    @GetMapping("/invitation/find-by-inviter")
    public com.yaya.sdk.Models.Invitation[] findByInviter() throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        com.yaya.sdk.Services.Invitation invitation = new com.yaya.sdk.Services.Invitation(apiClient);
        return invitation.findByInviter();
    }

    @PostMapping("/invitation/create")
    public com.yaya.sdk.Models.Invitation createInvitation(@RequestBody Invitation createInvitation) throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        com.yaya.sdk.Services.Invitation invitation = new com.yaya.sdk.Services.Invitation(apiClient);
        return invitation.createInvitation(createInvitation.getCountry(), createInvitation.getPhone(), createInvitation.getAmount());
    }
}
