package rest;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Employee {
    private String name;
    private Long id;
    private BigInteger salary;
}
