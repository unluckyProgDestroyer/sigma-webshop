package hu.sigmalimited.sigmawebshop.controller;

import hu.sigmalimited.sigmawebshop.domain.data.product.Product;
import hu.sigmalimited.sigmawebshop.domain.data.product.ProductRepository;
import hu.sigmalimited.sigmawebshop.feature.file.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

@Controller
public class ProductController {

    private final StorageService storageService;

    private final ProductRepository productRepository;

    public ProductController(StorageService storageService, ProductRepository productRepository) {
        this.storageService = storageService;
        this.productRepository = productRepository;
    }

    @GetMapping(value = "/admin/home")
    public String adminProductsView() {
        return "admin/admin_default";
    }

    @GetMapping(value = "/products/api/v1/all")
    @ResponseBody
    public List<Product> customerProductListView() {
        return productRepository.findAll();
    }

    @GetMapping(value = "/products/api/v1/findById/{id}")
    @ResponseBody
    public Product customerOneProductView(@PathVariable String id) {
        return productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found: "+id));
    }

    @PostMapping(value = "/products")
    //@Secured("ROLE_ADMIN")
    @ResponseBody
    public Product newProduct(@RequestParam(required = false) MultipartFile file, @RequestParam String name,
                             @RequestParam String price, @RequestParam String category){
        Product product = new Product();
        product.setCategory(category);
        product.setName(name);
        product.setPrice(Double.valueOf(price));
        if (file!=null){
            storageService.save(file);
            product.setImageFileName(file.getOriginalFilename());
        }
        return productRepository.save(product);
    }

    @GetMapping( value = "/products/{id}")
    public String oneProductView(@PathVariable String id) {
        return "customer/customer_product";
    }
}
