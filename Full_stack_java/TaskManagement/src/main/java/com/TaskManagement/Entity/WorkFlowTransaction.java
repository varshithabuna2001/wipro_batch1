package com.TaskManagement.Entity;
import javax.persistence.*;

import com.TaskManagement.Enum.Role;

import lombok.*;

@Entity
@Table(name="workFlow_Transactions")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class WorkFlowTransaction {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	private String fromStatus;
	private String toStatus;
	private String actionName;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="workFlow_id")
	private WorkFlow workFlow;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFromStatus() {
		return fromStatus;
	}


	public void setFromStatus(String fromStatus) {
		this.fromStatus = fromStatus;
	}


	public String getToStatus() {
		return toStatus;
	}


	public void setToStatus(String toStatus) {
		this.toStatus = toStatus;
	}


	public String getActionName() {
		return actionName;
	}


	public void setActionName(String actionName) {
		this.actionName = actionName;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public WorkFlow getWorkflow() {
		return workFlow;
	}


	public void setWorkflow(WorkFlow workflow) {
		this.workFlow = workflow;
	}
}

