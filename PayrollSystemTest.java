import java.util.Calendar;

public class PayrollSystemTest {
    public static void main(String[] args) {
        // create subclass objects
        SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 6, 15, 1980, 800.00);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", 7, 29, 1975, 16.75, 40);
        CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", 9, 8, 1990, 10000, 0.06);
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 3, 2, 1985, 5000, 0.04, 300);

        // get current month
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1; // months are 0-based, so add 1

        // create four-element Employee array
        Employee[] employees = new Employee[4];

        // initialize array with Employees
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;

        System.out.printf("Employees processed polymorphically:%n%n");

        // generically process each element in array employees
        for (Employee currentEmployee : employees) {
            System.out.println(currentEmployee); // invokes toString

            // determine whether element is a BasePlusCommissionEmployee
            if (currentEmployee instanceof BasePlusCommissionEmployee) {
                // downcast Employee reference to
                // BasePlusCommissionEmployee reference
                BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;

                double oldBaseSalary = employee.getBaseSalary();
                employee.setBaseSalary(1.10 * oldBaseSalary);
                System.out.printf("new base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
            }

            // add birthday bonus if this month is the employee's birthday month
            if (currentEmployee.getBirthDate().getMonth() == currentMonth) {
                System.out.printf("earned $%,.2f, including $100.00 birthday bonus%n%n", currentEmployee.earnings() + 100);
            } else {
                System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings());
            }
        }

        // get type name of each object in employees array
        for (int j = 0; j < employees.length; j++) {
            System.out.printf("Employee %d is a %s%n", j, employees[j].getClass().getName());
        }
    }
}
