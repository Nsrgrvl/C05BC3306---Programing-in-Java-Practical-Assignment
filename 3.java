class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void work() {
        System.out.println(name + " is working as a general employee.");
    }
}

class Manager extends Employee {
    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void work() {
        System.out.println(name + " is managing the team. Salary: $" + salary);
    }
}

class Developer extends Employee {
    public Developer(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void work() {
        System.out.println(name + " is writing code. Salary: $" + salary);
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Employee m = new Manager("POORVA", 95,000);
        Employee d = new Developer("NISARG", 90,000);
        
        m.work();
        d.work();
    }
}