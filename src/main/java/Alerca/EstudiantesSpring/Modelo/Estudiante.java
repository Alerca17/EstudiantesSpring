package Alerca.EstudiantesSpring.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data //Metodos Get y Set Automaticos
@NoArgsConstructor //Constructor Vacio Automatico
@AllArgsConstructor //Constructor Con Todos Los Elementos Automatico
@ToString
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstudiante;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
}
