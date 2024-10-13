package com.example.soapserver.webservice;

import com.example.soapserver.models.Product;
import com.example.soapserver.repository.ProductRepository;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@WebService(serviceName = "ProductWS")
public class ProductWebService  {

    @Autowired
    private ProductRepository productRepository;


/*
    @WebMethod(operationName = "sellingPrice")
    public Double sellingPrice(@WebParam(name = "Price") Double price){
        return price*1.5;
    }
    @WebMethod
    public Product getProduct(Integer code){
        return new Product(code, "table",300.00, new Date());
    }
    @WebMethod
    public List<Product> productList(){
        return List.of(
                new Product(1,"table",310.00,new Date()),
                new Product(2,"pen",3.00,new Date()),
                new Product(3,"cheese",30.00,new Date()),
                new Product(4,"bread",6.00,new Date())
                );
    }
    */

    ////////////////////////////////////////////////
    ///CRUD//////

    // Create
    @WebMethod(operationName = "createProduct")
    public Product createProduct(
            @WebParam(name = "code") Integer code,
            @WebParam(name = "name") String name,
            @WebParam(name = "price") Double price) {
        Product product = new Product(code, name, price, new Date());
        return productRepository.save(product); // Save to database
    }

    // Read (Find by ID)
    @WebMethod(operationName = "getProductById")
    public Product getProductById(@WebParam(name = "code") Integer code) {
        Optional<Product> product = productRepository.findById(code);
        return product.orElse(null); // Return product if found, else null
    }

    // Update
    @WebMethod(operationName = "updateProduct")
    public Product updateProduct(
            @WebParam(name = "code") Integer code,
            @WebParam(name = "name") String name,
            @WebParam(name = "price") Double price) {
        Optional<Product> productOptional = productRepository.findById(code);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(name);
            product.setPrice(price);
            product.setDate(new Date());
            return productRepository.save(product); // Save updated product
        }
        return null; // Return null if product not found
    }

    // Delete
    @WebMethod(operationName = "deleteProduct")
    public String deleteProduct(@WebParam(name = "code") Integer code) {
        Optional<Product> product = productRepository.findById(code);
        if (product.isPresent()) {
            productRepository.deleteById(code); // Delete from database
            return "Product deleted successfully.";
        }
        return "Product not found.";
    }

    // Get all products
    @WebMethod(operationName = "listProducts")
    public List<Product> listProducts() {
        return (List<Product>) productRepository.findAll(); // Return all products
    }
}
