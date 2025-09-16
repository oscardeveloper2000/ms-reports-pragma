package co.com.bancolombia.usecase.report;

import co.com.bancolombia.model.report.Report;
import co.com.bancolombia.model.report.commom.LoggerPort;
import co.com.bancolombia.model.report.gateways.ReportRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetReportUseCase implements IGetReportUseCase {
    private final ReportRepository reportRepository;
    private final LoggerPort logger;
    @Override
    public Mono<Report> getReport() {
        return reportRepository.getReport()
                .doOnSubscribe(subscription -> logger.info("Starting getReport"))
                .doOnSuccess(report -> logger.info("Successfully retrieved report: {}", report))
                .doOnError(error -> logger.error("Error retrieving report: {}", error.getMessage(), error));
    }
}
