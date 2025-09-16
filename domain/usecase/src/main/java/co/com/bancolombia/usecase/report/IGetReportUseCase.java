package co.com.bancolombia.usecase.report;

import co.com.bancolombia.model.report.Report;
import reactor.core.publisher.Mono;

public interface IGetReportUseCase {
    Mono<Report> getReport();
}
