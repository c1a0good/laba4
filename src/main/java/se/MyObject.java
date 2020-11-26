package se;

public class MyObject {
    private Integer ID;
    private Integer employeeID;
    private String department;
    private String lastName;
    private String firstName;
    private String middleName;
    private String startDate;
    private String endDate;
    private Double salary;
    private Double earnings;
    static private final Double percent = 0.05;

    public Integer getId() {
        return ID;
    }

    public void setId(Integer ID) {
        this.ID = ID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
        setEarnings();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
        setEarnings();
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
        setEarnings();
    }

    public Double getEarnings() {
        return earnings;
    }

    public void setEarnings() {
        if( !(this.salary == null) && !(this.startDate == null) && !(this.endDate == null)) {
            this.earnings = this.salary * DataService.subDate(this.startDate, this.endDate) * percent;
        }
        this.earnings = 0.0;
    }

    public Double getPercent() {
        return percent;
    }
}