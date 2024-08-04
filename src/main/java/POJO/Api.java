package POJO;

import java.util.List;

public class Api {

    //need to update POJO classes
    private List<String> courseTitle;
    private List<String> price;

    public List<String> getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(List<String> courseTitle) {
        this.courseTitle = courseTitle;
    }

    public List<String> getPrice() {
        return price;
    }

    public void setPrice(List<String> price) {
        this.price = price;
    }
}
