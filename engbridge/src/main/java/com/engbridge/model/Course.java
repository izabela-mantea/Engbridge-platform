package com.engbridge.model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer orderNum;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "courses_levels_fk")
    private Level level;

    @OneToMany(mappedBy = "sections", fetch = FetchType.LAZY)
    private List<Section> sections;

}
