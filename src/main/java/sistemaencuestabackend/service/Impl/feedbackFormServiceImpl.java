package sistemaencuestabackend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistemaencuestabackend.model.feedbackForm;
import sistemaencuestabackend.repository.feedbackFormRepository;
import sistemaencuestabackend.service.feedbackFormService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class feedbackFormServiceImpl implements feedbackFormService {

    @Autowired
    feedbackFormRepository feedbackFormRepo;
    @Override
    public Optional<feedbackForm> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public feedbackForm saveSurvey(feedbackForm feedbackForm) throws Exception {

        feedbackForm guardar = new feedbackForm();
        guardar.setDocumentNumber(feedbackForm.getDocumentNumber());
        guardar.setEmail(feedbackForm.getEmail());
        guardar.setComment(feedbackForm.getComment());
        guardar.setFavoriteBrand(feedbackForm.getFavoriteBrand());
        guardar.setDateResponse(Calendar.getInstance().getTime());
        return feedbackFormRepo.save(guardar);
    }

    @Override
    public feedbackForm updateSurvey(Long id, feedbackForm feedbackForm) throws Exception{
        if(!feedbackFormRepo.existsByIdAndDeleted(id,null)){
            throw new Exception("The record is not found in the system");
        }
        feedbackForm actualizarDB = feedbackFormRepo.findById(id).get();
        actualizarDB.setEmail(feedbackForm.getEmail());
        actualizarDB.setDocumentNumber(feedbackForm.getDocumentNumber());
        actualizarDB.setComment(feedbackForm.getComment());
        actualizarDB.setFavoriteBrand(feedbackForm.getFavoriteBrand());
        actualizarDB.setDateResponse(Calendar.getInstance().getTime());
        return feedbackFormRepo.save(actualizarDB);
    }

    @Override
    public void deletedSurvey(Long id) {
        Optional<feedbackForm> eliminarR =feedbackFormRepo.findById(id);
        if(eliminarR.isPresent()){
            feedbackForm detalle = eliminarR.get();
            detalle.setDeleted(new Date());
            this.feedbackFormRepo.save(detalle);
        }
    }

    @Override
    public List<feedbackForm> findNullDeleted() {
        return feedbackFormRepo.findNullEliminar();
    }
}
