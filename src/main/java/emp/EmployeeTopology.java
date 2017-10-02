package emp;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;

public class EmployeeTopology {
	
	public static void main(String[] args) {
		// create an instance of TopologyBuilder class
				TopologyBuilder builder = new TopologyBuilder();
				// set the spout class
				builder.setSpout("EmpSpout", new EmployeeProductingSpout(),1);
				// set the bolt class
				builder.setBolt("EmpBolt1", new EmpEnrichingBolt(), 1).shuffleGrouping("EmpSpout");
				
				//EmpPersistBoltSelfAck
				//builder.setBolt("EmpPersitBolt", new EmpPersistingBolt(),2).shuffleGrouping("EmpBolt1").setNumTasks(2);
				builder.setBolt("EmpPersitBolt", new EmpPersistBoltSelfAck(),2).shuffleGrouping("EmpBolt1");
				Config conf = new Config();
				//conf.setDebug(true);
				
				// create an instance of LocalCluster class for
				// executing topology in local mode.
				LocalCluster cluster = new LocalCluster();
				// SampleStormTopology is the name of submitted topology
				cluster.submitTopology("EmpStormTopology", conf, builder.createTopology());
				try {
					Thread.sleep(60000);
				} catch (Exception exception) {
					System.out.println("Thread interrupted exception : " + exception);
				}
				// kill the SampleStormTopology
				cluster.killTopology("EmpStormTopology");
				// shutdown the storm test cluster
				cluster.shutdown();
	}

}
