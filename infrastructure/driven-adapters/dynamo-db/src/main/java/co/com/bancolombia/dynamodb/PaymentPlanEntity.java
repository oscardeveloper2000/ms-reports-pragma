package co.com.bancolombia.dynamodb;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.math.BigDecimal;

@DynamoDbBean
public class PaymentPlanEntity {
    private Integer month; 
    private String principalForMonth;
    private BigDecimal principalForMonthNumber;
    private String interestToPay;
    private String capitalPayment;
    private String obligationBalance;

    public PaymentPlanEntity() {
    }

    public PaymentPlanEntity(
            Integer month,
            String principalForMonth,
            BigDecimal principalForMonthNumber,
            String interestToPay,
            String capitalPayment,
            String obligationBalance
    ) {
        this.month = month;
        this.principalForMonth = principalForMonth;
        this.principalForMonthNumber = principalForMonthNumber;
        this.interestToPay = interestToPay;
        this.capitalPayment = capitalPayment;
        this.obligationBalance = obligationBalance;
    }

    @DynamoDbAttribute("month")
    public Integer getMonth() {
        return month;
    }
    @DynamoDbAttribute("principalForMonth")
    public String getPrincipalForMonth() {
        return principalForMonth;
    }
    @DynamoDbAttribute("principalForMonthNumber")
    public BigDecimal getPrincipalForMonthNumber() {
        return principalForMonthNumber;
    }
    @DynamoDbAttribute("interestToPay")
    public String getInterestToPay() {
        return interestToPay;
    }
    @DynamoDbAttribute("capitalPayment")
    public String getCapitalPayment() {
        return capitalPayment;
    }
    @DynamoDbAttribute("obligationBalance")
    public String getObligationBalance() {
        return obligationBalance;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public void setPrincipalForMonth(String principalForMonth) {
        this.principalForMonth = principalForMonth;
    }

    public void setPrincipalForMonthNumber(BigDecimal principalForMonthNumber) {
        this.principalForMonthNumber = principalForMonthNumber;
    }

    public void setInterestToPay(String interestToPay) {
        this.interestToPay = interestToPay;
    }

    public void setCapitalPayment(String capitalPayment) {
        this.capitalPayment = capitalPayment;
    }

    public void setObligationBalance(String obligationBalance) {
        this.obligationBalance = obligationBalance;
    }
}
