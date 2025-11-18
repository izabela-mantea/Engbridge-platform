package com.paw.engbridge.model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "sections")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column()
    private Integer orderNum;

    @Column(length = 15)
    private String type;

    @ManyToOne
    @JoinColumn(name="sections_course_fk")
    private Course course;

    @OneToMany(mappedBy = "exercises", fetch = FetchType.LAZY)
    private List<Exercise> exercises;


}
