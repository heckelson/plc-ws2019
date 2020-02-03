import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Hecke Alexander
 * @id 11710696
 */

public class TrafficControllerFair implements TrafficController {
	private TrafficRegistrar registrar;
	Lock lock;
	
	public TrafficControllerFair(TrafficRegistrar registrar) {
		this.registrar = registrar;
		lock = new ReentrantLock(true);
	}
	
	
	@Override
	public void enterRight(Vehicle v) {
		lock.lock();
		registrar.registerRight(v);
	}

	@Override
	public void enterLeft(Vehicle v) {
		lock.lock();
		registrar.registerLeft(v);

	}

	@Override
	public void leaveLeft(Vehicle v) {
		lock.unlock();
		registrar.deregisterLeft(v);
	}

	@Override
	public void leaveRight(Vehicle v) {
		lock.unlock();
		registrar.deregisterRight(v);
	}

}
