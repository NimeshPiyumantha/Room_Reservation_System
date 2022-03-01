package view.tm;

import javafx.scene.control.Button;

public class MealTM {
    private String MealPlanName;
    private Double Price;
    private String Breakfast;
    private String Lunch;
    private String Evening;
    private String Dinner;
    private Button btn;

    public MealTM() {
    }

    public MealTM(String mealPlanName, Double price, String breakfast, String lunch, String evening, String dinner, Button btn) {
        MealPlanName = mealPlanName;
        Price = price;
        Breakfast = breakfast;
        Lunch = lunch;
        Evening = evening;
        Dinner = dinner;
        this.btn = btn;
    }

    public String getMealPlanName() {
        return MealPlanName;
    }

    public void setMealPlanName(String mealPlanName) {
        MealPlanName = mealPlanName;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public String getBreakfast() {
        return Breakfast;
    }

    public void setBreakfast(String breakfast) {
        Breakfast = breakfast;
    }

    public String getLunch() {
        return Lunch;
    }

    public void setLunch(String lunch) {
        Lunch = lunch;
    }

    public String getEvening() {
        return Evening;
    }

    public void setEvening(String evening) {
        Evening = evening;
    }

    public String getDinner() {
        return Dinner;
    }

    public void setDinner(String dinner) {
        Dinner = dinner;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "MealTM{" +
                "MealPlanName='" + MealPlanName + '\'' +
                ", Price=" + Price +
                ", Breakfast='" + Breakfast + '\'' +
                ", Lunch='" + Lunch + '\'' +
                ", Evening='" + Evening + '\'' +
                ", Dinner='" + Dinner + '\'' +
                ", btn=" + btn +
                '}';
    }
}
