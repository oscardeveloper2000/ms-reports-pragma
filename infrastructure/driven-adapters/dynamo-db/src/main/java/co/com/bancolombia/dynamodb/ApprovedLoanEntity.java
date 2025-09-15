package co.com.bancolombia.dynamodb;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.math.BigDecimal;
import java.util.List;

@DynamoDbBean
public class ApprovedLoanEntity {
    private Long requestId;
    private String status;
    private BigDecimal amount;
    private String userClient;
    private String emailClient;
    private List<PaymentPlanEntity> paymentPlan;

    public ApprovedLoanEntity() {

    }

    public ApprovedLoanEntity(Long requestId, String status, BigDecimal amount, String userClient, String emailClient, List<PaymentPlanEntity> paymentPlan) {
        this.requestId = requestId;
        this.status = status;
        this.amount = amount;
        this.userClient = userClient;
        this.emailClient = emailClient;
        this.paymentPlan = paymentPlan;
    }

    @DynamoDbPartitionKey
    @DynamoDbAttribute("requestId")
    public Long getRequestId() {
        return requestId;
    }

    @DynamoDbAttribute("status")
    public String getStatus() {
        return status;
    }

    @DynamoDbAttribute("amount")
    public BigDecimal getAmount() {
        return amount;
    }

    @DynamoDbAttribute("userClient")
    public String getUserClient() {
        return userClient;
    }

    @DynamoDbAttribute("emailClient")
    public String getEmailClient() {
        return emailClient;
    }

    @DynamoDbAttribute("paymentPlan")
    public List<PaymentPlanEntity> getPaymentPlan() {
        return paymentPlan;
    }


    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setUserClient(String userClient) {
        this.userClient = userClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

public void setPaymentPlan(List<PaymentPlanEntity> paymentPlan) {
    this.paymentPlan = paymentPlan;
}

}
