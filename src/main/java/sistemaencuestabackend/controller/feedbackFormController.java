package sistemaencuestabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistemaencuestabackend.model.feedbackForm;
import sistemaencuestabackend.model.user;
import sistemaencuestabackend.service.brandsService;
import sistemaencuestabackend.service.feedbackFormService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/surveys")
@CrossOrigin(origins = "*", maxAge = 3600)
public class feedbackFormController {

    @Autowired
    feedbackFormService feedbackFormServi;

    @Autowired
    brandsService brandsServi;

    private Map<String, Object> response = new HashMap<String, Object>();

    @PostMapping("/")
    public ResponseEntity<?> saveSurvey(@RequestBody feedbackForm feedbackForm) throws Exception{
        try {
            response.put("message", "success");
            response.put("status", true);
            response.put("data",feedbackFormServi.saveSurvey(feedbackForm));
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.put("message", ex.getMessage());
            response.put("status", false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateSurvey(@PathVariable("id") Long id,@RequestBody feedbackForm feedbackForm) throws Exception{
        try {
            response.put("message", "success");
            response.put("status", true);
            response.put("data",feedbackFormServi.updateSurvey(id,feedbackForm));
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.put("message", ex.getMessage());
            response.put("status", false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @GetMapping("/")
    public ResponseEntity<?> getSurvey(){
        return ResponseEntity.ok().body(feedbackFormServi.findNullDeleted());
    }
    @GetMapping("/brands/")
    public ResponseEntity<?> getBrands(){
        return ResponseEntity.ok().body(brandsServi.findAll());
    }
    @DeleteMapping("/{id}")
    public void deletedSurvey(@PathVariable("id") Long id){

        feedbackFormServi.deletedSurvey(id);
    }

}
