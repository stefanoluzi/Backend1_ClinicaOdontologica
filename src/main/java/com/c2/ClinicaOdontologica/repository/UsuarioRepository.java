package com.c2.ClinicaOdontologica.repository;

import com.c2.ClinicaOdontologica.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

Optional<Usuario> findByEmail(String correo);
}
