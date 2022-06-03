package com.eleinad.gym.repo;

import com.eleinad.gym.entity.AuthorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorDTO, Long> {

}
