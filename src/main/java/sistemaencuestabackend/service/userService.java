package sistemaencuestabackend.service;

import sistemaencuestabackend.model.user;


public interface userService {

    public user saveUser(user usuario) throws Exception;

    public user updateUser(Long id,user usuario) throws Exception;

    public user getUser(String username);

    public void deletedUser(Long usuarioId);
}
