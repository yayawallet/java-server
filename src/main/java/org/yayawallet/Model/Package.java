package org.yayawallet.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Package {
    private String phone;
    @JsonProperty("package")
    private String packageCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }
}
