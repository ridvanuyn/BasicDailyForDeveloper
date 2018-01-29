package com.ridvan.daily2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LIKES")
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LIKE_ID")
    private Integer id;

    @Column(name = "USER_NAME")
    private String userName;


    @Column(name = "ENTRY_ID")
    private Integer entryId;

}
