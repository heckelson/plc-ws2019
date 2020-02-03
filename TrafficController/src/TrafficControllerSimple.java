/**
 * @author Hecke Alexander
 * @id 11710696
 */

public class TrafficControllerSimple implements TrafficController {
	private TrafficRegistrar registrar;
	private boolean bridgeInUse = false;
	
	public TrafficControllerSimple(TrafficRegistrar tr) {
		this.registrar = tr;
	}
	
	@Override
	public synchronized void enterRight(Vehicle v) {
		while(bridgeInUse) {
		try {
			wait();
			} catch (InterruptedException e) {}
		}
		bridgeInUse = true;
		registrar.registerRight(v);
	}      
           
	@Override
	public synchronized void enterLeft(Vehicle v) {
		while(bridgeInUse) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		bridgeInUse = true;
		registrar.registerLeft(v);
	}

	@Override
	public synchronized void leaveLeft(Vehicle v) {
		registrar.deregisterLeft(v);
		bridgeInUse = false;
		notify();
	}      
           
	@Override
	public synchronized void leaveRight(Vehicle v) {
		registrar.deregisterRight(v);
		bridgeInUse = false;
		notify();
	}
	
}

