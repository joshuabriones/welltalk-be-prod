package com.communicators.welltalk.dto;

public class NotificationsDTO {
    private int receiverId;
    private int appointmentId;

    public NotificationsDTO() {
    }
    
    // appointment
    public NotificationsDTO(int receiverId, int appointmentId) {
        this.receiverId = receiverId;
        this.appointmentId = appointmentId;
    }

    public int getReceiverId() {
        return receiverId;
    }
    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }
    public int getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }


}
