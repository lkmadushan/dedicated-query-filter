import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "employees", catalog = "filter")
public class Employee {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    protected Integer id;

    @Column(name = "name", nullable = false)
    protected String name;

    @Column(name = "address", nullable = false)
    protected String address;

    @Column(name = "birth_date", nullable = true)
    @Type(type = "date")
    protected Date birthDate;

    public Employee() {}

    public Employee(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Employee(String name, String address, Date birthDate) {
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void getAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

}
