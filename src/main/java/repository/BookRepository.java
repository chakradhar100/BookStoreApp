package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

import model.Books;

@Repository
public interface BookRepository extends JpaRepository<Books , Long> {

    List<Books> findByBnameIgnoreCase(String bname);

    


    
}
