package com.dylantjohnson.argumentparser;

import java.util.*;

/**
 * This class parses program arguments.
 */
public class ArgumentParser {
    private List<Option> mOptions;

    /**
     * Configure the parser with supported options.
     *
     * @param options the supported options
     */
    public ArgumentParser(Option... options) {
        mOptions = List.of(options);
    }

    /**
     * Parse arguments.
     *
     * @param args The arguments to parse
     * @return the parsed arguments
     */
    public Arguments parse(String[] args) {
        return new Arguments(mOptions, args);
    }
}
