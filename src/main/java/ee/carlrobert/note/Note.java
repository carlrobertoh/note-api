package ee.carlrobert.note;

import javax.persistence.Column;
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
  @Column(name = "REMOTE_ADDR")
  private String remoteAddr;

  Long getId() {
    return id;
  }

  void setId(Long id) {
    this.id = id;
  }

  String getAuthor() {
    return author;
  }

  void setAuthor(String author) {
    this.author = author;
  }

  String getText() {
    return text;
  }

  void setText(String text) {
    this.text = text;
  }

  String getRemoteAddr() {
    return remoteAddr;
  }

  void setRemoteAddr(String remoteAddr) {
    this.remoteAddr = remoteAddr;
  }
}
