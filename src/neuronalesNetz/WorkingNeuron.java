package neuronalesNetz;

import java.util.ArrayList;
import java.util.List;

import activationFunctions.ActivationFunction;

public class WorkingNeuron extends Neuron{

	private List<Connection> connections = new ArrayList<>();
	
	@Override
	public float getValue() {
		float sum = 0;
		for(Connection c : connections){
			sum += c.getValue();
		}
		return ActivationFunction.activationIfGtr2(sum);
	}

	public void addConnection(Connection c){
		connections.add(c);
	}
}
