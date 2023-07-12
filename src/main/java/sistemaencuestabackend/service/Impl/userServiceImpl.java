package sistemaencuestabackend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistemaencuestabackend.model.user;
import sistemaencuestabackend.repository.userRepository;
import sistemaencuestabackend.service.userService;


@Service
public class userServiceImpl implements userService {


    @Autowired
    userRepository userRepo;

    @Override
    public user saveUser(user usuario) throws Exception {
        user usuarioLocal = userRepo.findByUsername(usuario.getUsername());
        if(usuarioLocal != null){
            throw new Exception("The user is ready registered");
        }
        usuario.setBloquing(0);
        usuario.setPassword(usuario.getPassword());
        usuarioLocal = userRepo.save(usuario);
        return usuarioLocal;
    }
    @Override
    public user updateUser(Long id,user usuario) throws Exception {
        if(!userRepo.existsById(id)){
            throw new Exception("The record is not found in the system");
        }
        user usuarioLocal = userRepo.findById(id).get();
        usuario.setBloquing(0);
        usuario.setName(usuario.getName());
        usuario.setLastName(usuario.getLastName());
        usuario.setUsername(usuario.getUsername());
        usuarioLocal = userRepo.save(usuario);
        return usuarioLocal;
    }
    @Override
    public user getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public void deletedUser(Long usuarioId) {
        userRepo.deleteById(usuarioId);
    }
}
