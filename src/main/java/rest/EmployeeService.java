package rest;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public interface EmployeeService {
    List<Employee> hiredEmployees() throws IOException;
    BigInteger getSalary(Long id);
}
