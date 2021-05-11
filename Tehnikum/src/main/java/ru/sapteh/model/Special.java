package ru.sapteh.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "special")
public class Special {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "special")
    private Set<Student> students;

    @Override
    public String toString() {
        return "Special{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
