package org.jnect.tutorial.righthandtracker;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.jnect.tutorial.righthandtracker.BodyTracker;


public class StartStopHandler extends AbstractHandler {
	
	private static boolean STARTED = false;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if(!STARTED){
			BodyTracker.INSTANCE.printBodyPosition();
			STARTED = true;
		} else {
			BodyTracker.INSTANCE.stop();
			STARTED = false;
		}
		
		return null;
	}

}
