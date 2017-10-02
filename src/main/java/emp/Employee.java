package emp;
public class Employee {
	
	private Integer empId;
	
	private String name;
	
	public Employee() {
		
	}
	
	public Employee(Integer id) {
		this.empId = id;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + "]";
	}

}
