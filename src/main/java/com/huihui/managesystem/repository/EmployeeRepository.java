package com.huihui.managesystem.repository;

import com.huihui.managesystem.entity.EmployeeEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;


public interface EmployeeRepository extends ListCrudRepository<EmployeeEntity, Long> {

    EmployeeEntity getEmployeeEntityById(Long employeeID);
    EmployeeEntity getEmployeeEntityByEmail(String email);
    @Modifying
    @Query("UPDATE employees SET email = :email, first_name = :firstName, last_name = :lastName, role = :role WHERE id = :employeeId")
    void updateNameByEmail(Long employeeId, String email, String firstName, String lastName, String role);
}
