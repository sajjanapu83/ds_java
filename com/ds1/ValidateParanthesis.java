import java.util.Stack;

public class ValidateParanthesis {

    public boolean validate(String input) {
        Stack<Character> validationStack = new Stack<>();

        for (Character ch : input.toCharArray()) {
            if (isLeftBracket(ch))
                validationStack.push(ch);

            if (isRightBracket(ch)) {
                if (validationStack.isEmpty())
                    return false;

                var top = validationStack.pop();
                if (bracketNotMatching(ch, top))
                    return false;
            }
        }
        return validationStack.isEmpty();
    }

    private boolean isLeftBracket(Character ch) {
        return ch == '(' || ch == '{' || ch == '[' || ch == '<';
    }

    private boolean isRightBracket(Character ch) {
        return ch == ')' || ch == '}' || ch == ']' || ch == '>';
    }

    private boolean bracketNotMatching(Character ch, Character top) {
        return (ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')
                || (ch == '>' && top != '<');
    }
}
