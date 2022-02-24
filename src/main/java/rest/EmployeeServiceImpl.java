package rest;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigInteger;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<Employee> hiredEmployees() throws IOException {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Olga");
        employee.setSalary(new BigInteger("5000"));

        return Arrays.asList(employee);
    }

    @Override
    public BigInteger getSalary(Long id) {
        return null;
    }
}
