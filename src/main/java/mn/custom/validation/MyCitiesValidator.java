
package mn.custom.validation;


import edu.umd.cs.findbugs.annotations.NonNull;
import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.core.annotation.AnnotationValue;
import io.micronaut.validation.validator.constraints.ConstraintValidator;
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext;

import javax.inject.Singleton;

@Singleton
public class MyCitiesValidator implements ConstraintValidator<MyCities, CharSequence> {

    private final CitiesConfiguration citiesConfiguration;

    public MyCitiesValidator(CitiesConfiguration citiesConfiguration) {
        this.citiesConfiguration = citiesConfiguration;
    }

    /**
     * Citiy must be included in the list of configured cities.
     *
     * @param value
     * @param annotationMetadata
     * @param context
     * @return
     */
    @Override
    public boolean isValid(
            @Nullable CharSequence value,
            @NonNull AnnotationValue<MyCities> annotationMetadata,
            @NonNull ConstraintValidatorContext context) {
        return value != null && citiesConfiguration.getCities().contains(value);
    }
}
