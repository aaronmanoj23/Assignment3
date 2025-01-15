import org.hibernate.Session;

public class MainDeleteOrder {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Delete Order
        Order order = session.get(Order.class, 1L); // Change ID as needed
        if (order != null) {
            session.remove(order);
        }

        session.getTransaction().commit();
        session.close();
    }
}
