package cibertec.pe;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.jws.WebService;


@WebService
@Component
public class ProductImplement implements IProductService{


    private final IProductoRepository proRep;

    public ProductImplement(IProductoRepository proRep){
        this.proRep = proRep;
    }

    @Override
    public List<Product> getAllProduct() {
        return proRep.findAll();
    }

    @Override
    public Product creaProduct(Product product) {
        return proRep.save(product);
    }

    @Override
    public Product findByProduct(int codigo) {
        return proRep.findById(codigo).orElse(null);
    }

    @Override
    public String updateProduct(int codigo, Product product) {
        Product prod = proRep.findById(codigo).get();
        if (prod != null) {
            prod.setNombre(product.getNombre());
            prod.setPrecio(product.getPrecio());
            prod.setCantidad(product.getCantidad());

            proRep.save(prod);
            return "Producto actualizado con exito";

        }
        return "Producto no encontrado mrd";
    }

    @Override
    public String deleteProduct(int codigo) {
        if (proRep.existsById(codigo)) {
            proRep.deleteById(codigo);
            return "Producto eliminado con exito";
        }else return "Producto no encontrado";
    }
    

}
