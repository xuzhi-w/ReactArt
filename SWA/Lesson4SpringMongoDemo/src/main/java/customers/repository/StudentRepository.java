package repositories;

import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
//    @Query("select s from Student s where s.name like :name")
    List<Student> findAllByNameContains(String name);

    Student findAllByPhoneNumber(String number);

    @Query("select s from Student s where s.address.city like :city")
    List<Student> findAllByCity(String city);

    Iterable<Object> findByName(String johnRock);
}
