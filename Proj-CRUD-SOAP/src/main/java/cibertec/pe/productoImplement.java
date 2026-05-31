package cibertec.pe;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.jws.WebService;

@WebService
@Component
public class productoImplement implements IProductoService{

    
    private final IProductRepository proRepo;

    public productoImplement (IProductRepository proRepo){
        this.proRepo = proRepo;
    }


    @Override
    public List<Producto> getProductos() {
        return proRepo.findAll();
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return proRepo.save(producto);
    }

    @Override
    public Producto findProducto(int codigo) {
        return proRepo.findById(codigo).orElse(null);
    }

    @Override
    public String updateProducto(int codigo, Producto producto) {
        Producto prod = proRepo.findById(codigo).get();
        if (prod != null) {
            prod.setNombre(producto.getNombre());
            prod.setPrecio(producto.getPrecio());
            prod.setCantidad(producto.getCantidad());
            
            proRepo.save(prod);
            return "Producto Actualizado";
        }else return "Error";
    }

    @Override
    public String deleteProducto(int codigo) {
        if (proRepo.existsById(codigo)) {
            proRepo.deleteById(codigo);
            return "Producto Eliminado";
        }else return "producto no encontrado";
    }
    
}
