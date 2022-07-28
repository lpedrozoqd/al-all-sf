package edu.lpq.alallsf.repository;

import edu.lpq.alallsf.entity.Users;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    @Query("Select u from Users u where u.email=?1")
    Optional<Users> findByUserEmail(String email);

    @Query("Select u from Users u where u.name like ?1%")
    List<Users> findAndSort(String name, Sort sort);
    
    
    List<Users> findByName(String name);

    Optional<Users> findByEmailAndName(String email, String name);

    List<Users> findByNameLike(String name);

    List<Users> findByBirthDateBetween(LocalDate fechaInicio, LocalDate fechaFin);

    
    List<Users> findByNameLikeOrderByIdDesc(String name);


    List<Users> findByNameContainingOrderByIdDesc(String name);


    



}
