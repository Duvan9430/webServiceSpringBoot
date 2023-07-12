package sistemaencuestabackend.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import sistemaencuestabackend.model.brands;
import sistemaencuestabackend.model.feedbackForm;
import sistemaencuestabackend.repository.feedbackFormRepository;
import sistemaencuestabackend.service.Impl.feedbackFormServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class feedbackFormServiceTest {

    private static final brands BRANDS = new brands();
    private static final feedbackForm FEEDBACK_FORM = new feedbackForm();
    private static final List<feedbackForm> FEEDBACK_FORM_LIST = new ArrayList<>();
    @Mock
    private feedbackFormRepository feedbackFormRepository;

    @InjectMocks
    private feedbackFormServiceImpl feedbackFormServiceImpl;


    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);

        BRANDS.setId(1L);
        BRANDS.setName("lenovo");

        FEEDBACK_FORM.setId(1L);
        FEEDBACK_FORM.setEmail("d@gmail.com");
        FEEDBACK_FORM.setComment("comment prueb");
        FEEDBACK_FORM.setDocumentNumber(12123123);
        FEEDBACK_FORM.setFavoriteBrand(BRANDS);
        FEEDBACK_FORM_LIST.add(FEEDBACK_FORM);

    }
    @Test
    public void findAllTest() {
        Mockito.when(feedbackFormRepository.findNullEliminar()).thenReturn(FEEDBACK_FORM_LIST);
        feedbackFormServiceImpl.findNullDeleted();
    }
}
