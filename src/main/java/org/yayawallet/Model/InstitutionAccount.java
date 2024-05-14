package org.yayawallet.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InstitutionAccount {
    @JsonProperty("account_number")
    private String accountNumber;
    @JsonProperty("institution_code")
    private String institutionCode;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }
}
