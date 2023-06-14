package com.atelier04.booking.dto;


public record RoomRequest(String roomName, boolean smartBoard, boolean whiteBoard, boolean audio, boolean projector, boolean printer, int seats,String section,String category, String directions) {
}
