package org.fog.test.perfeval;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import org.cloudbus.cloudsim.Host;
import org.cloudbus.cloudsim.Log;
import org.cloudbus.cloudsim.Pe;
import org.cloudbus.cloudsim.Storage;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.power.PowerHost;
import org.cloudbus.cloudsim.provisioners.RamProvisionerSimple;
import org.cloudbus.cloudsim.sdn.overbooking.BwProvisionerOverbooking;
import org.cloudbus.cloudsim.sdn.overbooking.PeProvisionerOverbooking;
import org.fog.application.AppEdge;
import org.fog.application.AppLoop;
import org.fog.application.Application;
import org.fog.application.selectivity.FractionalSelectivity;
import org.fog.entities.Actuator;
import org.fog.entities.FogBroker;
import org.fog.entities.FogDevice;
import org.fog.entities.FogDeviceCharacteristics;
import org.fog.entities.Sensor;
import org.fog.entities.Tuple;
import org.fog.placement.Controller;
import org.fog.placement.ModuleMapping;
import org.fog.placement.ModulePlacementMapping;
import org.fog.policy.AppModuleAllocationPolicy;
import org.fog.scheduler.StreamOperatorScheduler;
import org.fog.utils.FogLinearPowerModel;
import org.fog.utils.FogUtils;
import org.fog.utils.TimeKeeper;
import org.fog.utils.distribution.DeterministicDistribution;

public class Multiple_Apps {
	static List<FogDevice> fogDevices = new ArrayList<FogDevice>();
	static List<FogDevice> mobiles = new ArrayList<FogDevice>();
	static List<Sensor> sensors = new ArrayList<Sensor>();
	static List<Actuator> actuators = new ArrayList<Actuator>();
	static int numOfDepts = 2;
	static int numOfMobilesPerDept = 1;
	static double EEG_TRANSMISSION_TIME = 5.1;
	
