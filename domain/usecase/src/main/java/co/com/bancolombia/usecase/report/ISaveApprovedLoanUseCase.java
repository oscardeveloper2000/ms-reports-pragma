package co.com.bancolombia.usecase.report;

import co.com.bancolombia.model.report.ApprovedLoan;
import reactor.core.publisher.Mono;

public interface ISaveApprovedLoanUseCase {
    Mono<Void> apply(ApprovedLoan approvedLoan);
}
