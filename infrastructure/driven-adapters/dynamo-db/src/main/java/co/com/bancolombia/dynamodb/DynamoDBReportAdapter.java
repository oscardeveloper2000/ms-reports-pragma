package co.com.bancolombia.dynamodb;

import co.com.bancolombia.dynamodb.helper.TemplateAdapterOperations;
import co.com.bancolombia.model.report.Report;
import co.com.bancolombia.model.report.gateways.ReportRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

import java.util.List;

@Repository
public class DynamoDBReportAdapter extends TemplateAdapterOperations<Report, Long, ReportEntity>
  implements ReportRepository {

  public DynamoDBReportAdapter(DynamoDbEnhancedAsyncClient connectionFactory, ObjectMapper mapper) {
    super(connectionFactory, mapper, d -> mapper.map(d, Report.class), "resume-reports");
  }

  public Mono<List<Report>> getEntityBySomeKeys(String partitionKey, String sortKey) {
    QueryEnhancedRequest queryExpression = generateQueryExpression(partitionKey, sortKey);
    return query(queryExpression);
  }

  public Mono<List<Report>> getEntityBySomeKeysByIndex(String partitionKey, String sortKey) {
    QueryEnhancedRequest queryExpression = generateQueryExpression(partitionKey, sortKey);
    return queryByIndex(queryExpression);
  }

  private QueryEnhancedRequest generateQueryExpression(String partitionKey, String sortKey) {
    return QueryEnhancedRequest
      .builder()
      .queryConditional(QueryConditional.keyEqualTo(Key.builder().partitionValue(partitionKey).build()))
      .queryConditional(QueryConditional.sortGreaterThanOrEqualTo(Key.builder().sortValue(sortKey).build()))
      .build();
  }

@Override
public Mono<Report> getReport() {
    QueryEnhancedRequest queryExpression = QueryEnhancedRequest
      .builder()
      .queryConditional(QueryConditional.keyEqualTo(Key.builder().partitionValue(1L).build()))
      .build();
    return query(queryExpression)
            .doOnNext(reports -> {
                if (!reports.isEmpty()) {
                    System.out.println("Raw ReportEntity: " + reports.get(0));
                }
            })
            .map(reports -> reports.isEmpty() ? null : reports.get(0))
            .doOnNext(report -> System.out.println("Mapped Report: " + report));
}
}