	public static void main(String[] args) {
		Log.printLine("Starting Multi_Apps...");
		try {
			Log.disable();
			int num_user = 1; // number of cloud users
			Calendar calendar = Calendar.getInstance();
			boolean trace_flag = false; // mean trace events
			CloudSim.init(num_user, calendar, trace_flag);

			String appId0 = "vr_game_0";
			String appId1 = "vr_game_1";
			String appId2 = "vr_game_2";
			String appId3 = "vr_game_3";
			String appId4 = "vr_game_4";
			String appId5 = "vr_game_5";
			String appId6 = "vr_game_6";
			String appId7 = "vr_game_7";
			String appId8 = "vr_game_8";
			String appId9 = "vr_game_9";
			String appId10 = "vr_game_10";
			String appId11 = "vr_game_11";
					
			FogBroker broker0 = new FogBroker("broker_0");
			FogBroker broker1 = new FogBroker("broker_1");
			FogBroker broker2 = new FogBroker("broker_2");
			FogBroker broker3 = new FogBroker("broker_3");
			FogBroker broker4 = new FogBroker("broker_4");
			FogBroker broker5 = new FogBroker("broker_5");
			FogBroker broker6 = new FogBroker("broker_6");
			FogBroker broker7 = new FogBroker("broker_7");
			FogBroker broker8 = new FogBroker("broker_8");
			FogBroker broker9 = new FogBroker("broker_9");
			FogBroker broker10 = new FogBroker("broker_10");
			FogBroker broker11 = new FogBroker("broker_11");
			
			Application application0 = createApplication0(appId0, broker0.getId());
		  	Application application1 = createApplication1(appId1, broker1.getId());
			Application application2 = createApplication2(appId2, broker2.getId());
			Application application3 = createApplication3(appId3, broker3.getId());
			Application application4 = createApplication4(appId4, broker4.getId());
			Application application5 = createApplication5(appId5, broker5.getId());
			Application application6 = createApplication6(appId6, broker6.getId());
		  	Application application7 = createApplication7(appId7, broker7.getId());
			Application application8 = createApplication8(appId8, broker8.getId());
			Application application9 = createApplication9(appId9, broker9.getId());
			Application application10 = createApplication10(appId10, broker10.getId());
			Application application11 = createApplication11(appId11, broker11.getId());

			application0.setUserId(broker0.getId());
			application1.setUserId(broker1.getId());
			application2.setUserId(broker2.getId());
			application3.setUserId(broker3.getId());
			application4.setUserId(broker4.getId());
			application5.setUserId(broker5.getId());
			application6.setUserId(broker6.getId());
			application7.setUserId(broker7.getId());
			application8.setUserId(broker8.getId());
			application9.setUserId(broker9.getId());
			application10.setUserId(broker10.getId());
			application11.setUserId(broker11.getId());
			
			createFogDevices();
		//Order of execution
		//	/*
			createEdgeDevices3(broker3.getId(), appId3);
			createEdgeDevices4(broker4.getId(), appId4);
			createEdgeDevices0(broker0.getId(), appId0);
			createEdgeDevices5(broker5.getId(), appId5);
			createEdgeDevices1(broker1.getId(), appId1);
			createEdgeDevices2(broker2.getId(), appId2);
			createEdgeDevices6(broker6.getId(), appId6);
			createEdgeDevices7(broker7.getId(), appId7);
			createEdgeDevices8(broker8.getId(), appId8);
			createEdgeDevices9(broker9.getId(), appId9);
			createEdgeDevices10(broker10.getId(), appId10);
			createEdgeDevices11(broker11.getId(), appId11);
			 //*/
			/*
			createEdgeDevices3(broker3.getId(), appId3);
			createEdgeDevices5(broker5.getId(), appId5);
			createEdgeDevices1(broker1.getId(), appId1);
			createEdgeDevices4(broker4.getId(), appId4);
			createEdgeDevices0(broker0.getId(), appId0);
			createEdgeDevices2(broker2.getId(), appId2);
			*/
			
			ModuleMapping moduleMapping_0 = ModuleMapping.createModuleMapping(); // initializing a module mapping
			ModuleMapping moduleMapping_1 = ModuleMapping.createModuleMapping(); // initializing a module mapping
			ModuleMapping moduleMapping_2 = ModuleMapping.createModuleMapping(); // initializing a module mapping
			ModuleMapping moduleMapping_3 = ModuleMapping.createModuleMapping(); // initializing a module mapping
			ModuleMapping moduleMapping_4 = ModuleMapping.createModuleMapping(); // initializing a module mapping
			ModuleMapping moduleMapping_5 = ModuleMapping.createModuleMapping(); // initializing a module mapping
			ModuleMapping moduleMapping_6 = ModuleMapping.createModuleMapping(); // initializing a module mapping
			ModuleMapping moduleMapping_7 = ModuleMapping.createModuleMapping(); // initializing a module mapping
			ModuleMapping moduleMapping_8 = ModuleMapping.createModuleMapping(); // initializing a module mapping
			ModuleMapping moduleMapping_9 = ModuleMapping.createModuleMapping(); // initializing a module mapping
			ModuleMapping moduleMapping_10 = ModuleMapping.createModuleMapping(); // initializing a module mapping
			ModuleMapping moduleMapping_11 = ModuleMapping.createModuleMapping(); // initializing a module mapping
			
			
				for(FogDevice device : fogDevices){
				if(device.getName().startsWith("c")){
					moduleMapping_1.addModuleToDevice("client_1", device.getName());// fixing all instances of the client_0 module to the Smartphones
					moduleMapping_5.addModuleToDevice("client_5", device.getName());// fixing all instances of the client_0 module to the Smartphones
					moduleMapping_3.addModuleToDevice("client_3", device.getName());// fixing all instances of the client_0 module to the Smartphones
					}
				if(device.getName().startsWith("c")){	
					moduleMapping_0.addModuleToDevice("client_0", device.getName());// fixing all instances of the client_0 module to the Smartphones
					moduleMapping_2.addModuleToDevice("client_2", device.getName());  // fixing all instances of the client_0 module to the Smartphones
					moduleMapping_4.addModuleToDevice("client_4", device.getName());// fixing all instances of the client_0 module to the Smartphones
					moduleMapping_6.addModuleToDevice("client_6", device.getName());
					moduleMapping_7.addModuleToDevice("client_7", device.getName());
					moduleMapping_8.addModuleToDevice("client_8", device.getName());
					moduleMapping_9.addModuleToDevice("client_9", device.getName());
					moduleMapping_10.addModuleToDevice("client_10", device.getName());
					moduleMapping_11.addModuleToDevice("client_11", device.getName());
									}
			}
				//moduleMapping_1.addModuleToDevice("client_1", "cloud");
			Controller controller = new Controller("master-controller", fogDevices, sensors,actuators);
			//*/Order of execution	
			controller.submitApplication(application3, new ModulePlacementMapping(fogDevices, application3, moduleMapping_3));
			controller.submitApplication(application4, new ModulePlacementMapping(fogDevices, application4, moduleMapping_4));
			controller.submitApplication(application0, new ModulePlacementMapping(fogDevices, application0, moduleMapping_0));
			controller.submitApplication(application5, 00, new ModulePlacementMapping(fogDevices, application5, moduleMapping_5));
			controller.submitApplication(application1, new ModulePlacementMapping(fogDevices, application1, moduleMapping_1));
			controller.submitApplication(application2, new ModulePlacementMapping(fogDevices, application2, moduleMapping_2));
			controller.submitApplication(application6, new ModulePlacementMapping(fogDevices, application6, moduleMapping_6));
			controller.submitApplication(application7, new ModulePlacementMapping(fogDevices, application7, moduleMapping_7));
			controller.submitApplication(application8, new ModulePlacementMapping(fogDevices, application8, moduleMapping_8));
			controller.submitApplication(application9, new ModulePlacementMapping(fogDevices, application9, moduleMapping_9));
			controller.submitApplication(application10, new ModulePlacementMapping(fogDevices, application10, moduleMapping_10));
			controller.submitApplication(application11, 00, new ModulePlacementMapping(fogDevices, application11, moduleMapping_11));
		 //*/
			/*/Order of execution	
			controller.submitApplication(application3, new ModulePlacementMapping(fogDevices, application3, moduleMapping_3));
			controller.submitApplication(application5, 00, new ModulePlacementMapping(fogDevices, application5, moduleMapping_5));
			controller.submitApplication(application1, new ModulePlacementMapping(fogDevices, application1, moduleMapping_1));
			controller.submitApplication(application4, new ModulePlacementMapping(fogDevices, application4, moduleMapping_4));
			controller.submitApplication(application0, new ModulePlacementMapping(fogDevices, application0, moduleMapping_0));
			controller.submitApplication(application2, new ModulePlacementMapping(fogDevices, application2, moduleMapping_2));
			*/
			TimeKeeper.getInstance().setSimulationStartTime(Calendar.getInstance().getTimeInMillis());
			CloudSim.startSimulation();
			CloudSim.stopSimulation();
			Log.printLine("VRGame finished!");
		} catch (Exception e) {
			e.printStackTrace();
			Log.printLine("Unwanted errors happen");
		}
	}
	private static void createEdgeDevices0(int userId, String appId) {
		for(FogDevice mobile : mobiles){
			String id = mobile.getName();
			Sensor eegSensor = new Sensor("s-"+appId+"-"+id, "EEG", userId, appId, new DeterministicDistribution(EEG_TRANSMISSION_TIME)); // inter-transmission time of EEG sensor follows a deterministic distribution
			sensors.add(eegSensor);
			Actuator display = new Actuator("a-"+appId+"-"+id, userId, appId, "DISPLAY");
			actuators.add(display);
			eegSensor.setGatewayDeviceId(mobile.getId());
			eegSensor.setLatency(6.0);  // latency of connection between EEG sensors and the parent Smartphone is 6 ms
			display.setGatewayDeviceId(mobile.getId());
			display.setLatency(1.0);  // latency of connection between Display actuator and the parent Smartphone is 1 ms			
		}
	}
	private static void createEdgeDevices1(int userId, String appId) {
		for(FogDevice mobile : mobiles){
			String id = mobile.getName();
			Sensor eegSensor = new Sensor("s-"+appId+"-"+id, "EEG_1", userId, appId, new DeterministicDistribution(EEG_TRANSMISSION_TIME)); // inter-transmission time of EEG sensor follows a deterministic distribution
			sensors.add(eegSensor);
			Actuator display = new Actuator("a-"+appId+"-"+id, userId, appId, "DISPLAY_1");
			actuators.add(display);
			eegSensor.setGatewayDeviceId(mobile.getId());
			eegSensor.setLatency(6.0);  // latency of connection between EEG sensors and the parent Smartphone is 6 ms
			display.setGatewayDeviceId(mobile.getId());
			display.setLatency(1.0);  // latency of connection between Display actuator and the parent Smartphone is 1 ms			
		}
	}
	private static void createEdgeDevices2(int userId, String appId) {
		for(FogDevice mobile : mobiles){
			String id = mobile.getName();
			Sensor eegSensor = new Sensor("s-"+appId+"-"+id, "EEG_2", userId, appId, new DeterministicDistribution(EEG_TRANSMISSION_TIME)); // inter-transmission time of EEG sensor follows a deterministic distribution
			sensors.add(eegSensor);
			Actuator display = new Actuator("a-"+appId+"-"+id, userId, appId, "DISPLAY_2");
			actuators.add(display);
			eegSensor.setGatewayDeviceId(mobile.getId());
			eegSensor.setLatency(6.0);  // latency of connection between EEG sensors and the parent Smartphone is 6 ms
			display.setGatewayDeviceId(mobile.getId());
			display.setLatency(1.0);  // latency of connection between Display actuator and the parent Smartphone is 1 ms			
		}
	}	private static void createEdgeDevices3(int userId, String appId) {
		for(FogDevice mobile : mobiles){
			String id = mobile.getName();
			Sensor eegSensor = new Sensor("s-"+appId+"-"+id, "EEG_3", userId, appId, new DeterministicDistribution(EEG_TRANSMISSION_TIME)); // inter-transmission time of EEG sensor follows a deterministic distribution
			sensors.add(eegSensor);
			Actuator display = new Actuator("a-"+appId+"-"+id, userId, appId, "DISPLAY_3");
			actuators.add(display);
			eegSensor.setGatewayDeviceId(mobile.getId());
			eegSensor.setLatency(6.0);  // latency of connection between EEG sensors and the parent Smartphone is 6 ms
			display.setGatewayDeviceId(mobile.getId());
			display.setLatency(1.0);  // latency of connection between Display actuator and the parent Smartphone is 1 ms			
		}
	}	private static void createEdgeDevices4(int userId, String appId) {
		for(FogDevice mobile : mobiles){
			String id = mobile.getName();
			Sensor eegSensor = new Sensor("s-"+appId+"-"+id, "EEG_4", userId, appId, new DeterministicDistribution(EEG_TRANSMISSION_TIME)); // inter-transmission time of EEG sensor follows a deterministic distribution
			sensors.add(eegSensor);
			Actuator display = new Actuator("a-"+appId+"-"+id, userId, appId, "DISPLAY_4");
			actuators.add(display);
			eegSensor.setGatewayDeviceId(mobile.getId());
			eegSensor.setLatency(6.0);  // latency of connection between EEG sensors and the parent Smartphone is 6 ms
			display.setGatewayDeviceId(mobile.getId());
			display.setLatency(1.0);  // latency of connection between Display actuator and the parent Smartphone is 1 ms			
		}
	}	private static void createEdgeDevices5(int userId, String appId) {
		for(FogDevice mobile : mobiles){
			String id = mobile.getName();
			Sensor eegSensor = new Sensor("s-"+appId+"-"+id, "EEG_5", userId, appId, new DeterministicDistribution(EEG_TRANSMISSION_TIME)); // inter-transmission time of EEG sensor follows a deterministic distribution
			sensors.add(eegSensor);
			Actuator display = new Actuator("a-"+appId+"-"+id, userId, appId, "DISPLAY_5");
			actuators.add(display);
			eegSensor.setGatewayDeviceId(mobile.getId());
			eegSensor.setLatency(6.0);  // latency of connection between EEG sensors and the parent Smartphone is 6 ms
			display.setGatewayDeviceId(mobile.getId());
			display.setLatency(1.0);  // latency of connection between Display actuator and the parent Smartphone is 1 ms			
		}
	}
	private static void createEdgeDevices6(int userId, String appId) {
		for(FogDevice mobile : mobiles){
			String id = mobile.getName();
			Sensor eegSensor = new Sensor("s-"+appId+"-"+id, "EEG_6", userId, appId, new DeterministicDistribution(EEG_TRANSMISSION_TIME)); // inter-transmission time of EEG sensor follows a deterministic distribution
			sensors.add(eegSensor);
			Actuator display = new Actuator("a-"+appId+"-"+id, userId, appId, "DISPLAY_6");
			actuators.add(display);
			eegSensor.setGatewayDeviceId(mobile.getId());
			eegSensor.setLatency(6.0);  // latency of connection between EEG sensors and the parent Smartphone is 6 ms
			display.setGatewayDeviceId(mobile.getId());
			display.setLatency(1.0);  // latency of connection between Display actuator and the parent Smartphone is 1 ms			
		}
	}
	private static void createEdgeDevices7(int userId, String appId) {
		for(FogDevice mobile : mobiles){
			String id = mobile.getName();
			Sensor eegSensor = new Sensor("s-"+appId+"-"+id, "EEG_7", userId, appId, new DeterministicDistribution(EEG_TRANSMISSION_TIME)); // inter-transmission time of EEG sensor follows a deterministic distribution
			sensors.add(eegSensor);
			Actuator display = new Actuator("a-"+appId+"-"+id, userId, appId, "DISPLAY_7");
			actuators.add(display);
			eegSensor.setGatewayDeviceId(mobile.getId());
			eegSensor.setLatency(6.0);  // latency of connection between EEG sensors and the parent Smartphone is 6 ms
			display.setGatewayDeviceId(mobile.getId());
			display.setLatency(1.0);  // latency of connection between Display actuator and the parent Smartphone is 1 ms			
		}
	}
	private static void createEdgeDevices8(int userId, String appId) {
		for(FogDevice mobile : mobiles){
			String id = mobile.getName();
			Sensor eegSensor = new Sensor("s-"+appId+"-"+id, "EEG_8", userId, appId, new DeterministicDistribution(EEG_TRANSMISSION_TIME)); // inter-transmission time of EEG sensor follows a deterministic distribution
			sensors.add(eegSensor);
			Actuator display = new Actuator("a-"+appId+"-"+id, userId, appId, "DISPLAY_8");
			actuators.add(display);
			eegSensor.setGatewayDeviceId(mobile.getId());
			eegSensor.setLatency(6.0);  // latency of connection between EEG sensors and the parent Smartphone is 6 ms
			display.setGatewayDeviceId(mobile.getId());
			display.setLatency(1.0);  // latency of connection between Display actuator and the parent Smartphone is 1 ms			
		}
	}
	private static void createEdgeDevices9(int userId, String appId) {
		for(FogDevice mobile : mobiles){
			String id = mobile.getName();
			Sensor eegSensor = new Sensor("s-"+appId+"-"+id, "EEG_9", userId, appId, new DeterministicDistribution(EEG_TRANSMISSION_TIME)); // inter-transmission time of EEG sensor follows a deterministic distribution
			sensors.add(eegSensor);
			Actuator display = new Actuator("a-"+appId+"-"+id, userId, appId, "DISPLAY_9");
			actuators.add(display);
			eegSensor.setGatewayDeviceId(mobile.getId());
			eegSensor.setLatency(6.0);  // latency of connection between EEG sensors and the parent Smartphone is 6 ms
			display.setGatewayDeviceId(mobile.getId());
			display.setLatency(1.0);  // latency of connection between Display actuator and the parent Smartphone is 1 ms			
		}
	}
	private static void createEdgeDevices10(int userId, String appId) {
		for(FogDevice mobile : mobiles){
			String id = mobile.getName();
			Sensor eegSensor = new Sensor("s-"+appId+"-"+id, "EEG_10", userId, appId, new DeterministicDistribution(EEG_TRANSMISSION_TIME)); // inter-transmission time of EEG sensor follows a deterministic distribution
			sensors.add(eegSensor);
			Actuator display = new Actuator("a-"+appId+"-"+id, userId, appId, "DISPLAY_10");
			actuators.add(display);
			eegSensor.setGatewayDeviceId(mobile.getId());
			eegSensor.setLatency(6.0);  // latency of connection between EEG sensors and the parent Smartphone is 6 ms
			display.setGatewayDeviceId(mobile.getId());
			display.setLatency(1.0);  // latency of connection between Display actuator and the parent Smartphone is 1 ms			
		}
	}
	private static void createEdgeDevices11(int userId, String appId) {
		for(FogDevice mobile : mobiles){
			String id = mobile.getName();
			Sensor eegSensor = new Sensor("s-"+appId+"-"+id, "EEG_11", userId, appId, new DeterministicDistribution(EEG_TRANSMISSION_TIME)); // inter-transmission time of EEG sensor follows a deterministic distribution
			sensors.add(eegSensor);
			Actuator display = new Actuator("a-"+appId+"-"+id, userId, appId, "DISPLAY_11");
			actuators.add(display);
			eegSensor.setGatewayDeviceId(mobile.getId());
			eegSensor.setLatency(6.0);  // latency of connection between EEG sensors and the parent Smartphone is 6 ms
			display.setGatewayDeviceId(mobile.getId());
			display.setLatency(1.0);  // latency of connection between Display actuator and the parent Smartphone is 1 ms			
		}
	}
	
	
	private static void createFogDevices() {
		FogDevice cloud = createFogDevice("cloud", 44800, 40000, 100, 10000, 0, 0.01, 16*103, 16*83.25); // creates the fog device Cloud at the apex of the hierarchy with level=0
		cloud.setParentId(-1);
		FogDevice proxy = createFogDevice("proxy-server", 2800, 4000, 10000, 10000, 1, 0.0, 107.339, 83.4333); // creates the fog device Proxy Server (level=1)
		proxy.setParentId(cloud.getId()); // setting Cloud as parent of the Proxy Server
		proxy.setUplinkLatency(100); // latency of connection from Proxy Server to the Cloud is 100 ms
		
		fogDevices.add(cloud);
		fogDevices.add(proxy);
		
		for(int i=0;i<numOfDepts;i++){
			addGw(i+"", proxy.getId()); // adding a fog device for every Gateway in physical topology. The parent of each gateway is the Proxy Server
		}
	}

