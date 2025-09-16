package co.com.bancolombia.dynamodb;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.math.BigDecimal;

@DynamoDbBean
public class ReportEntity {
    private Long reportId;
    private String lastUpdated;
    private Integer numberOfLoans;
    private BigDecimal totalAmount;

    public ReportEntity() {
    }
    public ReportEntity(Long reportId, String lastUpdated, Integer numberOfLoans, BigDecimal totalAmount) {
        this.reportId = reportId;
        this.lastUpdated = lastUpdated;
        this.numberOfLoans = numberOfLoans;
        this.totalAmount = totalAmount;
    }

    @DynamoDbPartitionKey
    @DynamoDbAttribute("reportId")
    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    @DynamoDbAttribute("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @DynamoDbAttribute("numberOfLoans")
    public Integer getNumberOfLoans() {
        return numberOfLoans;
    }
    public void setNumberOfLoans(Integer numberOfLoans) {
        this.numberOfLoans = numberOfLoans;
    }

    @DynamoDbAttribute("totalAmount")
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
