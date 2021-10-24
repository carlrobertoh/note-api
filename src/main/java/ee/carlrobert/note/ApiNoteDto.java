package ee.carlrobert.note;

public class ApiNoteDto {

  private final Long id;
  private final String author;
  private final String text;

  public ApiNoteDto(Long id, String author, String text) {
    this.id = id;
    this.author = author;
    this.text = text;
  }

  public Long getId() {
    return id;
  }

  public String getAuthor() {
    return author;
  }

  public String getText() {
    return text;
  }
}
