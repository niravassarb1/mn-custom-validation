
package mn.custom.validation;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@MicronautTest
class CustomerValidationServiceSpec {

    @Inject CustomValidationService customValidationService;

    @Test
    void testCustomValidationPassword_fails() {
        final ConstraintViolationException exception =
                assertThrows(ConstraintViolationException.class, () ->
                        customValidationService.acceptPassword("junk")
                );

        assertEquals("acceptPassword.password: invalid password (junk)", exception.getMessage());
    }

    @Test
    void testCustomValidationPassword_fails_null() {
        final ConstraintViolationException exception =
                assertThrows(ConstraintViolationException.class, () ->
                        customValidationService.acceptPassword(null)
                );

        assertEquals("acceptPassword.password: invalid password (validatedValue)", exception.getMessage());
    }

    @Test
    void testCustomValidationPassword_pass() {

        String result = customValidationService.acceptPassword("NiravAssar50");

        assertEquals("Password was accepted: NiravAssar50", result);
    }
}
