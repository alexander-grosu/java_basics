import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

    @Entity
    @Table(name = "Courses")
    public class Course {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Getter
        @Setter
        private Integer id;
        @Getter
        @Setter
        private String name;
        @Getter
        @Setter
        private Integer duration;
        @Getter
        @Setter
        private String description;               // 'int' is the primitive data type that cannot assign null to it
        @Column(name = "teacher_id")              // while
        @Getter                                   // 'Integer' is the wrapper class of int which can accept null
        @Setter
        private Integer teacherId;
        @Column(name = "students_count")
        @Getter
        @Setter
        private Integer studentsCount;
        @Getter
        @Setter
        private Integer price;
        @Column(name = "price_per_hour")  // - - - - -> name like in sql table
        @Getter
        @Setter
        private float pricePerHour;
        @Enumerated(EnumType.STRING)
        @Column(columnDefinition = "enum")
        @Getter
        @Setter
        private CourseType type;

    }
