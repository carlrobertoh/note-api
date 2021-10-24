package ee.carlrobert.note;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class Note {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String author;
  private String text;

  void setId(Long id) {
    this.id = id;
  }

  Long getId() {
    return id;
  }

  void setAuthor(String author) {
    this.author = author;
  }

  String getAuthor() {
    return author;
  }

  void setText(String text) {
    this.text = text;
  }

  String getText() {
    return text;
  }
}