	private static FogDevice addGw(String id, int parentId){
		FogDevice dept = createFogDevice("d-"+id, 1000, 4000, 10000, 10000, 1, 0.0, 107.339, 83.4333);
		fogDevices.add(dept);
		dept.setParentId(parentId);
		dept.setUplinkLatency(4); // latency of connection between gateways and proxy server is 4 ms
		for(int i=0;i<numOfMobilesPerDept;i++){
			String mobileId = id+"-"+i;
			FogDevice mobile = addMobile(mobileId, dept.getId()); // adding mobiles to the physical topology. Smartphones have been modeled as fog devices as well.
			
			mobile.setUplinkLatency(2); // latency of connection between the smartphone and proxy server is 4 ms
			fogDevices.add(mobile);
		}
		return dept;
	}
	
	private static FogDevice addMobile(String id, int parentId){
		FogDevice mobile = createFogDevice("m-"+id, 1000, 1000, 10000, 270, 3, 0, 87.53, 82.44);
		mobile.setParentId(parentId);
		mobiles.add(mobile);
		return mobile;
	}

	private static FogDevice createFogDevice(String nodeName, long mips,
			int ram, long upBw, long downBw, int level, double ratePerMips, double busyPower, double idlePower) {
		
		List<Pe> peList = new ArrayList<Pe>();

		// 3. Create PEs and add these into a list.
		peList.add(new Pe(0, new PeProvisionerOverbooking(mips))); // need to store Pe id and MIPS Rating

		int hostId = FogUtils.generateEntityId();
		long storage = 1000000; // host storage
		int bw = 10000;

		PowerHost host = new PowerHost(
				hostId,
				new RamProvisionerSimple(ram),
				new BwProvisionerOverbooking(bw),
				storage,
				peList,
				new StreamOperatorScheduler(peList),
				new FogLinearPowerModel(busyPower, idlePower)
			);

		List<Host> hostList = new ArrayList<Host>();
		hostList.add(host);

		String arch = "x86"; // system architecture
		String os = "Linux"; // operating system
		String vmm = "Xen";
		double time_zone = 10.0; // time zone this resource located
		double cost = 3.0; // the cost of using processing in this resource
		double costPerMem = 0.05; // the cost of using memory in this resource
		double costPerStorage = 0.001; // the cost of using storage in this resource
		double costPerBw = 0.0; // the cost of using bw in this resource
		LinkedList<Storage> storageList = new LinkedList<Storage>(); // we are not adding SAN devices by now

		FogDeviceCharacteristics characteristics = new FogDeviceCharacteristics(
				arch, os, vmm, host, time_zone, cost, costPerMem,
				costPerStorage, costPerBw);

		FogDevice fogdevice = null;
		try {
			fogdevice = new FogDevice(nodeName, characteristics, 
					new AppModuleAllocationPolicy(hostList), storageList, 10, upBw, downBw, 0, ratePerMips);
		} catch (Exception e) {
			e.printStackTrace();
		}
		fogdevice.setLevel(level);
		return fogdevice;
	}

