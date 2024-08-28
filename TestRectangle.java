package iuh.fit.se;
import java.util.Scanner;
public class TestRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập chiều dài và chiều rộng từ người dùng
        System.out.print("Nhập chiều dài: ");
        double length = scanner.nextDouble();
        System.out.print("Nhập chiều rộng: ");
        double width = scanner.nextDouble();

        // Tạo đối tượng Rectangle
        try {
            Rectangle rectangle = new Rectangle(length, width);

            // In ra chu vi, diện tích và biểu diễn hình chữ nhật dạng chuỗi
            System.out.println("Chu vi: " + rectangle.getPerimeter());
            System.out.println("Diện tích: " + rectangle.getArea());
            System.out.println(rectangle.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
