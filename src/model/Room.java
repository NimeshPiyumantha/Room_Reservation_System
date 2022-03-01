package model;

import javafx.scene.control.TableColumn;

public class Room {
    private String RoomId;
    private String RoomType;
    private String RoomDetail;
    private String FloorNumber;
    private double RoomPrice;

    public Room() {
    }

    public Room(String roomId, String roomType, String roomDetail, String floorNumber, double roomPrice) {
        RoomId = roomId;
        RoomType = roomType;
        RoomDetail = roomDetail;
        FloorNumber = floorNumber;
        RoomPrice = roomPrice;
    }

    public String getRoomId() {
        return RoomId;
    }

    public void setRoomId(String roomId) {
        RoomId = roomId;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String roomType) {
        RoomType = roomType;
    }

    public String getRoomDetail() {
        return RoomDetail;
    }

    public void setRoomDetail(String roomDetail) {
        RoomDetail = roomDetail;
    }

    public String getFloorNumber() {
        return FloorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        FloorNumber = floorNumber;
    }

    public double getRoomPrice() {
        return RoomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        RoomPrice = roomPrice;
    }

    @Override
    public String toString() {
        return "Room{" +
                "RoomId='" + RoomId + '\'' +
                ", RoomType='" + RoomType + '\'' +
                ", RoomDetail='" + RoomDetail + '\'' +
                ", FloorNumber='" + FloorNumber + '\'' +
                ", RoomPrice=" + RoomPrice +
                '}';
    }
}