import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainCreateProduct {

    public static void main(String[] args) {
        // Open a Hibernate session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            // Start transaction
            transaction = session.beginTransaction();

            // Create generic Product instances
            Product product1 = new Product();
            product1.setName("Product A");
            product1.setPrice(100.00);

            Product product2 = new Product();
            product2.setName("Product B");
            product2.setPrice(200.00);

            Product product3 = new Product();
            product3.setName("Product C");
            product3.setPrice(300.00);

            // Save products to the database
            session.persist(product1);
            session.persist(product2);
            session.persist(product3);

            // Commit transaction
            transaction.commit();
            System.out.println("Products created successfully!");

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
