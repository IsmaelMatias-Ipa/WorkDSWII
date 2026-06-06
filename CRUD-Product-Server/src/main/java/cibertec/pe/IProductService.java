package cibertec.pe;

import java.util.List;

import jakarta.jws.WebService;

@WebService
public interface IProductService {
    
    public List<Product>        getAllProduct();
    public Product              creaProduct(Product product);
    public Product              findByProduct(int codigo);
    public String               updateProduct(int codigo, Product product);
    public String               deleteProduct(int codigo);

}
