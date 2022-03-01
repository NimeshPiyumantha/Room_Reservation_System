package view.tm;

import javafx.scene.control.Button;

public class RoomTM {
    private String RoomId;
    private String RoomType;
    private String RoomDetail;
    private String FloorNumber;
    private double RoomPrice;
    private Button btn;

    public RoomTM() {
    }

    public RoomTM(String roomId, String roomType, String roomDetail, String floorNumber, double roomPrice, Button btn) {
        RoomId = roomId;
        RoomType = roomType;
        RoomDetail = roomDetail;
        FloorNumber = floorNumber;
        RoomPrice = roomPrice;
        this.btn = btn;
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "RoomTM{" +
                "RoomId='" + RoomId + '\'' +
                ", RoomType='" + RoomType + '\'' +
                ", RoomDetail='" + RoomDetail + '\'' +
                ", FloorNumber='" + FloorNumber + '\'' +
                ", RoomPrice=" + RoomPrice +
                ", btn=" + btn +
                '}';
    }
}

