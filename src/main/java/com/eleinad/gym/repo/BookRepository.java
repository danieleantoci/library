package com.eleinad.gym.repo;

import com.eleinad.gym.entity.BookDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<BookDTO, Long> {
}
