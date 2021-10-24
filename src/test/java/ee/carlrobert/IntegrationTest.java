package ee.carlrobert;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import ee.carlrobert.mixin.ApiClientTestMixin;
import ee.carlrobert.mixin.AssertionTestMixin;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = Application.class)
abstract class IntegrationTest implements
    ApiClientTestMixin,
    AssertionTestMixin {
}
