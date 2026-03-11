// Custom Exception
class OutOfStockException extends Exception {
    OutOfStockException(String message) {
        super(message);
    }
}

// Product class
class Product {
    String productName;
    int stockQuantity;

    Product(String productName, int stockQuantity) {
        this.productName = productName;
        this.stockQuantity = stockQuantity;
    }

    void purchase(int quantity) throws OutOfStockException {

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        if (quantity > stockQuantity) {
            throw new OutOfStockException("Product is out of stock");
        }

        stockQuantity -= quantity;
        System.out.println("Purchase successful. Remaining stock: " + stockQuantity);
    }
}

// Main class
public class ProductTest {
    public static void main(String[] args) {

        Product p = new Product("Laptop", 10);

        try {
            p.purchase(5);   // valid purchase
            p.purchase(20);  // triggers OutOfStockException
        } 
        catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        } 
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}