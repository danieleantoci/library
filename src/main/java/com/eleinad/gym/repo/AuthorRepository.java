package com.eleinad.gym.repo;

import com.eleinad.gym.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
