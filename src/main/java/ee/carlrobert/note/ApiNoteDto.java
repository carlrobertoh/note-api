package ee.carlrobert.note;

public class ApiNoteDto {

  private final Long id;
  private final String author;
  private final String text;
  private final boolean editingAllowed;

  public ApiNoteDto(Long id, String author, String text, boolean editingAllowed) {
    this.id = id;
    this.author = author;
    this.text = text;
    this.editingAllowed = editingAllowed;
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

  public boolean isEditingAllowed() {
    return editingAllowed;
  }
}
