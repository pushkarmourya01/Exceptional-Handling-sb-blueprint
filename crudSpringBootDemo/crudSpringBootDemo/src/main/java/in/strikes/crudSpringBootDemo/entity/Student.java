package in.strikes.crudSpringBootDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.sql.ast.spi.StringBuilderSqlAppender;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Student{
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Long getId(Long id){
        return id;
    }

    public void setID(Long id){
        this.id=id;
    }


    private String name;
    private int roll;
    private int age;
    private String email;
    private LocalTime createdAt;
    private LocalDate updatedAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
