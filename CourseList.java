package edu.iuh.fit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class CourseList {
    private List<Course> courses = new ArrayList<>();

    // Phương thức thêm khóa học
    public boolean addCourse(Course course) {
        if (exists(course)) {
            System.out.println("Error: Course with this ID already exists.");
            return false;
        }
        courses.add(course);
        return true;
    }

    // Kiểm tra sự tồn tại của khóa học
    public boolean exists(Course course) {
        return courses.stream().anyMatch(c -> c.getId().equals(course.getId()));
    }

    // Lấy danh sách các khóa học
    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    // Xóa khóa học theo ID
    public boolean removeCourse(String courseId) {
        Course course = searchCourseById(courseId);
        if (course == null) {
            System.out.println("Error: Course ID not found.");
            return false;
        }
        courses.remove(course);
        return true;
    }

    // Tìm kiếm khóa học theo ID
    public Course searchCourseById(String courseId) {
        return courses.stream().filter(c -> c.getId().equals(courseId)).findFirst().orElse(null);
    }

    // Tìm kiếm khóa học theo tên
    public List<Course> searchCourse(String title) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(course);
            }
        }
        return result.isEmpty() ? null : result;
    }

    // Tìm kiếm khóa học theo khoa phụ trách
    public List<Course> searchCourseByDepartment(String department) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getDepartment().equalsIgnoreCase(department)) {
                result.add(course);
            }
        }
        return result.isEmpty() ? null : result;
    }

    // Sắp xếp các khóa học theo tên
    public List<Course> sortCourses() {
        List<Course> sortedCourses = new ArrayList<>(courses);
        sortedCourses.sort(Comparator.comparing(Course::getTitle));
        return sortedCourses;
    }

    // Tìm khóa học có số tín chỉ lớn nhất
    public List<Course> findMaxCreditCourses() {
        int maxCredit = courses.stream().mapToInt(Course::getCredit).max().orElse(-1);
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getCredit() == maxCredit) {
                result.add(course);
            }
        }
        return result;
    }

    // Tìm khoa có nhiều khóa học nhất
    public String findDepartmentWithMostCourses() {
        return courses.stream()
                .map(Course::getDepartment)
                .max(Comparator.comparingInt(dept -> (int) courses.stream()
                        .filter(course -> course.getDepartment().equals(dept)).count()))
                .orElse("No department found");
    }
}
