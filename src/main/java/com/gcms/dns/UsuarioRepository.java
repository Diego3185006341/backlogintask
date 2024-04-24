package com.gcms.dns;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 * Repositorio Spring Data JPA para la entidad Usuario.
 * Este repositorio facilita la implementación de operaciones de base de datos
 * para los usuarios, proporcionando métodos CRUD automáticos y consultas personalizadas.
 *
 * @Repository Anota la interfaz como un componente de repositorio en el contexto de Spring,
 *             lo que facilita la integración y el manejo adecuado de excepciones de la base de datos.
 */
@Repository
@EnableJpaRepositories
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findOneByEmailAndPassword(String email, String password);}