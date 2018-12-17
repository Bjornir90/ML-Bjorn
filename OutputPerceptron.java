public class OutputPerceptron extends Perceptron{
	private float expectedOutput, learningRate, errorTotal;
	private int learningIteration;

	public OutputPerceptron(int numberOfInputs, float learningRate) {
		super(numberOfInputs);
		this.learningRate = learningRate;
		errorTotal = 0.0f;
		learningIteration = 0;
	}

	public void setExpectedOutput(float expectedOutput) {
		this.expectedOutput = expectedOutput;
	}

	public void learn(){
		learningIteration++;
		float error = expectedOutput-computeOutput();
		errorTotal += error;
		float weightedError = error*learningRate;
		for (int i = 0; i < weights.length-1; i++) {
			weights[i] += weightedError*previousLayer.get(i).computeOutput();
		}
		weights[weights.length-1] += weightedError*bias;
	}

	public float getError() {
		return Math.abs(errorTotal/learningIteration);
	}
}
