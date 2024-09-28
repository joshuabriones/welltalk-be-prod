package com.communicators.welltalk.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "tblnotifications")
public class NotificationsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notificationId;
    private String type;
    private String message;
    private boolean isRead;
    private LocalDateTime date;
    private LocalDateTime readDate;
    
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserEntity user;

    public NotificationsEntity(int notificationId, String message, LocalDateTime date,
            boolean isRead,
            UserEntity user) {
        this.notificationId = notificationId;
        this.message = message;
        this.date = date;
        this.isRead = isRead;
        this.user = user;
    }

    public NotificationsEntity(String message, UserEntity user, String type) {
        this.message = message;
        this.user = user;
        this.type = type;
        this.isRead = false;
    }

    public NotificationsEntity(String message, String type, UserEntity user) {
        this.message = message;
        this.type = type;
        this.user = user;
        this.isRead = false;  
        this.date = LocalDateTime.now();  
    }

    public NotificationsEntity() {
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @PrePersist
    protected void onCreate() {
        date = LocalDateTime.now();
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @PreUpdate
    protected void onUpdate() {
        readDate = LocalDateTime.now();
    }

    public LocalDateTime getReadDate() {
        return readDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
