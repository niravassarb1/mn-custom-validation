
package mn.custom.validation;

import javax.inject.Singleton;

@Singleton
public class CustomValidationService {

    public String acceptCity(@MyCities String city) {
        return "City was accepted: " + city;
    }

    public String acceptPassword(@MyPassword String password) {
        return "Password was accepted: " + password;
    }
}
