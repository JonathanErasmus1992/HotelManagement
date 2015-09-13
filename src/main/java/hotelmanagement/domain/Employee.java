package hotelmanagement.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/05/05.
 */
@Entity
public class Employee implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String ID_number;
    private String employee_firstnames;
    private String employee_lastname;
    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private List<EmployeeDemographics> employee_demographics;
    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private List<EmployeeAddress> employee_address;
    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private List<EmployeeContact> employee_contact;
    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private List<Job> job;
    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private List<Manager> manager;
    private Date hire_date;

    private Employee(){}

    public Employee( Builder builder )
    {
        ID = builder.ID;
        ID_number = builder.ID_number;
        employee_firstnames = builder.employee_firstnames;
        employee_lastname = builder.employee_lastname;
        employee_demographics = builder.employee_demographics;
        employee_address = builder.employee_address;
        employee_contact = builder.employee_contact;
        job = builder.job;
        manager = builder.manager;
        hire_date = builder.hire_date;
    }

    public Long getID()
    {
        return ID;
    }
    public String getIDNumber()
    {
        return ID_number;
    }
    public String getFirstnames()
    {
        return employee_firstnames;
    }
    public String getLastname()
    {
        return employee_lastname;
    }
    public List<EmployeeDemographics> getEmployeeDemographics()
    {
        return employee_demographics;
    }
    public List<EmployeeAddress> getEmployeeAddress()
    {
        return employee_address;
    }
    public List<EmployeeContact> getEmployeeContact()
    {
        return employee_contact;
    }
    public List<Job> getJob()
    {
        return job;
    }
    public List<Manager> getManager()
    {
        return manager;
    }
    public Date getHireDate()
    {
        return hire_date;
    }
    public static class Builder
    {
        private Long ID;
        private String ID_number;
        private String employee_firstnames;
        private String employee_lastname;
        private List<EmployeeDemographics> employee_demographics;
        private List<EmployeeAddress> employee_address;
        private List<EmployeeContact> employee_contact;
        private List<Job> job;
        private List<Manager> manager;
        private Date hire_date;

        public Builder( String ID_number )
        {
            this.ID_number = ID_number;
        }
        public Builder ID( Long value )
        {
            this.ID = value;
            return this;
        }
        public Builder employee_firstnames( String value )
        {
            this.employee_firstnames = value;
            return this;
        }
        public Builder employee_lastname( String value )
        {
            this.employee_lastname = value;
            return this;
        }
        public Builder employee_demographics( List<EmployeeDemographics> value )
        {
            this.employee_demographics = value;
            return this;
        }
        public Builder employee_address( List<EmployeeAddress> value )
        {
            this.employee_address = value;
            return this;
        }
        public Builder employee_contact( List<EmployeeContact> value )
        {
            this.employee_contact = value;
            return this;
        }
        public Builder job( List<Job> value )
        {
            this.job = value;
            return this;
        }
        public Builder manager( List<Manager> value )
        {
            this.manager = value;
            return this;
        }
        public Builder hire_date( Date value )
        {
            this.hire_date = value;
            return this;
        }
        public Builder copy( Employee value )
        {
            this.ID_number = value.getIDNumber();
            this.ID = value.getID();
            this.employee_firstnames = value.getFirstnames();
            this.employee_lastname = value.getLastname();
            this.employee_demographics = value.getEmployeeDemographics();
            this.employee_address = value.getEmployeeAddress();
            this.employee_contact = value.getEmployeeContact();
            this.job = value.getJob();
            this.manager = value.getManager();
            this.hire_date = value.getHireDate();

            return this;
        }

        public Employee build()
        {
            return new Employee( this );
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", ID_number='" + ID_number + '\'' +
                ", employee_firstnames='" + employee_firstnames + '\'' +
                ", employee_lastname='" + employee_lastname + '\'' +
                ", employee_demographics=" + employee_demographics +
                ", employee_address=" + employee_address +
                ", employee_contact=" + employee_contact +
                ", job=" + job +
                ", manager=" + manager +
                ", hire_date=" + hire_date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!ID.equals(employee.ID)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ID.hashCode();
    }
}