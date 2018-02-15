package neuronalesNetz;

import java.util.ArrayList;
import java.util.List;

import activationFunctions.ActivationFunction;

public class OutputNeuron extends Neuron{

	private List<Connection> connections = new ArrayList<>();
	ActivationFunction activationFunction = ActivationFunction.Identity;
	
	@Override
	public float getValue() {
		float sum = 0;
		for(Connection c : connections){
			sum += c.getValue();
		}
		return activationFunction.activation(sum);
	}

	public void addConnection(Connection c){
		connections.add(c);
	}
}
