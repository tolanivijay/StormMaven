package emp;

public class EmpEnrichmentService {
	
	public static void enrichEmployee(Employee emp) {
		if (emp != null) {
			if (emp.getEmpId().equals(1)) {
				emp.setName("One");
			}else if (emp.getEmpId().equals(2)) {
				emp.setName("Two");
			}else if (emp.getEmpId().equals(3)) {
				emp.setName("Threee");
			}else if (emp.getEmpId().equals(4)) {
				emp.setName("Four");
			}else if (emp.getEmpId().equals(5)) {
				emp.setName("Five");
			}
		}
	}

}
