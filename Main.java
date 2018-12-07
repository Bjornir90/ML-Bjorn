import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Float> testDataA = new ArrayList<>(), testDataB = new ArrayList<>(), expectedResult = new ArrayList<>();
        testDataA.add(1.0f);
        testDataB.add(1.0f);
        expectedResult.add(1.0f);
        testDataA.add(0.0f);
        testDataB.add(1.0f);
        expectedResult.add(0.0f);
        testDataA.add(1.0f);
        testDataB.add(0.0f);
        expectedResult.add(0.0f);
        testDataA.add(0.0f);
        testDataB.add(0.0f);
        expectedResult.add(0.0f);
        InputPerceptron ipa = new InputPerceptron(), ipb = new InputPerceptron();
        OutputPerceptron op = new OutputPerceptron(2, 0.3f);
        op.addInput(ipa);
        op.addInput(ipb);
        do {
            for (int i = 0; i < expectedResult.size(); i++) {
                ipa.newData(testDataA.get(i));
                ipb.newData((testDataB.get(i)));
                op.setExpectedOutput(expectedResult.get(i));
                op.learn();
                System.out.println(testDataA.get(i) + " & " + testDataB.get(i) + " = " +op.computeOutput()+ " Error : "+op.getError());
            }
        }while( op.getError()>0.0001f);

        System.out.println("LEARNING FINISHED");
        for (int i = 0; i < expectedResult.size(); i++) {
            ipa.newData(testDataA.get(i));
            ipb.newData((testDataB.get(i)));
            op.setExpectedOutput(expectedResult.get(i));
            System.out.println(testDataA.get(i) + " & " + testDataB.get(i) + " = " +op.computeOutput()+ " Error : "+op.getError());
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("Weight : "+op.weights[i]);
        }

    }
}
