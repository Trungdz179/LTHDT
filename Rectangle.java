package iuh.fit.se;

public class Rectangle {
    private double length;
    private double width;

    // Constructor mặc định
    public Rectangle() {
        this.length = 1.0;
        this.width = 1.0;
    }

    // Constructor với tham số
    public Rectangle(double length, double width) {
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Length and width must be greater than 0");
        }
        this.length = length;
        this.width = width;
    }

    // Getter cho chiều dài
    public double getLength() {
        return length;
    }

    // Setter cho chiều dài
    public void setLength(double length) {
        if (length < 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        this.length = length;
    }

    // Getter cho chiều rộng
    public double getWidth() {
        return width;
    }

    // Setter cho chiều rộng
    public void setWidth(double width) {
        if (width < 0) {
            throw new IllegalArgumentException("Width must be greater than 0");
        }
        this.width = width;
    }

    // Phương thức tính diện tích
    public double getArea() {
        return length * width;
    }

    // Phương thức tính chu vi
    public double getPerimeter() {
        return 2 * (length + width);
    }

    // Phương thức biểu diễn hình chữ nhật dạng chuỗi
    @Override
    public String toString() {
        return "Rectangle[length=" + length + ", width=" + width + "]";
    }
}
