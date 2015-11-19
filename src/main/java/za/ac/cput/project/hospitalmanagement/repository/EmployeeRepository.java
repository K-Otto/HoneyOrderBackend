package za.ac.cput.project.hospitalmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.hospitalmanagement.domain.Employee;

/**
 * Created by Ancel on 2015/05/06.
 */
public interface EmployeeRepository extends CrudRepository <Employee, Long>{
    public Employee findByEmployeeID(long employeeID);

}
