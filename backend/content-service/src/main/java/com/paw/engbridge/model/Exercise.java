package com.paw.engbridge.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column()
    private Integer orderNum;

    @Column(length = 10)
    private String type;

    @Lob
    @Column()
    private String content;

    @ManyToOne
    @JoinColumn(name="exercises_section_fk")
    private Section section;

}
