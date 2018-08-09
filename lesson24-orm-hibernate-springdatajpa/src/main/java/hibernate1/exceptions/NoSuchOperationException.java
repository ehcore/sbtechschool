package hibernate1.exceptions;

public class NoSuchOperationException extends RecipeAppException {
    @Override
    public String getMessage() {
        return "Данная операция не поддерживается. Повторите ввод.";
    }
}
