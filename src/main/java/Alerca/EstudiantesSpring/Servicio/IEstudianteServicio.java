package Alerca.EstudiantesSpring.Servicio;

import Alerca.EstudiantesSpring.Modelo.Estudiante;
import java.util.List;

public interface IEstudianteServicio {

    public List<Estudiante> mostrarEstudiantes();

    public Estudiante buscarEstudianteID(Integer idEstudiante);

    public void guardarEstudiante(Estudiante estudiante);

    public void eliminarEstudiante(Estudiante estudiante);

}
