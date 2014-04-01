package basic.exam05.step06.ex;

import java.util.EventObject;


public class StateChangeEvent extends EventObject{
  private static final long serialVersionUID = 1L;
	public String stateName;
	public StateChangeEvent(Object source) {
	  super(source);

  }
	public StateChangeEvent(Object source, String stateName) {
	  super(source);
	  this.stateName = stateName;
  }
	
	

}










