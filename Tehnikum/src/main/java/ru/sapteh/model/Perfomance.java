package ru.sapteh.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "perfomance")
public class Perfomance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int number_semestr;

    @Column
    private int estimation;

    @Column
    private String date_of_examen;

    @Column
    private String lastname_prepodavatel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "object_id")
    private Object object;

    @Override
    public String toString() {
        return "Perfomance{" +
                "id=" + id +
                ", number_semestr=" + number_semestr +
                ", estimation=" + estimation +
                ", date_of_examen='" + date_of_examen + '\'' +
                ", lastname_prepodavatel='" + lastname_prepodavatel + '\'' +
                ", student=" + student +
                ", object=" + object +
                '}';
    }
}
