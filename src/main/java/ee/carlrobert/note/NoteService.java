package ee.carlrobert.note;

import java.util.List;

public interface NoteService {

  ApiNoteDto create(ApiNotePayloadDto noteRequest);

  ApiNoteDto update(Long id, ApiNotePayloadDto noteRequest);

  List<ApiNoteDto> findAll();

  void delete(Long id);
}
