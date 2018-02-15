package activationFunctions;

public class Sigmoid implements ActivationFunction{

	@Override
	public float activation(float input) {
		return (float) (1/(1+Math.pow(Math.E,-input)));
	}

}
