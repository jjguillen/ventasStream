package servicios;

import entidades.Venta;
import lombok.Data;

import java.util.List;

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



}
