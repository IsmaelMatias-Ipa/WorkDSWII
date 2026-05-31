package cibertec.pe;

import java.util.List;

import jakarta.jws.WebService;

@WebService
public interface IProductoService {
    public List<Producto>   getProductos();
    public Producto         crearProducto(Producto producto);
    public Producto         findProducto(int codigo);
    public String           updateProducto(int codigo, Producto producto);
    public String           deleteProducto(int codigo);
}
