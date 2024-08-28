package edu.iuh.fit;

import java.util.List;
import java.util.Scanner;
public class TestCourse {
    // Phương thức khởi tạo dữ liệu ban đầu
    public static void initData(CourseList courseList) {
        courseList.addCourse(new Course("CS101", "Introduction to Computer Science", 3, "Computer Science"));
        courseList.addCourse(new Course("MAT201", "Calculus II", 4, "Mathematics"));
        courseList.addCourse(new Course("PHY101", "Physics I", 3, "Physics"));
        // Thêm các khóa học khác nếu cần
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseList courseList = new CourseList();
        initData(courseList);

        while (true) {
            System.out.println("1. Add Course");
            System.out.println("2. Remove Course");
            System.out.println("3. Search Course by ID");
            System.out.println("4. Search Course by Title");
            System.out.println("5. Search Course by Department");
            System.out.println("6. Display All Courses");
            System.out.println("7. Sort Courses by Title");
            System.out.println("8. Find Max Credit Courses");
            System.out.println("9. Find Department with Most Courses");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Course ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Course Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Credit: ");
                    int credit = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    Course course = new Course(id, title, credit, department);
                    courseList.addCourse(course);
                    break;
                case 2:
                    System.out.print("Enter Course ID to remove: ");
                    String courseId = scanner.nextLine();
                    courseList.removeCourse(courseId);
                    break;
                case 3:
                    System.out.print("Enter Course ID to search: ");
                    String searchId = scanner.nextLine();
                    Course foundCourse = courseList.searchCourseById(searchId);
                    System.out.println(foundCourse != null ? foundCourse : "Course not found.");
                    break;
                case 4:
                    System.out.print("Enter Course Title to search: ");
                    String searchTitle = scanner.nextLine();
                    List<Course> foundCoursesByTitle = courseList.searchCourse(searchTitle);
                    if (foundCoursesByTitle != null) {
                        foundCoursesByTitle.forEach(System.out::println);
                    } else {
                        System.out.println("No courses found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter Department to search: ");
                    String searchDepartment = scanner.nextLine();
                    List<Course> foundCoursesByDept = courseList.searchCourseByDepartment(searchDepartment);
                    if (foundCoursesByDept != null) {
                        foundCoursesByDept.forEach(System.out::println);
                    } else {
                        System.out.println("No courses found.");
                    }
                    break;
                case 6:
                    courseList.getCourses().forEach(System.out::println);
                    break;
                case 7:
                    courseList.sortCourses().forEach(System.out::println);
                    break;
                case 8:
                    courseList.findMaxCreditCourses().forEach(System.out::println);
                    break;
                case 9:
                    System.out.println("Department with most courses: " + courseList.findDepartmentWithMostCourses());
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
