package co.com.bancolombia.usecase.report;

import co.com.bancolombia.model.report.ApprovedLoan;
import co.com.bancolombia.model.report.commom.LoggerPort;
import co.com.bancolombia.model.report.gateways.ApprovedLoanRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ApprovedLoanUseCase implements ISaveApprovedLoanUseCase {
    private final ApprovedLoanRepository approvedLoanRepository;
    private final LoggerPort logger;


    @Override
    public Mono<Void> apply(ApprovedLoan approvedLoan) {
        logger.info("Saving approved loan {}", approvedLoan);
        return approvedLoanRepository.saveApprovedLoan(approvedLoan)
                .doOnSuccess(v -> logger.info("Approved loan saved {}", approvedLoan))
                .doOnError(e -> logger.error("Error saving approved loan {}", approvedLoan, e));
    }
}
