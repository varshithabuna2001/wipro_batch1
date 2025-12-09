package com.TaskManagement.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TaskManagement.Entity.WorkFlowTransaction;

@Repository
public interface WorkFlowTransactionRepository extends JpaRepository<WorkFlowTransaction,Long> {

}

