package co.com.bancolombia.api;

import co.com.bancolombia.model.report.commom.LoggerPort;
import co.com.bancolombia.usecase.report.IGetReportUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
private final IGetReportUseCase getReportUseCase;
private  final LoggerPort logger;


    public Mono<ServerResponse> listenGETReport(ServerRequest serverRequest) {
        logger.info("Received GET request{}", serverRequest.uri());
        return getReportUseCase.getReport()
                .flatMap(report -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(report))
                .doOnSubscribe(subscription -> logger.info("Starting listenGETReport"))
                .doOnSuccess(report -> logger.info("Successfully retrieved report: {}", report))
                .doOnError(error -> logger.error("Error retrieving report: {}", error.getMessage(), error));
    }
}
