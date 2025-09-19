package co.com.bancolombia.usecase.report;

import co.com.bancolombia.model.report.Report;
import co.com.bancolombia.model.report.commom.LoggerPort;
import co.com.bancolombia.model.report.gateways.ReportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

class GetReportUseCaseTest {

    @Mock
    private ReportRepository reportRepository;

    @Mock
    private LoggerPort logger;

    private GetReportUseCase getReportUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        getReportUseCase = new GetReportUseCase(reportRepository, logger);
    }

    @Test
    @DisplayName("Should retrieve report successfully")
    void shouldRetrieveReportSuccessfully() {
        Report report = new Report();
        when(reportRepository.getReport()).thenReturn(Mono.just(report));

        StepVerifier.create(getReportUseCase.getReport())
                .expectNext(report)
                .verifyComplete();

        verify(logger).info("Starting getReport");
        verify(logger).info("Successfully retrieved report: {}", report);
        verify(reportRepository).getReport();
    }

    @Test
    @DisplayName("Should log error when retrieving report fails")
    void shouldLogErrorWhenRetrievingReportFails() {
        RuntimeException exception = new RuntimeException("Database error");
        when(reportRepository.getReport()).thenReturn(Mono.error(exception));

        StepVerifier.create(getReportUseCase.getReport())
                .verifyError(RuntimeException.class);

        verify(logger).info("Starting getReport");
        verify(logger).error("Error retrieving report: {}", exception.getMessage(), exception);
        verify(reportRepository).getReport();
    }

    @Test
    @DisplayName("Should handle empty report response")
    void shouldHandleEmptyReportResponse() {
        when(reportRepository.getReport()).thenReturn(Mono.empty());

        StepVerifier.create(getReportUseCase.getReport())
                .verifyComplete();

        verify(logger).info("Starting getReport");
        verify(logger).info("Successfully retrieved report: {}", null);
        verify(reportRepository).getReport();
    }
}