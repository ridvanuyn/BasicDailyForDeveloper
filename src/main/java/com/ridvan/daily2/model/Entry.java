package com.ridvan.daily2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ENTRY")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ENTRY_ID")
    private int id;

    @NotEmpty
    @Column(name = "TITLE")
    private String title;

    @NotEmpty
    @Column(name="BODY")
    private String body;

    @NotNull
    @Column(name="CREATE_DATE")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate createDate= LocalDate.now();

    @NotEmpty
    @Column(name="WRITER")
    private String writer;

    @Column(name="IS_DELETED")
    private String isDeleted;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = false)
    @JoinColumn(name = "ENTRY_ID")
    private List<Likes> likeList=new ArrayList<>();
}
