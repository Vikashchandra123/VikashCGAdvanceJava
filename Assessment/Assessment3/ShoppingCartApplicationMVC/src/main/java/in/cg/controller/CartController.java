package in.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import in.cg.service.ProductService;
import in.cg.service.CartService;
import in.cg.model.Product;

@Controller
public class CartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("id") int id, @RequestParam("quantity") int quantity, Model model) {

        Product product = productService.getProductById(id);
        cartService.addToCart(product, quantity);

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("total", cartService.getTotalAmount());
        return "cart";
    }
    @PostMapping("/updateQuantity")
    public String updateQuantity(@RequestParam("id") int id, @RequestParam("quantity") int quantity) {
        cartService.updateQuantity(id, quantity);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("total", cartService.getTotalAmount());
        return "checkout";
    }

    @PostMapping("/processCheckout")
    public String processCheckout() {
        cartService.clearCart();
        return "order-success";
    }
}