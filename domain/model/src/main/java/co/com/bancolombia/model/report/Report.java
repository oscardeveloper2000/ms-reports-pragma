package co.com.bancolombia.model.report;
import lombok.*;
//import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class Report {
    private Long reportId;
    private String lastUpdated;
    private Integer numberOfLoans;
    private BigDecimal totalAmount;
}
