package by.youngliqui.firstMVC.repositories;

import by.youngliqui.firstMVC.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

}
