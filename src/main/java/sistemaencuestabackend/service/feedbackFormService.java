package sistemaencuestabackend.service;

import sistemaencuestabackend.model.feedbackForm;

import java.util.List;
import java.util.Optional;

public interface feedbackFormService {
    public Optional<feedbackForm> findById(Long id);

    public feedbackForm saveSurvey(feedbackForm formularioComentarios) throws Exception;

    public feedbackForm updateSurvey(Long id,feedbackForm formularioComentarios) throws Exception;

    public void deletedSurvey(Long id);

    public List<feedbackForm> findNullDeleted();
}
