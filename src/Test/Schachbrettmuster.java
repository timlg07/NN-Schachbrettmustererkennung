package Test;

import neuronalesNetz.InputNeuron;
import neuronalesNetz.NeuralNetwork;
import neuronalesNetz.OutputNeuron;

public class Schachbrettmuster {//multilayerTest
	public static void main(String[] args) {
		NeuralNetwork nn = new NeuralNetwork();
		
		InputNeuron[] in = {
				nn.createNewInput(),
				nn.createNewInput(),
				nn.createNewInput(),
				nn.createNewInput(),
		};
		
		OutputNeuron out = nn.createNewOutput();
		nn.createHiddenNeurons(4);
		
		nn.createFullMesh(
				//Hidden
				1,1,0,0, 
				1,0,1,0,
				0,1,0,1,
				0,0,1,1,
				//Output
				1,1,1,1
		);
		
		in[0].setValue(1); //A
		in[1].setValue(0); //B
		in[2].setValue(0); //C
		in[3].setValue(1); //D
		
		System.out.println(out.getValue()==0?"Schachbrettmuster":"kein Schachbrettmuster");
	}
}
