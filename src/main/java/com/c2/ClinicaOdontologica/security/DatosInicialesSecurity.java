package com.c2.ClinicaOdontologica.security;

import com.c2.ClinicaOdontologica.entity.Usuario;
import com.c2.ClinicaOdontologica.entity.UsuarioRole;
import com.c2.ClinicaOdontologica.repository.UsuarioRepository;
import com.c2.ClinicaOdontologica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatosInicialesSecurity implements ApplicationRunner {
    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        //crear un usuario como si fuese real

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String passwordAdmin = bCryptPasswordEncoder.encode("admin");
        String passwordUser = bCryptPasswordEncoder.encode("user");

        // Usuario ADMIN
        usuarioRepository.save(new Usuario("Administrador", "admin", "admin@clinica.com", passwordAdmin, UsuarioRole.ROLE_ADMIN));

        // Usuario USER
        usuarioRepository.save(new Usuario("Usuario", "user", "user@clinica.com", passwordUser, UsuarioRole.ROLE_USER));

    }
}
