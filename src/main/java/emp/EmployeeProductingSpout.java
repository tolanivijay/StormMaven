package emp;

import java.util.Map;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

public class EmployeeProductingSpout extends BaseRichSpout {

	private static final long serialVersionUID = 1L;

	private SpoutOutputCollector spoutOutputCollector;

	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		this.spoutOutputCollector = collector;
		System.out.println("Open called on EmployeeProductingSpout");

	}

	public void nextTuple() {

		for (int i = 1; i <= 5; i++) {
			Employee emp = new Employee(i);
			spoutOutputCollector.emit(new Values(emp),System.currentTimeMillis());
			System.out.println("Emited employee " + emp);
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
			}

		}

	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("employee"));

	}

	@Override
	public void ack(Object msgId) {
		System.out.println("Ack called for "+msgId);
	}

	@Override
	public void fail(Object msgId) {
		System.out.println("Fail called for "+msgId);
	}

}
