package activationFunctions;

public class HyperbolicTangent implements ActivationFunction{

	@Override
	public float activation(float input) {
		float epx = (float)Math.pow(Math.E, input);
		float enx = (float)Math.pow(Math.E,-input);
		return (epx-enx)/(epx+enx);
	}

}
