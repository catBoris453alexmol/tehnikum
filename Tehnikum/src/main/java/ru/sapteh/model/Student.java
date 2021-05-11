package ru.sapteh.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String lastname;

    @Column
    private String firstname;

    @Column
    private String patronumik;

    @Column
    private String date_of_receipt;

    @Column
    private int course;

    @Column
    private String number_group;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(mappedBy = "student")
    private Set<Perfomance> perfomances;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "special_id")
    private Special special;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", patronumik='" + patronumik + '\'' +
                ", date_of_receipt='" + date_of_receipt + '\'' +
                ", course=" + course +
                ", number_group='" + number_group + '\'' +
                ", faculty=" + faculty +
                '}';
    }
}
