package com.TaskManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TaskManagement.Entity.EmailLog;

@Repository
public interface EmailLogRepository extends JpaRepository<EmailLog,Long> {
	
	Optional<EmailLog>findByName(String name);


}
