
package mn.custom.validation;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class CustomerValidationServiceTest {

    @Inject CustomValidationService customValidationService;

    @Test
    void testCustomValidationPassword_pass() {
        String result = customValidationService.acceptPassword("NiravAssar50");

        assertEquals("Password was accepted: NiravAssar50", result);
    }

    @Test
    void testCustomValidationPassword_fails() {
        final ConstraintViolationException exception =
                assertThrows(ConstraintViolationException.class, () ->
                        customValidationService.acceptPassword("junk")
                );

        assertTrue(exception.getMessage().contains("acceptPassword.password"));
    }

    @Test
    void testCustomValidationPassword_fails_null() {
        final ConstraintViolationException exception =
                assertThrows(ConstraintViolationException.class, () ->
                        customValidationService.acceptPassword(null)
                );

        assertTrue(exception.getMessage().contains("acceptPassword.password"));
    }


    /****************************************************/

    @Test
    void testCustomValidationCity_pass() {
        String result = customValidationService.acceptCity("Dallas");

        assertEquals("City was accepted: Dallas", result);
    }

    @Test
    void testCustomValidationCity_fails() {
        final ConstraintViolationException exception =
                assertThrows(ConstraintViolationException.class, () ->
                        customValidationService.acceptCity("junk")
                );

        assertEquals("acceptCity.city: invalid city (junk)", exception.getMessage());
    }

    @Test
    void testCustomValidationCity_fails_null() {
        final ConstraintViolationException exception =
                assertThrows(ConstraintViolationException.class, () ->
                        customValidationService.acceptCity(null)
                );

        assertEquals("acceptCity.city: invalid city (validatedValue)", exception.getMessage());
    }
}
