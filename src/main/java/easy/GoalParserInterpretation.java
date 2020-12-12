package easy;

public class GoalParserInterpretation {
    public static String interpret(String command) {
        var cArray = command.toCharArray();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < cArray.length; i++) {
            if (cArray[i] == 'G') {
                str.append("G");
            } else if (cArray[i] == '(' && cArray[i + 1] == ')') {
                str.append("o");
                i++;
            } else {
                str.append("al");
                i += 3;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(GoalParserInterpretation.interpret("G()(al)"));
    }
}
