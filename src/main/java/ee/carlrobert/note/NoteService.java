package ee.carlrobert.note;

import java.util.List;

public interface NoteService {

  ApiNoteDto create(ApiNotePayloadDto noteRequest, String remoteAddr);

  ApiNoteDto update(Long id, ApiNotePayloadDto noteRequest);

  List<ApiNoteDto> findAll(String remoteAddr);

  void delete(Long id);
}
