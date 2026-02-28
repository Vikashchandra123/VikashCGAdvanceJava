package in.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import in.cg.model.Product;

@Service
public class ProductService {

    public List<Product> getAllProducts() {

        List<Product> list = new ArrayList<>();

        list.add(new Product(1, "Laptop", 90000));
        list.add(new Product(2, "Mobile", 60000));
        list.add(new Product(3, "Headphones", 20000));

        return list;
    }

    public Product getProductById(int id) {
    		for (Product product : getAllProducts()) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
    }
}