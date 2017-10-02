package emp;


import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

public class EmpEnrichingBolt extends BaseBasicBolt{

	private static final long serialVersionUID = 1L;

	public void execute(Tuple input, BasicOutputCollector collector) {

		Object emp =input.getValueByField("employee");
		Employee empl = null;
		if (emp instanceof Employee) {
			empl = (Employee) emp;
			EmpEnrichmentService.enrichEmployee(empl);
			System.out.println("Enriched emp"+empl);
			collector.emit(new Values(empl));
		}
		
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("employee"));
		
	}

}
