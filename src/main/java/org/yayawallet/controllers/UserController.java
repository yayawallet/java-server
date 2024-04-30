package org.yayawallet.controllers;
import com.yaya.sdk.ApiRequest.ApiClient;
import com.yaya.sdk.Models.Organization;
import com.yaya.sdk.Models.Profile;
import com.yaya.sdk.Services.Saving;
import com.yaya.sdk.Services.Transfer;
import com.yaya.sdk.Services.User;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

@RestController
public class UserController {
    @GetMapping("/user/profile")
    public com.yaya.sdk.Models.Profile getProfile() throws IOException, NoSuchAlgorithmException, ExecutionException, InvalidKeyException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        User user = new User(apiClient);
        return user.getProfile();
    }

}
