package activationFunctions;

public class BooleanFunc implements ActivationFunction{

	@Override
	public float activation(float input) {
		return input<0?0:1;
	}

}
