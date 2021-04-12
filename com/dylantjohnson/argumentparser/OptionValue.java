package com.dylantjohnson.argumentparser;

import java.util.*;

/**
 * After parsing arguments, this class provides the value of a given option.
 */
public abstract class OptionValue {
    protected Option mOption;

    OptionValue(Option Option) {
        mOption = Option;
    }

    public Option getOption() {
        return mOption;
    }

    /**
     * If the related option is value-based, get the set value.
     *
     * @return the String value of the option, if there is one
     * @throws IllegalArgumentException if the option is flag-based
     */
    public abstract Optional<String> getValue() throws IllegalArgumentException;

    /**
     * If the related option is flag-based, check if it's set.
     *
     * @return if the flag is set or not
     * @throws IllegalArgumentException if the option is value-based
     */
    public abstract boolean isSet() throws IllegalArgumentException;

    static OptionValue create(Option option, Optional<String> value) {
        return new OptionStringValue(option, value);
    }

    static OptionValue create(Option option, boolean value) {
        return new OptionFlagValue(option, value);
    }
}

class OptionStringValue extends OptionValue {
    private String mValue;

    public OptionStringValue(Option Option, Optional<String> value) {
        super(Option);
        mValue = value.orElse(null);
    }

    @Override
    public Optional<String> getValue() throws IllegalArgumentException {
        return Optional.ofNullable(mValue);
    }

    @Override
    public boolean isSet() throws IllegalArgumentException {
        throw new IllegalArgumentException(String.format("%s is not a flag-setting Option", mOption.getKey()));
    }
}

class OptionFlagValue extends OptionValue {
    private boolean mValue;

    public OptionFlagValue(Option Option, boolean value) {
        super(Option);
        mValue = value;
    }

    @Override
    public Optional<String> getValue() throws IllegalArgumentException {
        throw new IllegalArgumentException(String.format("%s is not a value-setting Option", mOption.getKey()));
    }

    @Override
    public boolean isSet() throws IllegalArgumentException {
        return mValue;
    }
}
