package ee.carlrobert;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.tuple;

import org.junit.jupiter.api.Test;

class NoteIntegrationTest extends IntegrationTest {

  @Test
  void shouldCreateNote() {
    post("/v1/note",
        entry("author", "NOTE_AUTHOR"),
        entry("text", "NOTE_TEXT"));

    var response = get("/v1/note");

    assertJsonArray(response)
        .extracting("author", "text", "editingAllowed")
        .containsExactly(tuple("NOTE_AUTHOR", "NOTE_TEXT", true));
  }
}
