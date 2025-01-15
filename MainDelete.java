import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainDelete {

    public static void main(String[] args) {
        // Open a Hibernate session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            // Start transaction
            transaction = session.beginTransaction();

            // Retrieve the Customer by ID
            Long customerId = 1L; // Replace with the actual ID to delete
            Customer customer = session.get(Customer.class, customerId);

            if (customer != null) {
                // Delete the Customer (Professor will be deleted due to CascadeType.ALL)
                session.remove(customer);
                System.out.println("Customer and associated Professor deleted successfully!");
            } else {
                System.out.println("Customer not found with ID: " + customerId);
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
