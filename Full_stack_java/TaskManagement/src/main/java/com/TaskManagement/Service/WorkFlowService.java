package com.TaskManagement.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManagement.Entity.WorkFlow;
import com.TaskManagement.Entity.WorkFlowTransaction;
import com.TaskManagement.Repository.WorkflowRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkFlowService {
	
	
	@Autowired
	private WorkflowRepository workFlowRepo;
	
	
	
	public WorkFlow createworkFlow(String name,List<WorkFlowTransaction> transactions) {
		
		WorkFlow wf= new WorkFlow();
		wf.setName(name);
		for(WorkFlowTransaction t: transactions) {
			t.setWorkflow(wf);
		}
		wf.setTransactions(transactions);
		return workFlowRepo.save(wf);
		
	}
	
	public WorkFlow getWorkflow(String name) {
		return workFlowRepo.findByName(name).orElseThrow(()-> new RuntimeException("WorkFlow not found"));
	}
	
	public List<WorkFlow>getAllWorkFlows(){
		return workFlowRepo.findAll();
	}

}


