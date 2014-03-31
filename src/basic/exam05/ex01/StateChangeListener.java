package basic.exam05.ex01;

import java.util.EventListener;


public interface StateChangeListener extends EventListener {
	void stateChanged(StateChangeEvent e);
}
