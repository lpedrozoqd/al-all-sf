package edu.lpq.alallsf.repository;

import edu.lpq.alallsf.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository  extends JpaRepository<Posts,Long> {
}
