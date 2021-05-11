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
@Table(name = "object")
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "object")
    private Set<Perfomance> perfomances;

    @Override
    public String toString() {
        return "Object{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
