package upb.parcial;

import Reglas.Pelicula;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        // Crear un mapa para almacenar las peliculas por calificacion
        Map<Double, List<Pelicula>> PeliculasMap = new HashMap<>();

        while (true) {
            String menu = """
                          Menú:
                          1. Ver listado de películas con sus IDs y calificaciones
                          2. Agregar una película
                          3. Buscar película por ID
                          4. Buscar película por nombre
                          5. Salir""";

            int opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1 -> {
                    // Ver listado de películas con sus IDs y calificaciones
                    if (PeliculasMap.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay películas registradas.");
                    } else {
                        String peliculasBuilder = "Listado de películas:\n";
                        for (Double calificacion : PeliculasMap.keySet()) {
                            peliculasBuilder += "Calificación: " + calificacion + "\n";
                            for (Pelicula pelicula : PeliculasMap.get(calificacion)) {
                                peliculasBuilder += "ID: " + pelicula.getIdpel() + ", Nombre: " + pelicula.gettitulo() + "\n";
                            }
                        }
                        JOptionPane.showMessageDialog(null, peliculasBuilder);
                    }
                }

                case 2 -> {
                    // Crear una película
                    int idpel = PeliculasMap.size() + 1;
                    String nombrepeliculaString = JOptionPane.showInputDialog("Ingrese el nombre de la película:");
                    double calificacion = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la calificación de la película:"));
                    Pelicula pelicula = new Pelicula(idpel, nombrepeliculaString, 0, calificacion);
                    PeliculasMap.computeIfAbsent(calificacion, k -> new ArrayList<>()).add(pelicula);
                }

                case 3 -> {
                    // Buscar película por ID de película
                    int idPeliculaABuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la película:"));
                    Pelicula peliculaBuscada = null;
                    for (Double calificacion : PeliculasMap.keySet()) {
                        for (Pelicula pelicula : PeliculasMap.get(calificacion)) {
                            if (pelicula.getIdpel() == idPeliculaABuscar) {
                                peliculaBuscada = pelicula;
                                break;
                            }
                        }
                    }
                    if (peliculaBuscada != null) {
                        JOptionPane.showMessageDialog(null, peliculaBuscada.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Película no encontrada.");
                    }
                }

                case 4 -> {
                    // Buscar película por nombre
                    String nombrePeliculaABuscar = JOptionPane.showInputDialog("Ingrese el nombre de la película:");
                    Pelicula peliculaBuscada = null;
                    for (Double calificacion : PeliculasMap.keySet()) {
                        for (Pelicula pelicula : PeliculasMap.get(calificacion)) {
                            if (pelicula.gettitulo().equals(nombrePeliculaABuscar)) {
                                peliculaBuscada = pelicula;
                                break;
                            }
                        }
                    }
                    if (peliculaBuscada != null) {
                        JOptionPane.showMessageDialog(null, peliculaBuscada.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Película no encontrada.");
                    }
                }
 case 6 -> // Salir
                    System.exit(0);

                default -> JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
            }
        }
    }
    }

