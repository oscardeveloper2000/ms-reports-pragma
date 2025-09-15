package co.com.bancolombia.model.report;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class PaymentPlan {
    private Integer month;
    private String principalForMonth;
    private BigDecimal principalForMonthNumber;
    private String interestToPay;
    private String capitalPayment;
    private String obligationBalance;
}
