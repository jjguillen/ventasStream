package servicios;

import entidades.Venta;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class ConsultasVenta {

    private List<Venta> ventas;

    public ConsultasVenta(List<Venta> ventas) {
        this.ventas = ventas;
    }


    /**
     * Devuelve las ventas con importe total mayor a 100€
     * @return
     */
    public List<Venta> getVentasMayor100() {
        return ventas.stream()
                .filter(venta -> venta.getTotalLinea() > 100)
                .toList();
    }

    /**
     * Devuelve las ventas de la categoría "Electronics"
     * @return
     */
    public List<Venta> getVentasByCategoriaElectronica() {
        return ventas.stream()
                .filter(v -> v.getCategoria().equals("Electronics"))
                .toList();
    }

    /**
     * Devuelve los productos vendidos ordenados por nombre. Sin repetidos.
     * @return
     */
    public List<String> getProductosVendidosOrder() {
        return ventas.stream()
                .map(Venta::getProducto)
                .distinct()
                .sorted()
                .toList();
    }

    /**
     * Devuelve la primera Venta en España
     * @return Optional<Venta>
     */
    public Optional<Venta> getPrimeraVentaSpain() {
        return ventas.stream()
                .filter(v -> v.getPais().equals("Spain"))
                .findFirst();
    }

    /**
     * Devuelve las 10 ventas con mayor importe total
     * @return
     */
    public List<Venta> getTop10VentasPorImporteTotal() {
        return ventas.stream()
                .sorted(Comparator.comparing(Venta::getTotalLinea).reversed())
                .limit(10)
                .toList();
    }

    /**
     * Devuelve el importe total de las ventas
     * @return
     */
    public double getFacturacionTotal() {
        return ventas.stream()
                .mapToDouble(Venta::getTotalLinea)
                .sum();
    }

    /**
     * Estadísticas de precio unitario
     * @return
     */
    public DoubleSummaryStatistics getEstadisticasPrecioUnitario() {
        //return ventas.stream()
        //        .collect(Collectors.summarizingDouble(Venta::getPrecioUnitario));

        return ventas.stream()
                .mapToDouble(Venta::getPrecioUnitario)
                .summaryStatistics();
    }

    /**
     * Devuelve las ventas agrupadas por categoría contando cuántas hay de cada una
     * @return
     */
    public Map<String, Long> getNumeroVentasPorCategoria() {
        return ventas.stream()
                .collect(Collectors.groupingBy(Venta::getCategoria,
                        Collectors.counting()));
    }

    /**
     * Ventas agrupadas por país. Muestra país y total facturación de ese país
     * @return
     */
    public Map<String, Double> getFacturacionTotalPorPais() {
        return ventas.stream()
                .collect(Collectors.groupingBy(Venta::getPais,
                        Collectors.summingDouble(Venta::getTotalLinea)));
    }

    /**
     * Número de ventas agrupadas por método de pago
     * @return
     */
    public Map<String, Long> getNumeroVentasPorMetodoPago() {
        return ventas.stream()
                .collect(Collectors.groupingBy(Venta::getMetodoPago,
                        Collectors.counting()));
    }




}
