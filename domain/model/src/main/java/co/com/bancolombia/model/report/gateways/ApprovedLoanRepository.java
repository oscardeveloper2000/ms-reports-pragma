package co.com.bancolombia.model.report.gateways;

import co.com.bancolombia.model.report.ApprovedLoan;
import reactor.core.publisher.Mono;

public interface ApprovedLoanRepository {
    Mono<Void> saveApprovedLoan(ApprovedLoan approvedLoan);
}
