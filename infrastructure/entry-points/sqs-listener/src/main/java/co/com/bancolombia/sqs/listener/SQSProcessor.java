package co.com.bancolombia.sqs.listener;

import co.com.bancolombia.model.report.ApprovedLoan;
import co.com.bancolombia.model.report.commom.LoggerPort;
import co.com.bancolombia.usecase.report.ISaveApprovedLoanUseCase;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.services.sqs.model.Message;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class SQSProcessor implements Function<Message, Mono<Void>> {
    // private final MyUseCase myUseCase;
    private final ISaveApprovedLoanUseCase approvedLoanUseCase;
    private final LoggerPort logger;
    private static final Gson gson = new Gson();

@Override
public Mono<Void> apply(Message message) {
    logger.info("SQSProcessor - Message received: {}", message.body());
    try {

        String jsonString = gson.fromJson(message.body(), String.class);

        ApprovedLoan approvedLoan = gson.fromJson(jsonString, ApprovedLoan.class);

        logger.info("SQSProcessor - Message mapped: {}", gson.toJson(approvedLoan));
        return approvedLoanUseCase.apply(approvedLoan);
    } catch (Exception e) {
        logger.error("Error processing SQS message: {}", e.getMessage(), e);
        return Mono.error(e);
    }
}
}
