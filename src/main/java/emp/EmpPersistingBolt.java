package emp;

import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Tuple;

public class EmpPersistingBolt extends BaseBasicBolt{

	private static final long serialVersionUID = 1L;

	public void execute(Tuple input, BasicOutputCollector collector) {
		
		Object obj =input.getValueByField("employee");
		Employee emp = (Employee) obj;
		System.out.println("Got emp on Persisting bolt "+ emp);
		
		
		//int y=1/0;
		if (emp.getEmpId() % 2 == 0) {
			//collector.getOutputter().fail(input);
		}
		
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		
	}

	

}
