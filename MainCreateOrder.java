import org.hibernate.Session;

public class MainCreateOrder {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Create Order and Products
        Order order = new Order();
        order.setOrderDate("2025-01-15");

        Product product1 = new Product();
        product1.setName("Pizza");
        product1.setPrice(15.0);

        Product product2 = new Product();
        product2.setName("Coke");
        product2.setPrice(2.0);

        order.getProducts().add(product1);
        order.getProducts().add(product2);

        // Save
        session.persist(order);

        session.getTransaction().commit();
        session.close();
    }
}
