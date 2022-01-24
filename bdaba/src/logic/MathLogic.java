package logic;

import java.util.ArrayList;
import java.util.List;

public class MathLogic implements IMathLogic {

    @Override
    public boolean validate(String model, String actual) {
        if (actual.length() == 0 && !Character.isDigit(model.charAt(0))) return false;
        if (actual.isEmpty()) return true;
        if (actual.contains("MOD") && model.equals("MOD")) return false;
        if (actual.charAt(actual.length() - 1) == '0'
                && (model.charAt(0) == '/' && actual.length() == 1 || (Character.isDigit(model.charAt(0))
                && actual.length() == 1))) return false;

        char[] operators = {'*', '+', '-', '/', '.'};

        if (model.contains(".") && actual.contains(".")) return false;

        boolean got = false, have = false;
        for (char x : operators) if (model.charAt(0) == x) got = true;
        for (char x : operators) if (actual.charAt(actual.length() - 1) == x) have = true;
        if (got && have) return false;

        return true;
    }

    @Override
    public String calculate(String model) {
        int l = model.length();
        if (!Character.isDigit(model.charAt(l - 1))) return "";
        boolean minus = false;

        if (model.contains("MOD")) {
            double val1 = Double.parseDouble(model.substring(0, model.indexOf("M")));
            double val2 = Double.parseDouble(model.substring(model.indexOf("D")+1));
            return ""+(val1 % val2);
        }

        StringBuilder sb = new StringBuilder();
        List<Character> operations = new ArrayList<>();
        List<Double> nums = new ArrayList<>();

        for (char x : model.toCharArray()) {
            if (x == '-') {
                minus = true;
                continue;
            }
            if (Character.isDigit(x) || x == '.') {
                sb.append(x);
            } else {
                operations.add(x);
                nums.add(Double.parseDouble(sb.toString()));
                sb = new StringBuilder();
            }
        }
        nums.add(Double.parseDouble(sb.toString()));

        double res = minus ? nums.get(0) * -1 : nums.get(0);
        int i = 1;
        for (char x : operations) {
            switch (x) {
                case '*': {
                    res *= nums.get(i);
                    break;
                }
                case '/': {
                    res /= nums.get(i);
                    break;
                }
                case '+': {
                    res += nums.get(i);
                    break;
                }
                case '-': {
                    res -= nums.get(i);
                    break;
                }
            }
            ++i;
        }
        String result = res+"";
        return !result.contains(".") && result.length() > 18 ? "INF" : result;
    }

    @Override
    public String sqrt(String model) {
        boolean validation = true;
        for (char x : model.toCharArray()) {
            if (!Character.isDigit(x) && x != '.') {
                validation = false;
            }
        }
        if (!validation) return model;

        return Math.sqrt(Double.valueOf(model))+"";
    }

    private boolean validateValue(String model) {
        boolean validation = !model.contains(" ");
        for (char x : model.toCharArray()) {
            if (!Character.isDigit(x) && x != '.') {
                validation = false;
            }
        }
        return validation;
    }

    private double prepareValue(String model) {
        boolean validate = validateValue(model);
        if (!validate) return Long.MAX_VALUE;

        return Double.parseDouble(model);
    }

    @Override
    public String log(String model) {
        double val = prepareValue(model);
        return Math.log(val)+"";
    }

    @Override
    public String sin(String model) {
        double val = prepareValue(model);
        return Math.sin(val)+"";
    }

    @Override
    public String cos(String model) {
        double val = prepareValue(model);
        return Math.cos(val)+"";
    }

    @Override
    public String pi() {
        return Math.PI+"";
    }

    @Override
    public String inx(String model) {
        double val = prepareValue(model);
        return Math.log10(val)+"";
    }

    @Override
    public String mod() {
        return " MOD ";
    }

    @Override
    public String tan(String model) {
        double val = prepareValue(model);
        return Math.tan(val)+"";
    }

    @Override
    public String sinh(String model) {
        double val = prepareValue(model);
        return Math.sinh(val)+"";
    }

    @Override
    public String cosh(String model) {
        double val = prepareValue(model);
        return Math.cosh(val)+"";
    }

    @Override
    public String tanh(String model) {
        double val = prepareValue(model);
        return Math.tanh(val)+"";
    }

    @Override
    public String x2(String model) {
        double val = prepareValue(model);
        return (val * val)+"";
    }

    @Override
    public String x3(String model) {
        double val = prepareValue(model);
        return (val * val * val)+"";
    }

    @Override
    public String round(String model) {
        double val = prepareValue(model);
        return Math.round(val)+"";
    }

    @Override
    public String bin(String model) {
        int val = (int) prepareValue(model);
        return Integer.toString(val, 2);
    }

    @Override
    public String hex(String model) {
        double val = prepareValue(model);
        return Double.toHexString(val);
    }

    @Override
    public String plusMinus(String model) {
        return model.startsWith("-") ? model.substring(1) : "-"+model;
    }
}
