package co.com.bancolombia.usecase.report;

import co.com.bancolombia.model.report.ApprovedLoan;
import reactor.core.publisher.Mono;

public interface SaveApprovedLoan {
    Mono<Void> apply(ApprovedLoan approvedLoan);
}
