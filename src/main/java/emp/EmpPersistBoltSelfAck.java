package emp;

import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;

public class EmpPersistBoltSelfAck extends BaseRichBolt{
	
	
	private static final long serialVersionUID = 1L;

	private OutputCollector collector;
	
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this.collector= collector;
		
		
	}

	public void execute(Tuple input) {
		Object obj =input.getValueByField("employee");
		Employee emp = (Employee) obj;
		System.out.println("Got emp on Persisting bolt "+ emp);
		
		
		//int y=1/0;
		if (emp.getEmpId() % 2 == 0) {
			collector.fail(input);
		}
		collector.ack(input);
		
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
