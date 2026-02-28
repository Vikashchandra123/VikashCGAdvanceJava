package in.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import in.cg.model.CartItem;
import in.cg.model.Product;

@Service
public class CartService {

    private List<CartItem> cartItems = new ArrayList<>();

    public void addToCart(Product product, int quantity) {

        for (CartItem item : cartItems) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        cartItems.add(new CartItem(product, quantity));
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public double getTotalAmount() {
    	double total = 0;
		for (CartItem item : cartItems) {
			total += item.getTotal();
		}
		return total;
    }
    public void updateQuantity(int productId, int quantity) {
        if (quantity <= 0) {
            cartItems.removeIf(item -> item.getProduct().getId() == productId);
        } else {
            for (CartItem item : cartItems) {
                if (item.getProduct().getId() == productId) {
                    item.setQuantity(quantity);
                    break;
                }
            }
        }
    }

    public void clearCart() {
        cartItems.clear();
    }
}