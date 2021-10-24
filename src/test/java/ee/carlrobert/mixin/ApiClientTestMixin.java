package ee.carlrobert.mixin;

import static ee.carlrobert.mixin.ApiClientTestMixin.Private.testRestTemplate;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

public interface ApiClientTestMixin {

  class Private {
    static TestRestTemplate testRestTemplate;
  }

  @Autowired
  default void setDependencies(TestRestTemplate testRestTemplate) {
    Private.testRestTemplate = testRestTemplate;
  }

  default String get(String url) {
    return testRestTemplate.getForEntity(url, String.class).getBody();
  }

  default String post(String url, Map.Entry<?, ?>... jsonEntries) {
    return testRestTemplate.postForEntity(url, Map.ofEntries(jsonEntries), String.class).getBody();
  }
}
