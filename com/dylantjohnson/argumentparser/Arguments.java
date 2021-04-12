package com.dylantjohnson.argumentparser;

import java.util.*;

/**
 * This class holds parsed program arguments.
 */
public class Arguments {
    private List<Option> mOptions;
    private Map<String, OptionValue> mArguments = new HashMap<>();

    Arguments(List<Option> options, String[] args) {
        mOptions = options;

        for (var i = 0; i < args.length; ++i) {
            var option = getOption(args[i]);
            if (option.isFlag()) {
                mArguments.put(option.getKey(), OptionValue.create(option, true));
            } else {
                mArguments.put(option.getKey(), OptionValue.create(option, Optional.of(args[++i])));
            }
        }
    }

    /**
     * Get the value for a given option.
     *
     * @param option the option to check
     * @return the value of the option
     */
    public OptionValue get(Option option) {
        var value = mArguments.get(option.getKey());
        if (value != null) {
            return value;
        }

        return option.isFlag()
            ? OptionValue.create(option, false)
            : OptionValue.create(option, Optional.empty());
    }

    private Option getOption(String key) {
        for (Option option : mOptions) {
            if (option.getKey().equals(key)) {
                return option;
            }
        }

        throw new IllegalArgumentException(String.format("%s is not a defined option", key));
    }
}
