package epl.eldaf_electrony.fnon_admin.Model;

import com.google.gson.annotations.SerializedName;

public class contact_group {
    @SerializedName("id")
    int id;
    @SerializedName("teacher_name")
    String teacher_name;
    @SerializedName("teacher_id")
    int teacher_id;
    @SerializedName("stage")
    String stage;
    @SerializedName("year")
    String year;
    @SerializedName("group_name")
    String group_name;
    @SerializedName("type")
    String type;
    @SerializedName("num_student")
    int num_student;
    @SerializedName("price")
    double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNum_student() {
        return num_student;
    }

    public void setNum_student(int num_student) {
        this.num_student = num_student;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
