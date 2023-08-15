package DataMapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 4.5. Data Mapper
 * Преобразователь данных. Программная прослойка, разделяющая объект и
 * БД. Его обязанность — пересылать данные между ними и изолировать их друг от
 * друга.
 */

//Класс Student содержит только данные
public class Student {
    private int id;
    private String name;
    private String course;


    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;

    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }
}

//Класс StudentDataMapper обеспечивает передачу данных между объектами и базой
//данных и изоляцию их друг от друга. Отвечает за поведение обьекта.
    class StudentDataMapper {
        // Соединение с базой данных
        Connection conn = null;

        void insert(Student student) throws SQLException {
// Здесь мы формируем SQL запрос на вставку данных об объекте в базу данных.
            String sql = String.format("INSERT INTO students (id, name, course) VALUES (%d, '%s', '%s')", student.getId(), student.getName(), student.getCourse());
            try(Statement statement = conn.createStatement()){
                statement.execute(sql);
            }
        }
        void update(Student student) throws SQLException {
// Здесь мы формируем SQL запрос на обновление данных об объекте в базе данных.
            String sql = String.format("UPDATE students SET name = '%s', course = '%s' WHERE id = %d",student.getName(), student.getCourse(), student.getId());
            try(Statement statement = conn.createStatement()){
                statement.execute(sql);
            }
        }

        void delete(Student student) throws SQLException {
// Здесь мы формируем SQL запрос на удаление данных об объекте из базы данных.
            String sql = String.format("DELETE FROM students WHERE id = %d", student.getId());
            try(Statement statement = conn.createStatement()){
                statement.execute(sql);
            }
        }
        // Бизнес-логика
        public boolean isEligibleForScholarship(Student student) {
// Допустим, что студенты, обучающиеся на определенных курсах, имеют право на стипендию.
            return student.getCourse().equals("Mathematics") || student.getCourse().equals("Physics");
        }
    }





}
