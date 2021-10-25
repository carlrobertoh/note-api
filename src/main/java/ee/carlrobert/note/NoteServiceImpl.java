package ee.carlrobert.note;

import static java.util.stream.Collectors.toList;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
class NoteServiceImpl implements NoteService {

  private final NoteRepository noteRepository;

  NoteServiceImpl(NoteRepository noteRepository) {
    this.noteRepository = noteRepository;
  }

  @Override
  public ApiNoteDto create(ApiNotePayloadDto noteRequest, String remoteAddr) {
    Note note = new Note();
    note.setAuthor(noteRequest.getAuthor());
    note.setText(noteRequest.getText());
    note.setRemoteAddr(remoteAddr);
    return mapToApiNoteDto(noteRepository.save(note), remoteAddr);
  }

  @Override
  public ApiNoteDto update(Long id, ApiNotePayloadDto noteRequest) {
    Note note = noteRepository.getOne(id);
    if (noteRequest.getAuthor() != null) {
      note.setAuthor(noteRequest.getAuthor());
    }
    if (noteRequest.getText() != null) {
      note.setText(noteRequest.getText());
    }
    return mapToApiNoteDto(noteRepository.save(note), note.getRemoteAddr());
  }

  @Override
  public List<ApiNoteDto> findAll(String remoteAddr) {
    return noteRepository.findAll().stream()
        .map(note -> mapToApiNoteDto(note, remoteAddr))
        .collect(toList());
  }

  @Override
  public void delete(Long id) {
    noteRepository.deleteById(id);
  }

  private ApiNoteDto mapToApiNoteDto(Note note, String remoteAddr) {
    return new ApiNoteDto(note.getId(), note.getAuthor(), note.getText(), remoteAddr.equals(note.getRemoteAddr()));
  }
}


