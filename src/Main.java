import nerualnetwork.NeuralNetwork;

import javax.swing.plaf.IconUIResource;
import java.util.*;

public class Main {
    public final static Random random = new Random();

    public static void main(String[] args) {
        List<NeuralNetwork> listOfNeuralNetwork = new ArrayList<>(5_000_000);
        for (int j = 0; j < 1000_000; j++) {
            NeuralNetwork neuralNetwork = new NeuralNetwork();
            listOfNeuralNetwork.add(neuralNetwork);
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("Покаление №" + i);
            double a = random.nextDouble()*100;
            double b = random.nextDouble()*100;
            int sizeListOfNeuralNetwork = listOfNeuralNetwork.size();
            List<NeuralNetwork> newListOfNeuralNetworks = new ArrayList<>(5_000_000);

            for (int j = 0; j < sizeListOfNeuralNetwork; j++) {
                NeuralNetwork neuralNetwork = listOfNeuralNetwork.get(j);
<<<<<<< HEAD
                increaseTheProbabilityOfReproduction(a, b,
                        listOfNeuralNetwork, neuralNetwork);
=======
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
>>>>>>> origin/main
            }

            for (int j = 0; j < 100; j++) {
                Set<NeuralNetwork> setOfNeuralNetwork = new HashSet<>();
                double[][] newArrayWeights = new double[3][];
                newArrayWeights[0] = new double[4];
                newArrayWeights[1] = new double[4];
                newArrayWeights[2] = new double[2];

                Set<Integer> setOfNumberWeight = new HashSet<>();
                while (setOfNumberWeight.size() < 5){
                    setOfNumberWeight.add(random.nextInt(10));
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
            theBestResult(listOfNeuralNetwork);
        }


    }

    private static void theBestResult(List<NeuralNetwork> listOfNeuralNetwork){
        double minValue = Double.MAX_VALUE;
        int indexNeuralNetwork = 0;
        double a = random.nextDouble()*1000;
        double b = random.nextDouble()*1000;;
        for (int i = 0; i < listOfNeuralNetwork.size(); i++) {
            double calculate = listOfNeuralNetwork.get(i).calculate(a, b);
            double result = Math.abs(a+b - calculate);
            if(result < minValue){
                minValue = result;
                indexNeuralNetwork = i;
            }
        }
        System.out.println("a + b = " + (a+b));
        System.out.println(minValue);
        NeuralNetwork theBestNeuralNetwork = listOfNeuralNetwork.get(indexNeuralNetwork);
        double[][] weights = theBestNeuralNetwork.getWeights();
        for (double[] weight:
                weights) {
            for (double d:
                    weight) {
                System.out.print(d + " ");
            }
        }
        System.out.println();
        System.out.println("calculate = " + theBestNeuralNetwork.calculate(a,b));
    }
    private static void increaseTheProbabilityOfReproduction(double a, double b,
                                                             List<NeuralNetwork> listOfNeuralNetwork, NeuralNetwork neuralNetwork){
        if(hasTheProbabilityOfReproductionIncreased(a, b,
                0.01, 1000_000,
                listOfNeuralNetwork, neuralNetwork)){
            return;
        }
        if(hasTheProbabilityOfReproductionIncreased(a, b,
                1, 10000,
                listOfNeuralNetwork, neuralNetwork)){
            return;
        }
        if(hasTheProbabilityOfReproductionIncreased(a, b,
                2, 500,
                listOfNeuralNetwork, neuralNetwork)){
            return;
        }
        if(hasTheProbabilityOfReproductionIncreased(a, b,
                5, 300,
                listOfNeuralNetwork, neuralNetwork)){
            return;
        }
        if(hasTheProbabilityOfReproductionIncreased(a, b,
                10, 100,
                listOfNeuralNetwork, neuralNetwork)){
            return;
        }
        if(hasTheProbabilityOfReproductionIncreased(a, b,
                10, 100,
                listOfNeuralNetwork, neuralNetwork)){
            return;
        }
        if(hasTheProbabilityOfReproductionIncreased(a, b,
                20, 25,
                listOfNeuralNetwork, neuralNetwork)){
            return;
        }
        hasTheProbabilityOfReproductionIncreased(a, b,
                100, 5,
                listOfNeuralNetwork, neuralNetwork);
    }

    private static boolean hasTheProbabilityOfReproductionIncreased(double a, double b,
                                                                    double range, int increaseTheProbabilityOf,
                                                                    List<NeuralNetwork> listOfNeuralNetwork, NeuralNetwork neuralNetwork){
        double calculate = neuralNetwork.calculate(a, b);
        if(calculate > a+b-range && calculate < a+b+range){
            for (int i = 0; i < increaseTheProbabilityOf; i++) {
                listOfNeuralNetwork.add(neuralNetwork);
            }
            return true;
        }
        return false;
    }
}
