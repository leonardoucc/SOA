package org.soa.services;

import org.soa.models.Usuario;
import org.soa.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registerUser(Usuario user) {
        // Implementa la lógica para registrar al usuario (asegúrate de encriptar la contraseña)
        if(!userExists(user.getCorreoUsuario())) {
            return usuarioRepository.save(user);
        }
        return null;
    }

    public Usuario loginUser(String correoUsuario, String password) {
        // Busca el usuario por correo
        Usuario user = usuarioRepository.findByEmail(correoUsuario);

        // Aquí debes implementar la lógica de validación del password, por ejemplo:
        if (user != null && user.getPassword().equals(password)) {
            return user;  // Login exitoso
        }
        return null;  // Credenciales inválidas
    }

    // Método para verificar si un usuario ya existe
    public boolean userExists(String correoUsuario) {
        return usuarioRepository.findByEmail(correoUsuario) != null;
    }
}
