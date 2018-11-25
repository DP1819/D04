
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c join c.fixupTasks f group by c.id order by sum(f.complaints.size) desc")
	Collection<Customer> getTop3CustomerWithMoreComplaints();

	@Query("select c from Customer c join c.fixupTasks t group by c having   c.fixupTasks.size >= ( select avg(c1.fixupTasks.size) from Customer c1) order by t.applications.size")
	Collection<Customer> ListOfMorePublishingCustomers();

}
