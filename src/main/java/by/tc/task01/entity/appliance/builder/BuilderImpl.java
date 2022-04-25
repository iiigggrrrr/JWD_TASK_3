package by.tc.task01.entity.appliance.builder;

import by.tc.task01.service.validation.Validator;

public abstract class BuilderImpl<T, RetBuilder> {
    private final T newProduct;
    private RetBuilder returnBuilder;

    protected BuilderImpl(T child) {
        newProduct = child;
    }

    protected T getNewProduct() {
        return newProduct;
    }

    protected void injectReturnBuilder(RetBuilder builder) {
        returnBuilder = builder;
    }

    protected RetBuilder self() {
        return returnBuilder;
    }

    public T build() {

        // Validation here !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if (validator()) {
            return newProduct;
        }

        throw new IllegalArgumentException("Some parameters in product is illegal. Check validator.");
    }

    protected abstract boolean validator();
}
