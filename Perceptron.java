import java.util.ArrayList;

public class Perceptron implements CalculUnit {
	protected float [] weights;
	protected ArrayList<CalculUnit> previousLayer;
	protected int bias;

	public Perceptron(int numberOfInputs){
		weights = new float[numberOfInputs+1];//plus 1 for the bias
		bias = 1;
		previousLayer = new ArrayList<>();
	}

	@Override
	public float computeOutput(){
		float[] weightedInputs = new float[weights.length];
		for(int i = 0; i<weights.length-1; i++){
			weightedInputs[i] = previousLayer.get(i).computeOutput()*weights[i];
		}
		weightedInputs[weights.length-1] = bias*weights[weights.length-1];
		float sum = 0;
		for (int i = 0; i < weightedInputs.length; i++) {
			sum += weightedInputs[i];
		}
		return (sum < 0)?0:sum;//reLU
	}

	public void addInput(CalculUnit in){
		previousLayer.add(in);
	}

}
