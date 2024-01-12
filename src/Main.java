import nerualnetwork.NeuralNetwork;

import javax.swing.plaf.IconUIResource;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        List<NeuralNetwork> listOfNeuralNetwork = new ArrayList<>();
        for (int j = 0; j < 10_000; j++) {
            NeuralNetwork neuralNetwork = new NeuralNetwork();
            listOfNeuralNetwork.add(neuralNetwork);
        }
        for (int i = 0; i < 10_000; i++) {
            System.out.println("Покаление №" + i);
            double a = random.nextDouble() * 100;
            double b = random.nextDouble() * 100;
            int sizeListOfNeuralNetwork = listOfNeuralNetwork.size();
            List<NeuralNetwork> newListOfNeuralNetworks = new ArrayList<>();
            for (int j = 0; j < sizeListOfNeuralNetwork; j++) {
                NeuralNetwork neuralNetwork = listOfNeuralNetwork.get(j);
                double calculate = neuralNetwork.calculate(a, b);
                System.out.println("Нейронной сети №" + j);
                System.out.println(a + " + " + b + " = " +  (a + b));
                System.out.println(calculate);
                System.out.println();

                if(calculate > a+b-1 && calculate < a+b+1){
                    for (int k = 0; k < 10000; k++) {
                        listOfNeuralNetwork.add(neuralNetwork);
                    }
                    continue;
                }
                if(calculate > a+b-2 && calculate < a+b+2){
                    for (int k = 0; k < 500; k++) {
                        listOfNeuralNetwork.add(neuralNetwork);
                    }
                    continue;
                }
                if(calculate > a+b-5 && calculate < a+b+5){
                    for (int k = 0; k < 300; k++) {
                        listOfNeuralNetwork.add(neuralNetwork);
                    }
                    continue;
                }
                if(calculate > a+b-10 && calculate < a+b+10){
                    for (int k = 0; k < 100; k++) {
                        listOfNeuralNetwork.add(neuralNetwork);
                    }
                    continue;
                }
                if(calculate > a+b-20 && calculate < a+b+20){
                    for (int k = 0; k < 25; k++) {
                        listOfNeuralNetwork.add(neuralNetwork);
                    }
                    continue;
                }
                if(calculate > a+b-100 && calculate < a+b+100){
                    listOfNeuralNetwork.add(neuralNetwork);
                }
            }
            for (int j = 0; j < 100; j++) {
                Set<NeuralNetwork> setOfNeuralNetwork = new HashSet<>();
                double[][] newArrayWeights = new double[2][];
                newArrayWeights[0] = new double[4];
                newArrayWeights[1] = new double[2];

                Set<Integer> setOfNumberWeight = new HashSet<>();
                while (setOfNumberWeight.size() < 3){
                    setOfNumberWeight.add(random.nextInt(6));
                }

                while (setOfNeuralNetwork.size() < 2){
                    NeuralNetwork neuralNetwork = listOfNeuralNetwork.get(random.nextInt(listOfNeuralNetwork.size()));
                    setOfNeuralNetwork.add(neuralNetwork);
                    newArrayWeights = neuralNetwork.getWeights();
                }

                for (NeuralNetwork neuralNetwork:
                     setOfNeuralNetwork) {
                    double[][] getWeight = neuralNetwork.getWeights();
                    for (Integer integerObjectNumberWeight:
                            setOfNumberWeight) {
                        int numberWeight = integerObjectNumberWeight;
                        int numberLayer = 0;
                        while (newArrayWeights[numberLayer].length <= numberWeight){
                            numberWeight -= newArrayWeights[numberLayer].length;
                            numberLayer++;
                        }
                        newArrayWeights[numberLayer][numberWeight] = getWeight[numberLayer][numberWeight];
                    }
                    break;
                }
                newListOfNeuralNetworks.add(new NeuralNetwork(newArrayWeights));
            }
            listOfNeuralNetwork = newListOfNeuralNetworks;
        }
        double[][] weights = listOfNeuralNetwork.get(listOfNeuralNetwork.size() - 1).getWeights();
        for (double[] weight:
                weights) {
            for (double d:
                 weight) {
                System.out.print(d + " ");
            }
        }
    }
}
