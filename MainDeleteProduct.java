import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainDeleteProduct {

    public static void main(String[] args) {
        // Open a Hibernate session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            // Start transaction
            transaction = session.beginTransaction();

            // Specify the Product ID to delete
            Long productId = 1L; // Replace with the actual product ID you want to delete

            // Retrieve the Product by ID
            Product product = session.get(Product.class, productId);

            if (product != null) {
                // Check if the Product is part of any Order
                if (product.getOrders() == null || product.getOrders().isEmpty()) {
                    // Delete the Product if it is not part of any Order
                    session.remove(product);
                    System.out.println("Product deleted successfully!");
                } else {
                    System.out.println("Cannot delete Product. It is part of one or more orders.");
                }
            } else {
                System.out.println("Product not found with ID: " + productId);
            }

            // Commit transaction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
