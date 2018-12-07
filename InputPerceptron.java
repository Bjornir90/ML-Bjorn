import java.util.ArrayList;

public class InputPerceptron implements CalculUnit{
	private float currentData;

	public InputPerceptron() {

	}

	public void newData(float data){
		currentData = data;
	}

	@Override
	public float computeOutput(){
		return currentData;
	}
}
