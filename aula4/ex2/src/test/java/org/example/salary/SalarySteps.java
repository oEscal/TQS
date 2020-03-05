package org.example.salary;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import salary.Employee;
import salary.SalaryManager;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SalarySteps {

    private SalaryManager salary_manager;

    @Given("the salary management system is initialized with the following data")
    public void the_salary_management_system_is_initialized_with_the_following_data(io.cucumber.datatable.DataTable dataTable) {
        List<Employee> employees = new ArrayList<>();
        for (int position = 1; position < dataTable.height(); position++){
            List<String> current_employee = dataTable.row(position);
            employees.add(new Employee(
                    Integer.parseInt(current_employee.get(0)), current_employee.get(1), Float.parseFloat(current_employee.get(2))
            ));
        }

        salary_manager = new SalaryManager(employees);
    }

    @When("the boss increases the salary for the employee with id '{int}' by {int}%")
    public void the_boss_increases_the_salary_for_the_employee_with_id_by(Integer id, Integer percent) {
        salary_manager.increaseSalary(id, percent);
    }

    @Then("the payroll for the employee with id '{int}' should display a salary of {float}")
    public void the_payroll_for_the_employee_with_id_should_display_a_salary_of(Integer id, Float expected_salary) {
        assertEquals(expected_salary.floatValue(), salary_manager.getPayroll(id).getSalary(), 0);
    }
}
