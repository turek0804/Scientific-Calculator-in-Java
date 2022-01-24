package logic;

public interface IMathLogic {

    boolean validate(String model, String actual);

    String calculate(String model);

    String sqrt(String model);

    String mod();

    String log(String model);

    String sin(String model);

    String cos(String model);

    String pi();

    String inx(String model);

    String tan(String model);

    String sinh(String model);

    String cosh(String model);

    String tanh(String model);

    String x2(String model);

    String x3(String model);

    String round(String model);

    String bin(String model);

    String hex(String model);

    String plusMinus(String model);
}
