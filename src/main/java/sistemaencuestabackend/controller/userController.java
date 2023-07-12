package sistemaencuestabackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistemaencuestabackend.model.user;
import sistemaencuestabackend.service.userService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", maxAge = 3600)
public class userController {

    @Autowired
    userService userServi;

    private Map<String, Object> response = new HashMap<String, Object>();


    @PostMapping("/")
    public ResponseEntity<?> saveUser(@RequestBody user user) throws Exception{
        try {
            response.put("message", "success");
            response.put("status", true);
            response.put("data",userServi.saveUser(user));
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.put("message", ex.getMessage());
            response.put("status", false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id,@RequestBody user user) throws Exception{
        try {
            response.put("message", "success");
            response.put("status", true);
            response.put("data",userServi.updateUser(id,user));
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.put("message", ex.getMessage());
            response.put("status", false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable("username") String username){
        return ResponseEntity.ok().body(userServi.getUser(username));
    }
    @DeleteMapping("/{usuarioId}")
    public void deletedUser(@PathVariable("usuarioId") Long usuarioId){
        userServi.deletedUser(usuarioId);
    }
}
