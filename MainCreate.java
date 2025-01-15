import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainCreate {

    public static void main(String[] args) {
        // Open a Hibernate session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            // Start transaction
            transaction = session.beginTransaction();

            // Create Customer and Professor
            Customer customer = new Customer();
            customer.setName("John Doe");

            Professor professor = new Professor();
            professor.setDepartment("Computer Science");

            // Link Customer to Professor
            customer.setProfessor(professor);

            // Save Customer (Professor will be saved due to CascadeType.ALL)
            session.persist(customer);

            // Commit transaction
            transaction.commit();
            System.out.println("Customer and Professor created successfully!");

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
