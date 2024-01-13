package nerualnetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NeuralNetwork {

    private static final Random random = new Random();
    private double[][] weights = new double[3][];
    private static final int[] arrayWithAmountNeurons = new int[3];
    static {
        arrayWithAmountNeurons[0] = 2;
        arrayWithAmountNeurons[1] = 2;
        arrayWithAmountNeurons[2] = 1;
    }

    public NeuralNetwork (){
        weights[0] = new double[]{generateRandomDouble(), generateRandomDouble(),
                generateRandomDouble(), generateRandomDouble()};
        weights[1] =  new double[]{generateRandomDouble(), generateRandomDouble(),
                generateRandomDouble(), generateRandomDouble()};
        weights[2] = new double[]{generateRandomDouble(), generateRandomDouble()};
    }

    public NeuralNetwork (double[][] weights){
        this.weights = weights;
        if (random.nextInt(1000) == 1){
            int numberWeight = random.nextInt(10);
            int numberLayer = 0;
            while (weights[numberLayer].length <= numberWeight){
                numberWeight -= weights[numberLayer].length;
                numberLayer++;
            }
            weights[numberLayer][numberWeight] = weights[numberLayer][numberWeight];
        }
    }

    public double[][] getWeights() {
        return weights;
    }

    public void setWeights(double[][] weights) {
        this.weights = weights;
    }

    public double calculate(double a, double b){
        List<Double> listOfNeurons = new ArrayList<>(List.of(a, b));
        List<Double> listOfWights = new ArrayList<>(weights[0].length);
        for (int numberLayer = 0; numberLayer < weights.length; numberLayer++) {
            addTheResultOfMultiplyingTheNeuronByWeightTolistOfWights(numberLayer, listOfNeurons, listOfWights);

            listOfNeurons.clear();

            addTheResultOfSummingWeightsToTheListOfNeurons(numberLayer, listOfWights, listOfNeurons);

            listOfWights.clear();
        }
        return listOfNeurons.get(0);
    }

    private void addTheResultOfMultiplyingTheNeuronByWeightTolistOfWights(int numberLayer, List<Double> listOfNeurons,
                                                                          List<Double> listOfWights){
        for (int numberWight = 0; numberWight < weights[numberLayer].length; numberWight++) {
            listOfWights.add(
                    weights[numberLayer][numberWight] * listOfNeurons.get(numberWight % listOfNeurons.size())
            );
        }
    }
    private void addTheResultOfSummingWeightsToTheListOfNeurons(int numberLayer, List<Double> listOfWights,
                                                                List<Double> listOfNeurons){
        double amountNeurons = arrayWithAmountNeurons[numberLayer];
        double sumWight = 0;
        if(amountNeurons == 1){
            for (Double listOfWight : listOfWights) {
                sumWight += listOfWight;
            }
            listOfNeurons.add(sumWight);
            return;
        }
        for (int indexWight = 0; indexWight < listOfWights.size(); indexWight++) {
            sumWight += listOfWights.get(indexWight);
            if ((indexWight + 1) % amountNeurons == 0 ){
                listOfNeurons.add(sumWight);
                sumWight = 0;
            }
        }
    }

    private double generateRandomDouble(){
        return random.nextDouble() + random.nextInt(2) - 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NeuralNetwork that = (NeuralNetwork) o;
        return Arrays.equals(weights, that.weights);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(weights);
    }
}
