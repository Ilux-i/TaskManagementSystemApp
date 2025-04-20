package com.example.TaskManagementSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "note")
public class Note
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String note;
    private Long userId;



    //Геттеры, сеттеры, toString(), equals(), hashcode()
    public void setTitle(String title) {this.title = title;}
    public String getTitle() {return title;}

    public void setNote(String note) {this.note = note;}
    public String getNote() {return note;}

    public void setUserId(Long userId) {this.userId = userId;}
    public Long getUserId() {return userId;}
}
