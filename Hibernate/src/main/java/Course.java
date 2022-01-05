import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

    @Entity
    @Setter
    @Getter
    @Table(name = "Courses")
    public class Course {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Integer id;

        private String name;

        private Integer duration;

        private String description;
                                                  // 'int' is the primitive data type that cannot assign null to it
        @Column(name = "teacher_id")              // while
        private Integer teacherId;                // 'Integer' is the wrapper class of int which can accept null

        @Column(name = "students_count")
        private Integer studentsCount;

        private Integer price;

        @Column(name = "price_per_hour")  // - - - - -> name like in sql table
        private float pricePerHour;

        @Enumerated(EnumType.STRING)
        @Column(columnDefinition = "enum")
        private CourseType type;

    }
