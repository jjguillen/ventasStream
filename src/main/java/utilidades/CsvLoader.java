package utilidades;

import entidades.Venta;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CsvLoader {

    public static List<Venta> cargarVentas(String rutaFichero) {

        Path ruta = Paths.get("src/main/resources/ventas.csv");
        List<Venta> ventas = null;

        try {
            List<String> filas = Files.readAllLines(ruta);




        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
