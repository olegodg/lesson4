package controllers;

import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.ProductService;


@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping("/products_all")
    public String showProductsAll(Model model) {
        model.addAttribute("products", productService.showProductsAll());
        return "products_all";
    }


    @RequestMapping("/product_show/{id}")
    public String showProductById(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.productById(id));
        return "product_info";
    }

    @RequestMapping("/product_add")
    public String productAdd(Model uiModel) {
        Product product = new Product(null, "", 0.0f);
        uiModel.addAttribute("product", product);
        return "product_add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.productAdd(product);
        return "redirect:/products_all";
    }
}
