package edu.iuh.fit;
/**
 * @description:  This class represents the school's course including the course code, course name and which department is in charge
 * @author:  Trung, Pham Tien
 * @version: 1.0
 * @created: 28-Aug-2024 10:33:50 PM
 */

public class Course {
    private String id;
    private String title;
    private int credit;
    private String department;

    // Constructor không đối số
    public Course() {
    }

    // Constructor có tham số
    public Course(String id, String title, int credit, String department) {
        setId(id);
        setTitle(title);
        setCredit(credit);
        this.department = department;
    }

    // Getter và Setter với kiểm tra ràng buộc
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.length() < 3 || !id.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("ID must have at least 3 characters and contain only letters or digits");
        }
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        if (credit <= 0) {
            throw new IllegalArgumentException("Credit must be greater than 0");
        }
        this.credit = credit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Title: %s, Credit: %d, Department: %s", id, title, credit, department);
    }
}
