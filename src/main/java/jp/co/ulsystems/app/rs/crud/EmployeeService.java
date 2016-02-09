package jp.co.ulsystems.app.rs.crud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;

/**
 * 従業員サービスダミー
 */
@ApplicationScoped
public class EmployeeService {

    private AtomicInteger counter = new AtomicInteger(3);

    private List<Employee> all = 
            Arrays.asList(new Employee(1, "test1", 20), 
                new Employee(2, "test2", 30),
                new Employee(3, "test3", 40));
    
    public List<Employee> findByName(String name) {
        
        if (name == null || name.length() == 0) {
            return all;
        }
        
        return all.stream().filter(
                e -> e.getName().equals(name)).collect(Collectors.toList());
    }
    
    public Employee findById(long id) {
        return all.stream().filter(e -> e.getId() == id)
                .findFirst().orElse(null);
    }
    
    public Employee save(String name, int age) {
        Employee newEmp = new Employee(counter.incrementAndGet(), name, age);
        
        List<Employee> newList = new ArrayList<>(all);
        newList.add(newEmp);
        all = newList;
        return newEmp;
    }
    
    public Employee update(Employee emp) {
        
        for(Employee e : all) {
            if (e.getId() == emp.getId()) {
                e.setName(emp.getName());
                e.setAge(e.getAge());
            }
        }
        return emp;
    }
    
    public void delete(long id) {
        
        all = all.stream().filter(e -> e.getId() != id)
                   .collect(Collectors.toList());
        
    }
    
}
