package com.dylantjohnson.argumentparser;

/**
 * A supported option that can be used to configure an ArgumentParser.
 */
public class Option {
    private String mKey;
    private boolean mIsFlag;

    /**
     * Create an option with a given key.
     *
     * @param key the key for this option
     * @param isFlag whether this option is flag- or value-based
     */
    public Option(String key, boolean isFlag) {
        mKey = key;
        mIsFlag = isFlag;
    }

    /**
     * Get the key for this option.
     *
     * @return the key for this option
     */
    public String getKey() {
        return mKey;
    }

    /**
     * Check if this option is flag-based.
     *
     * @return if this option is flag-based
     */
    public boolean isFlag() {
        return mIsFlag;
    }
}
