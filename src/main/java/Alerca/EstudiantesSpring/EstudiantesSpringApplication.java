package Alerca.EstudiantesSpring;

import Alerca.EstudiantesSpring.Modelo.Estudiante;
import Alerca.EstudiantesSpring.Servicio.EstudianteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EstudiantesSpringApplication implements CommandLineRunner {

    @Autowired
    private EstudianteServicio estudianteServicio;
    private static final Logger logger = LoggerFactory.getLogger(EstudiantesSpringApplication.class);
    String ln = System.lineSeparator();
    public Scanner leer = new Scanner(System.in);

    Integer idEstudiante;
    String nombre, apellido, telefono, correo;

    public static void main(String[] args) {

        logger.info("*** Inicio De Aplicacion ***");
        SpringApplication.run(EstudiantesSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info(ln + "*** Ejecutando App ***" + ln);
        menuPrincipal();
    }

    public void menuPrincipal() {

        int opc;

        logger.info("""
                *** Menu Principal ***
                1).Mostrar Estudiantes
                2).Agregar Estudiante
                3).Buscar Estudiante
                4).Modificar Estudiante
                5).Eliminar Estudiante
                6).Salir
                """);
        logger.info("Ingrese Una Opcion: ");
        opc = leer.nextInt();
        leer.nextLine();
        logger.info(ln);

        switch (opc) {
            case 1:
                menuMostrarEstudiantes();
                menuPrincipal();
                logger.info(ln);
                break;

            case 2:
                menuAgregarEstudiante();
                logger.info(ln);
                menuPrincipal();
                break;

            case 3:
                menuBuscarEstudiante();
                logger.info(ln);
                menuPrincipal();
                break;

            case 4:
                menuModificarEstudiante();
                logger.info(ln);
                menuPrincipal();
                break;

            case 5:
                menuEliminarEstudiante();
                logger.info(ln);
                menuPrincipal();
                break;

            case 6:
                System.exit(0);
                break;

            default:
                System.out.println("Opcion No Valida");
                logger.info(ln);
                menuPrincipal();
        }
    }

    public void menuMostrarEstudiantes() {

        List<Estudiante> estudiantes = estudianteServicio.mostrarEstudiantes();
        logger.info("*** Listado De Estudiantes ***" + ln);
        estudiantes.forEach(estudiante -> logger.info(estudiante.toString() + ln));
        logger.info(ln);
    }

    public void menuBuscarEstudiante() {

        logger.info("Ingrese El ID: ");
        idEstudiante = Integer.parseInt(leer.nextLine());
        logger.info(ln);

        Estudiante estudiante = estudianteServicio.buscarEstudianteID(idEstudiante);

        if (estudiante != null) {

            logger.info("El Estudiante Se Encuentra En La Base De Datos" + ln + ln + estudiante);

        } else {

            logger.info("El Estudiante Con El ID " + idEstudiante + " No Existe En La Base De Datos");
        }
        logger.info(ln);
    }

    public void menuAgregarEstudiante() {

        logger.info("Ingrese Nombre: ");
        nombre = leer.nextLine();
        logger.info("Ingrese Apellido: ");
        apellido = leer.nextLine();
        logger.info("Ingrese Telefono: ");
        telefono = leer.nextLine();
        logger.info("Ingrese Correo: ");
        correo = leer.nextLine();
        logger.info(ln);

        Estudiante estudianteNuevo = new Estudiante();
        estudianteNuevo.setNombre(nombre);
        estudianteNuevo.setApellido(apellido);
        estudianteNuevo.setTelefono(telefono);
        estudianteNuevo.setCorreo(correo);

        estudianteServicio.guardarEstudiante(estudianteNuevo);
        logger.info("Estudiante Agregado Exitosamente" + ln);
        logger.info(ln);
    }

    public void menuModificarEstudiante() {

        logger.info("Ingrese El ID: ");
        idEstudiante = Integer.parseInt(leer.nextLine());

        Estudiante estudianteModificar = estudianteServicio.buscarEstudianteID(idEstudiante);

        if (estudianteModificar != null) {

            logger.info("Ingrese Nombre: ");
            nombre = leer.nextLine();
            logger.info("Ingrese Apellido: ");
            apellido = leer.nextLine();
            logger.info("Ingrese Telefono: ");
            telefono = leer.nextLine();
            logger.info("Ingrese Correo: ");
            correo = leer.nextLine();
            logger.info(ln);

            estudianteModificar.setNombre(nombre);
            estudianteModificar.setApellido(apellido);
            estudianteModificar.setTelefono(telefono);
            estudianteModificar.setCorreo(correo);
            estudianteServicio.guardarEstudiante(estudianteModificar);

            logger.info("Estudiante Modificado Exitosamente");

        } else {

            logger.info("Estudiante No Existe En La Base De Datos");
        }
        logger.info(ln);
    }

    public void menuEliminarEstudiante() {

        logger.info("Ingrese El ID: ");
        idEstudiante = Integer.parseInt(leer.nextLine());

        Estudiante estudianteEliminar = estudianteServicio.buscarEstudianteID(idEstudiante);

        if (estudianteEliminar != null) {

            estudianteServicio.eliminarEstudiante(estudianteEliminar);
            logger.info("Estudiante Eliminado Exitosamente");

        } else {

            logger.info("Estudiante No Existe En La Base De Datos");
        }
        logger.info(ln);
    }
}
