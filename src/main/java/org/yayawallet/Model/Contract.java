package org.yayawallet.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contract {
    @JsonProperty("contract_number")
    private String contractNumber;
    @JsonProperty("service_type")
    private String serviceType;
    @JsonProperty("customer_account_name")
    private String customerAccountName;
    @JsonProperty("meta_data")
    private String metaData;

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getCustomerAccountName() {
        return customerAccountName;
    }

    public void setCustomerAccountName(String customerAccountName) {
        this.customerAccountName = customerAccountName;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }
}
