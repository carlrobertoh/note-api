package ee.carlrobert.mixin;

import org.assertj.core.api.ListAssert;
import org.assertj.core.api.MapAssert;
import org.springframework.boot.test.json.JsonContentAssert;

public interface AssertionTestMixin {

  default <K, V> MapAssert<K, V> assertJsonMap(String json) {
    return jsonContentAssert(json).extractingJsonPathMapValue("$");
  }

  default <E> ListAssert<E> assertJsonArray(String json) {
    return jsonContentAssert(json).extractingJsonPathArrayValue("$");
  }

  default JsonContentAssert jsonContentAssert(String json) {
    return new JsonContentAssert(getClass(), json);
  }
}
