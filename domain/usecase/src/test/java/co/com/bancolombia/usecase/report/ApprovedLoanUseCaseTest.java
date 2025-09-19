package co.com.bancolombia.usecase.report;

import co.com.bancolombia.model.report.ApprovedLoan;
import co.com.bancolombia.model.report.commom.LoggerPort;
import co.com.bancolombia.model.report.gateways.ApprovedLoanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

class ApprovedLoanUseCaseTest {

    @Mock
    private ApprovedLoanRepository approvedLoanRepository;

    @Mock
    private LoggerPort logger;

    private ApprovedLoanUseCase approvedLoanUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        approvedLoanUseCase = new ApprovedLoanUseCase(approvedLoanRepository, logger);
    }

    @Test
    @DisplayName("Should save approved loan successfully")
    void shouldSaveApprovedLoanSuccessfully() {
        ApprovedLoan approvedLoan = new ApprovedLoan();
        when(approvedLoanRepository.saveApprovedLoan(approvedLoan)).thenReturn(Mono.empty());

        StepVerifier.create(approvedLoanUseCase.apply(approvedLoan))
                .verifyComplete();

        verify(logger).info("Saving approved loan {}", approvedLoan);
        verify(logger).info("Approved loan saved {}", approvedLoan);
        verify(approvedLoanRepository).saveApprovedLoan(approvedLoan);
    }

    @Test
    @DisplayName("Should log error when saving approved loan fails")
    void shouldLogErrorWhenSavingApprovedLoanFails() {
        ApprovedLoan approvedLoan = new ApprovedLoan();
        RuntimeException exception = new RuntimeException("Database error");
        when(approvedLoanRepository.saveApprovedLoan(approvedLoan)).thenReturn(Mono.error(exception));

        StepVerifier.create(approvedLoanUseCase.apply(approvedLoan))
                .verifyError(RuntimeException.class);

        verify(logger).info("Saving approved loan {}", approvedLoan);
        verify(logger).error("Error saving approved loan {}", approvedLoan, exception);
        verify(approvedLoanRepository).saveApprovedLoan(approvedLoan);
    }
}