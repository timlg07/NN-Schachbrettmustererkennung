package activationFunctions;

public interface ActivationFunction {
	
	public static BooleanFunc Boolean = new BooleanFunc();
	public static Identity Identity = new Identity();
	public static Sigmoid Sigmoid = new Sigmoid();
	public static HyperbolicTangent HyperbolicTangent = new HyperbolicTangent();
	
	public float activation(float input);
	
	//CUSTOM
	public static float activationIfGtr2(float input){
		return (input>=2)?1:0;
	}
	public static float ReverseBoolean(float input){
		return (input==0)?1:0;
	}
}