	@SuppressWarnings({"serial" })
	private static Application createApplication0(String appId, int userId){
		Application application = Application.createApplication(appId, userId); // creates an empty application model (empty directed graph)
		    application.addAppModule("client_0", 10); // adding module client_0 to the application model
			application.addAppEdge("EEG", "client_0", 4400, 500, "EEG", Tuple.UP, AppEdge.SENSOR); // adding edge from EEG (sensor) to client_0 module carrying tuples of type EEG
		    application.addTupleMapping("client_0", "EEG", "_SENSOR", new FractionalSelectivity(0.9)); // 0.9 tuples of type _SENSOR are emitted by client_0 module per incoming tuple of type EEG 
		final AppLoop loop1 = new AppLoop(new ArrayList<String>(){{add("EEG");add("client_0");add("client_0");}});
		List<AppLoop> loops = new ArrayList<AppLoop>(){{add(loop1);}};
		application.setLoops(loops);
			return application;
	}
	
	@SuppressWarnings({"serial" })
	private static Application createApplication1(String appId, int userId){
		Application application = Application.createApplication(appId, userId); // creates an empty application model (empty directed graph)
			application.addAppModule("client_1", 10); // adding module client_0 to the application model
			application.addAppEdge("EEG_1", "client_1",2400, 500, "EEG_1", Tuple.UP, AppEdge.SENSOR); // adding edge from EEG (sensor) to client_0 module carrying tuples of type EEG
			application.addTupleMapping("client_1", "EEG_1", "_SENSOR_1", new FractionalSelectivity(0.9)); // 0.9 tuples of type _SENSOR are emitted by client_0 module per incoming tuple of type EEG 
		final AppLoop loop1 = new AppLoop(new ArrayList<String>(){{add("EEG_1");add("client_1");add("client_1");}});
		List<AppLoop> loops = new ArrayList<AppLoop>(){{add(loop1);}};
		application.setLoops(loops);
			return application;
	}
	@SuppressWarnings({"serial" })
	private static Application createApplication2(String appId, int userId){
		Application application = Application.createApplication(appId, userId); // creates an empty application model (empty directed graph)
			application.addAppModule("client_2", 10); // adding module client_0 to the application model
			application.addAppEdge("EEG_2", "client_2",5500, 500, "EEG_2", Tuple.UP, AppEdge.SENSOR); // adding edge from EEG (sensor) to client_0 module carrying tuples of type EEG
			application.addTupleMapping("client_2", "EEG_2", "_SENSOR_2", new FractionalSelectivity(0.9)); // 0.9 tuples of type _SENSOR are emitted by client_0 module per incoming tuple of type EEG 
		final AppLoop loop1 = new AppLoop(new ArrayList<String>(){{add("EEG_2");add("client_2");add("client_2");}});
		List<AppLoop> loops = new ArrayList<AppLoop>(){{add(loop1);}};
		application.setLoops(loops);
			return application;
	}
	@SuppressWarnings({"serial" })
	private static Application createApplication3(String appId, int userId){
		Application application = Application.createApplication(appId, userId); // creates an empty application model (empty directed graph)
			application.addAppModule("client_3", 10); // adding module client_0 to the application model
			application.addAppEdge("EEG_3", "client_3",500, 500, "EEG_3", Tuple.UP, AppEdge.SENSOR); // adding edge from EEG (sensor) to client_0 module carrying tuples of type EEG
			application.addTupleMapping("client_3", "EEG_3", "_SENSOR_3", new FractionalSelectivity(0.9)); // 0.9 tuples of type _SENSOR are emitted by client_0 module per incoming tuple of type EEG 
		final AppLoop loop1 = new AppLoop(new ArrayList<String>(){{add("EEG_3");add("client_3");add("client_3");}});
		List<AppLoop> loops = new ArrayList<AppLoop>(){{add(loop1);}};
		application.setLoops(loops);
			return application;
	}
	@SuppressWarnings({"serial" })
	private static Application createApplication4(String appId, int userId){
		Application application = Application.createApplication(appId, userId); // creates an empty application model (empty directed graph)
			application.addAppModule("client_4", 10); // adding module client_0 to the application model
			application.addAppEdge("EEG_4", "client_4",3500, 500, "EEG_4", Tuple.UP, AppEdge.SENSOR); // adding edge from EEG (sensor) to client_0 module carrying tuples of type EEG
			application.addTupleMapping("client_4", "EEG_4", "_SENSOR_4", new FractionalSelectivity(0.9)); // 0.9 tuples of type _SENSOR are emitted by client_0 module per incoming tuple of type EEG 
		final AppLoop loop1 = new AppLoop(new ArrayList<String>(){{add("EEG_4");add("client_4");add("client_4");}});
		List<AppLoop> loops = new ArrayList<AppLoop>(){{add(loop1);}};
		application.setLoops(loops);
			return application;
	}
	@SuppressWarnings({"serial" })
	private static Application createApplication5(String appId, int userId){
		Application application = Application.createApplication(appId, userId); // creates an empty application model (empty directed graph)
			application.addAppModule("client_5", 10); // adding module client_0 to the application model
			application.addAppEdge("EEG_5", "client_5",1500, 500, "EEG_5", Tuple.UP, AppEdge.SENSOR); // adding edge from EEG (sensor) to client_0 module carrying tuples of type EEG
			application.addTupleMapping("client_5", "EEG_5", "_SENSOR_5", new FractionalSelectivity(0.9)); // 0.9 tuples of type _SENSOR are emitted by client_0 module per incoming tuple of type EEG 
		final AppLoop loop1 = new AppLoop(new ArrayList<String>(){{add("EEG_5");add("client_5");add("client_5");}});
		List<AppLoop> loops = new ArrayList<AppLoop>(){{add(loop1);}};
		application.setLoops(loops);
			return application;
	}
	@SuppressWarnings({"serial" })
	private static Application createApplication6(String appId, int userId){
		Application application = Application.createApplication(appId, userId); // creates an empty application model (empty directed graph)
			application.addAppModule("client_6", 10); // adding module client_0 to the application model
			application.addAppEdge("EEG_6", "client_6",1500, 500, "EEG_6", Tuple.UP, AppEdge.SENSOR); // adding edge from EEG (sensor) to client_0 module carrying tuples of type EEG
			application.addTupleMapping("client_6", "EEG_6", "_SENSOR_6", new FractionalSelectivity(0.9)); // 0.9 tuples of type _SENSOR are emitted by client_0 module per incoming tuple of type EEG 
		final AppLoop loop1 = new AppLoop(new ArrayList<String>(){{add("EEG_6");add("client_6");add("client_6");}});
		List<AppLoop> loops = new ArrayList<AppLoop>(){{add(loop1);}};
		application.setLoops(loops);
			return application;
	}
	@SuppressWarnings({"serial" })
	private static Application createApplication7(String appId, int userId){
		Application application = Application.createApplication(appId, userId); // creates an empty application model (empty directed graph)
			application.addAppModule("client_7", 10); // adding module client_0 to the application model
			application.addAppEdge("EEG_7", "client_7",1500, 500, "EEG_7", Tuple.UP, AppEdge.SENSOR); // adding edge from EEG (sensor) to client_0 module carrying tuples of type EEG
			application.addTupleMapping("client_7", "EEG_7", "_SENSOR_7", new FractionalSelectivity(0.9)); // 0.9 tuples of type _SENSOR are emitted by client_0 module per incoming tuple of type EEG 
		final AppLoop loop1 = new AppLoop(new ArrayList<String>(){{add("EEG_7");add("client_7");add("client_7");}});
		List<AppLoop> loops = new ArrayList<AppLoop>(){{add(loop1);}};
		application.setLoops(loops);
			return application;
	}
	@SuppressWarnings({"serial" })
	private static Application createApplication8(String appId, int userId){
		Application application = Application.createApplication(appId, userId); // creates an empty application model (empty directed graph)
			application.addAppModule("client_8", 10); // adding module client_0 to the application model
			application.addAppEdge("EEG_8", "client_8",1500, 500, "EEG_8", Tuple.UP, AppEdge.SENSOR); // adding edge from EEG (sensor) to client_0 module carrying tuples of type EEG
			application.addTupleMapping("client_8", "EEG_8", "_SENSOR_8", new FractionalSelectivity(0.9)); // 0.9 tuples of type _SENSOR are emitted by client_0 module per incoming tuple of type EEG 
		final AppLoop loop1 = new AppLoop(new ArrayList<String>(){{add("EEG_8");add("client_8");add("client_8");}});
		List<AppLoop> loops = new ArrayList<AppLoop>(){{add(loop1);}};
		application.setLoops(loops);
			return application;
	}
	@SuppressWarnings({"serial" })
	private static Application createApplication9(String appId, int userId){
		Application application = Application.createApplication(appId, userId); // creates an empty application model (empty directed graph)
			application.addAppModule("client_9", 10); // adding module client_0 to the application model
			application.addAppEdge("EEG_9", "client_9",1500, 500, "EEG_9", Tuple.UP, AppEdge.SENSOR); // adding edge from EEG (sensor) to client_0 module carrying tuples of type EEG
			application.addTupleMapping("client_9", "EEG_9", "_SENSOR_9", new FractionalSelectivity(0.9)); // 0.9 tuples of type _SENSOR are emitted by client_0 module per incoming tuple of type EEG 
		final AppLoop loop1 = new AppLoop(new ArrayList<String>(){{add("EEG_9");add("client_9");add("client_9");}});
		List<AppLoop> loops = new ArrayList<AppLoop>(){{add(loop1);}};
		application.setLoops(loops);
			return application;
	}
	@SuppressWarnings({"serial" })
	private static Application createApplication10(String appId, int userId){
		Application application = Application.createApplication(appId, userId); // creates an empty application model (empty directed graph)
			application.addAppModule("client_10", 10); // adding module client_0 to the application model
			application.addAppEdge("EEG_10", "client_10",1500, 500, "EEG_10", Tuple.UP, AppEdge.SENSOR); // adding edge from EEG (sensor) to client_0 module carrying tuples of type EEG
			application.addTupleMapping("client_10", "EEG_10", "_SENSOR_10", new FractionalSelectivity(0.9)); // 0.9 tuples of type _SENSOR are emitted by client_0 module per incoming tuple of type EEG 
		final AppLoop loop1 = new AppLoop(new ArrayList<String>(){{add("EEG_10");add("client_10");add("client_10");}});
		List<AppLoop> loops = new ArrayList<AppLoop>(){{add(loop1);}};
		application.setLoops(loops);
			return application;
	}
	@SuppressWarnings({"serial" })
	private static Application createApplication11(String appId, int userId){
		Application application = Application.createApplication(appId, userId); // creates an empty application model (empty directed graph)
			application.addAppModule("client_11", 10); // adding module client_0 to the application model
			application.addAppEdge("EEG_11", "client_11",1500, 500, "EEG_11", Tuple.UP, AppEdge.SENSOR); // adding edge from EEG (sensor) to client_0 module carrying tuples of type EEG
			application.addTupleMapping("client_11", "EEG_11", "_SENSOR_11", new FractionalSelectivity(0.9)); // 0.9 tuples of type _SENSOR are emitted by client_0 module per incoming tuple of type EEG 
		final AppLoop loop1 = new AppLoop(new ArrayList<String>(){{add("EEG_11");add("client_11");add("client_11");}});
		List<AppLoop> loops = new ArrayList<AppLoop>(){{add(loop1);}};
		application.setLoops(loops);
			return application;
	}
}