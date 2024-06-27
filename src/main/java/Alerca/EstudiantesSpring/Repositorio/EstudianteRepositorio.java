package Alerca.EstudiantesSpring.Repositorio;

import Alerca.EstudiantesSpring.Modelo.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Integer> {


}
