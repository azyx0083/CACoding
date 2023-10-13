package entity;

public class UsernameValidatorService implements UsernameValidator{
    @Override
    public boolean usernameIsValid(String username) {
        return !username.isEmpty() && username.length() <= 7;
    }
}
