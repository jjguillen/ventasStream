package app;

import entidades.Venta;
import servicios.ConsultasVenta;
import utilidades.CsvLoader;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {

    static void main() {

        //Cargar fichero ventas.csv
        List<Venta> ventas = CsvLoader.cargarVentas();
        //ventas.forEach(System.out::println);

        //Crear servicio ConsultasVenta
        ConsultasVenta consVenta = new ConsultasVenta(ventas);

        //Hacer consultas
        IO.println("--- 1. ---> getVentasMayor100");
        //consVenta.getVentasMayor100().stream().forEach(IO::println);

        IO.println("--- 2. ---> getVentasByCategoriaElectronica");
        consVenta.getVentasByCategoriaElectronica().forEach(System.out::println);

        IO.println("--- 3. ---> getProductosVendidosOrder");
        //consVenta.getProductosVendidosOrder().forEach(System.out::println);

        IO.println("--- 4. ---> getPrimeraVentaSpain");
        //consVenta.getPrimeraVentaSpain().ifPresent(System.out::println);

        IO.println("--- 5. ---> getTop10VentasPorImporteTotal()");
        //consVenta.getTop10VentasPorImporteTotal().forEach(System.out::println);

        IO.println("--- 6. ---> getFacturacionTotal()");
        //IO.println(consVenta.getFacturacionTotal());

        IO.println("--- 7. ---> getEstadisticasPrecioUnitario()");
        //IO.println(consVenta.getEstadisticasPrecioUnitario());

        IO.println("--- 8. ---> getNumeroVentasPorCategoria()");
        //consVenta.getNumeroVentasPorCategoria()
        //        .forEach((k,v) -> IO.println(k + ": " + v));

        IO.println("--- 9. ---> getFacturacionTotalPorPais()");
        //consVenta.getFacturacionTotalPorPais()
        //        .forEach((k,v) -> IO.println(k + ": " + v + "€"));

        IO.println("--- 9bis ---> Igual pero con los paises ordenados alfabéticamente");
        //Map<String, Double> facturaTotalPais = consVenta.getFacturacionTotalPorPais();
        //Set<String> paises = facturaTotalPais.keySet();
        //  paises.stream().sorted()
        //        .forEach(p -> IO.println(p + ": " + facturaTotalPais.get(p) + "€"));

        IO.println("--- 10. ---> getNumeroVentasPorMetodoPago()");
        consVenta.getNumeroVentasPorMetodoPago()
                .forEach((k,v) -> IO.println(k + ": " + v));

        IO.println("--- 11. ---> getFacturacionTotalPorCategoria()");
        consVenta.getFacturacionTotalPorCategoria()
                .forEach((k,v) -> IO.println(k + ": " + v + "€"));

        IO.println("--- 12. ---> getVentasAgrupadasPorMes");
        consVenta.getVentasAgrupadasPorMes()
                .forEach((k,v) -> IO.println(k + ": " + v.size() + " ventas"));

        IO.println("--- 14. ---> todasVentasBizumMenor200()");
        IO.println(consVenta.todasVentasBizumMenor200());

        IO.println("--- 15 ---> getPorcentajeVentasTarjeta()");
        IO.println(consVenta.getPorcentajeVentasTarjeta() + "%");

        IO.println("--- 13 ---> getCategoriaMasUnidadesVendidas()");
        consVenta.getCategoriaMasUnidadesVendidas();

    }
}
