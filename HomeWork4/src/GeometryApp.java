
//Необходимо доработать код, добавив контракты к методам, документацию и обеспечив
// высокую связанность и низкую сочетаемость:

/**
 * В исходном коде уже была реализована высокая связность. Изменила класс GeometryApp,
 * чтобы обеспесить низкую сочетаемость
 */

// Класс для геометрических фигур
abstract class Shape {
    // Общие поля и методы для всех геометрических фигур
    abstract double getArea();
    abstract double getPerimeter();
}

// Класс для круга
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    /**
     * Метод ищет площадь круга
     * @apiNote
     * @param radius радиус круга
     * @return возвращает площадь круга
     */
    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Метод ищет длину окружности
     * @apiNote
     * @param radius радиус круга
     * @return возвращает длину окружности
     */
    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Класс для прямоугольника
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * Метод ищет площадь прямоугольника
     * @param length длина прямоугольника
     * @param width ширина прямоугольника
     * @return значение площади прямоугольника
     */
    @Override
    double getArea() {
        return length * width;
    }
    /**
     * Метод ищет сумму сторон прямоугольника
     * @apiNote
     * @param length длина прямоугольника
     * @param width ширина прямоугольника
     * @return возвращает значение суммы сторон прямоугольника
     */
    @Override
    double getPerimeter() {
        return 2 * (length + width);
    }
}

// Класс для треугольника
class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /**
     * Метод ищет площадь треугольника
     * @param side1 side2 side3 длины сторон треугольника
     * @return значение площади треугольника
     */
    @Override
    double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    /**
     * Метод ищет сумму сторон треугольника
     * @param side1 side2 side3 длины сторон треугольника
     * @return возвращает значение суммы сторон треугольника
     */
    @Override
    double getPerimeter() {
        return side1 + side2 + side3;
    }
}

// Главный класс приложения
public class GeometryApp {
    public static void main(String[] args) {
        // Пример использования конкретных классов геометрических фигур
        Shape circle = new Circle(5.0);
        System.out.println("Площадь круга: " + circle.getArea());
        System.out.println("Периметр круга: " + circle.getPerimeter());

        Shape rectangle = new Rectangle(4.0, 6.0);
        System.out.println("Площадь прямоугольника: " + rectangle.getArea());
        System.out.println("Периметр прямоугольника: " + rectangle.getPerimeter());

        Shape triangle = new Triangle(3.0, 4.0, 5.0);
        System.out.println("Площадь треугольника: " + triangle.getArea());
        System.out.println("Периметр треугольника: " + triangle.getPerimeter());
    }
}

