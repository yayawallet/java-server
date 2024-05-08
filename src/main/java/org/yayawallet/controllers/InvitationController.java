package org.yayawallet.controllers;

import com.yaya.sdk.ApiRequest.ApiClient;
import org.springframework.web.bind.annotation.*;
import org.yayawallet.Model.Invitation;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/invitation")
public class InvitationController {
    @GetMapping("/find-by-inviter")
    public com.yaya.sdk.Models.Invitation[] findByInviter() throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        com.yaya.sdk.Services.Invitation invitation = new com.yaya.sdk.Services.Invitation(apiClient);
        return invitation.findByInviter();
    }

    @PostMapping("/create")
    public com.yaya.sdk.Models.Invitation createInvitation(@RequestBody Invitation createInvitation) throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        com.yaya.sdk.Services.Invitation invitation = new com.yaya.sdk.Services.Invitation(apiClient);
        return invitation.createInvitation(createInvitation.getCountry(), createInvitation.getPhone(), createInvitation.getAmount());
    }
}
