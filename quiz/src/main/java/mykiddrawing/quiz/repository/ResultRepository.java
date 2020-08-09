package mykiddrawing.quiz.repository;


import mykiddrawing.quiz.model.Result;
import mykiddrawing.quiz.model.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

	 List<Result> findByUserId(Long userId);
	Optional<User> findByIdAndUserId(Long result_id, Long userId);
	
}