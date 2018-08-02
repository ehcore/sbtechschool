package exceptions;

public class NoSuchOperationException extends RecipeAppException {
    @Override
    public String getMessage() {
        return "Нет такой операции. Повторите ввод.";
    }
}
