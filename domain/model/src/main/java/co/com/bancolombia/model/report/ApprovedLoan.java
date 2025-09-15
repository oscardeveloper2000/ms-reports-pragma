package co.com.bancolombia.model.report;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class ApprovedLoan {
    private Long requestId;
    private String status;
    private String userClient;
    private String emailClient;
    private BigDecimal amount;
    private List<PaymentPlan> paymentPlan;

}
