package sistemaencuestabackend.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import sistemaencuestabackend.model.brands;
import sistemaencuestabackend.model.feedbackForm;
import sistemaencuestabackend.service.feedbackFormService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class feedbackFormControllerTest {
    private static final brands BRANDS = new brands();
    private static final feedbackForm FEEDBACK_FORM = new feedbackForm();

    private static final List<feedbackForm> FEEDBACK_FORM_LIST = new ArrayList<>();

    private static final HttpStatus CODE_STATUS = HttpStatus.OK;
    private static final HttpStatus CODE_STATUS_CREATED = HttpStatus.CREATED;

    private static final JSONObject JSON_OBJECT = new JSONObject();
    @Mock
    private BindingResult bindingResult;

    @Mock
    private feedbackFormService feedbackFormService;
    @InjectMocks
    private feedbackFormController feedbackFormController;

    @Before
    public void init() throws JSONException {
        MockitoAnnotations.openMocks(this);
        BRANDS.setId(1L);
        BRANDS.setName("lenovo");

        FEEDBACK_FORM.setId(1L);
        FEEDBACK_FORM.setEmail("d@gmail.com");
        FEEDBACK_FORM.setComment("comment prueb");
        FEEDBACK_FORM.setDocumentNumber(12123123);
        FEEDBACK_FORM.setFavoriteBrand(BRANDS);


    }
    @Test
    public void listarTest() {
        Mockito.when(feedbackFormService.findNullDeleted()).thenReturn(FEEDBACK_FORM_LIST);

        final ResponseEntity<?> response = feedbackFormController.getSurvey();
        assertEquals(response.getStatusCode(), CODE_STATUS);
        assertEquals(response.getBody(), FEEDBACK_FORM_LIST);
    }
}
