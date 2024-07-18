public class BasePlusCommissionEmployeeTest {
    public static void main(String[] args) {
        // create BasePlusCommissionEmployee object
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(
            "John", "Doe", "111-11-1111", 5000, 0.04, 300);

        // get base-salaried commission employee data
        System.out.println("Employee information obtained by get methods:");
        System.out.printf("%s %s\n", "First name is", employee.getFirstName());
        System.out.printf("%s %s\n", "Last name is", employee.getLastName());
        System.out.printf("%s %s\n", "Social security number is", employee.getSocialSecurityNumber());
        System.out.printf("%s %.2f\n", "Gross sales is", employee.getGrossSales());
        System.out.printf("%s %.2f\n", "Commission rate is", employee.getCommissionRate());
        System.out.printf("%s %.2f\n", "Base salary is", employee.getBaseSalary());

        employee.setBaseSalary(1000); // set base salary

        System.out.printf("\n%s:\n\n%s\n",
            "Updated employee information obtained by toString", employee);
    }
}
