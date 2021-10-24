package ee.carlrobert.web;

import ee.carlrobert.note.ApiNoteDto;
import ee.carlrobert.note.ApiNotePayloadDto;
import ee.carlrobert.note.NoteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/note")
@Tag(name = "Note")
class NoteController {

  private final NoteService noteService;

  NoteController(NoteService noteService) {
    this.noteService = noteService;
  }

  @GetMapping
  public ResponseEntity<List<ApiNoteDto>> findAll() {
    return new ResponseEntity<>(noteService.findAll(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ApiNoteDto> createNote(@RequestBody ApiNotePayloadDto noteRequest) {
    return new ResponseEntity<>(noteService.create(noteRequest), HttpStatus.CREATED);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<ApiNoteDto> updateNote(@PathVariable Long id,
                                               @RequestBody ApiNotePayloadDto noteRequest) {
    return new ResponseEntity<>(noteService.update(id, noteRequest), HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity deleteNote(@PathVariable Long id) {
    noteService.delete(id);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }
}
