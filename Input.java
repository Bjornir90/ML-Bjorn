import java.util.ArrayList;

public class Input implements CalculUnit{
	private float currentData;

	public Input() {

	}

	public void newData(float data){
		currentData = data;
	}

	@Override
	public float computeOutput(){
		return currentData;
	}
}
