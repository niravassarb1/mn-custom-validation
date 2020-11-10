
package mn.custom.validation;


import edu.umd.cs.findbugs.annotations.NonNull;
import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.core.annotation.AnnotationValue;
import io.micronaut.validation.validator.constraints.ConstraintValidator;
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext;

import javax.inject.Singleton;

@Singleton
public class MyPasswordValidator implements ConstraintValidator<MyPassword, CharSequence> {

    /**
     * Password must be at least 6 characters, alphanumeric, one capital with 2 numbers.
     * @param value
     * @param annotationMetadata
     * @param context
     * @return
     */
    @Override
    public boolean isValid(
            @Nullable CharSequence value,
            @NonNull AnnotationValue<MyPassword> annotationMetadata,
            @NonNull ConstraintValidatorContext context) {
        return value != null && value.toString().matches("^(?=.*\\d{2})(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{6,}$");
    }
}
