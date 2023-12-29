package com.ssdada.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "diary")
@Getter
@Setter
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id", referencedColumnName = "id")
    private Board board;

    @Column(name = "diary_title")
    private String diaryName;

    @Column(name = "diary_content")
    private String diaryContent;

    @Column(name = "reg_date")
    private LocalDateTime regDate;
}
