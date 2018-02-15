package neuronalesNetz;

import java.util.ArrayList;
import java.util.List;


public class NeuralNetwork {
	private List<InputNeuron>   inputNeurons = new ArrayList<>();
	private List<WorkingNeuron>hiddenNeurons = new ArrayList<>();
	private List<OutputNeuron> outputNeurons = new ArrayList<>();
	
	public void createHiddenNeurons(int amount){
		for(int i=0;i<amount;i++)hiddenNeurons.add(new WorkingNeuron());
	}
	
	public OutputNeuron createNewOutput(){
		OutputNeuron wn = new OutputNeuron();
		outputNeurons.add(wn);
		return wn;
	}
	
	public InputNeuron createNewInput(){
		InputNeuron in = new InputNeuron();
		inputNeurons.add(in);
		return in;
	}
	
	public int amountOfConnections(){
		if(hiddenNeurons.size()==0){
			return inputNeurons.size()*outputNeurons.size();
		}else{
			return inputNeurons.size()*hiddenNeurons.size() + hiddenNeurons.size()*outputNeurons.size();
		}
	}
	
	public void createFullMesh(){
		if(hiddenNeurons.size()==0){
			for(OutputNeuron wn : outputNeurons){
				for(InputNeuron in : inputNeurons){
					wn.addConnection(new Connection(in, 0));
				}
			}
		}else{
			//connect each output with every hidden
			for(OutputNeuron wn : outputNeurons){
				for(WorkingNeuron hn : hiddenNeurons){
					wn.addConnection(new Connection(hn, 0));
				}
			}
			//connect each hidden with every input
			for(WorkingNeuron hn : hiddenNeurons){
				for(InputNeuron in : inputNeurons){
					hn.addConnection(new Connection(in, 0));
				}
			}
		}
	}
	
	public void createFullMesh(float...weights){
		if(weights.length!=amountOfConnections())throw new RuntimeException();
		int i=0;
		if(hiddenNeurons.size()==0){
			for(OutputNeuron wn : outputNeurons){
				for(InputNeuron in : inputNeurons){
					wn.addConnection(new Connection(in, weights[i++]));
				}
			}
		}else{
			//connect each hidden with every input
			for(WorkingNeuron hn : hiddenNeurons){
				for(InputNeuron in : inputNeurons){
					hn.addConnection(new Connection(in, weights[i++]));
				}
			}
			//connect each output with every hidden
			for(OutputNeuron wn : outputNeurons){
				for(WorkingNeuron hn : hiddenNeurons){
					wn.addConnection(new Connection(hn, weights[i++]));
				}
			}
		}
	}
}
