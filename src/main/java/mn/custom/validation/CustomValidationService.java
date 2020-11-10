
package mn.custom.validation;

import javax.inject.Singleton;

@Singleton
public class CustomValidationService {

    public String acceptCityName(String cityName) {
        return "";
    }

    public String acceptPassword(@MyPassword String password) {
        return "Password was accepted: " + password;
    }
}
