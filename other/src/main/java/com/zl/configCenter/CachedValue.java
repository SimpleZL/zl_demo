package com.zl.configCenter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2020-01-19
 */
public abstract class CachedValue<T> {

    private volatile boolean isCached;
    private volatile IllegalArgumentException exception;
    private volatile T value;
    private Object lock = new Object();
    private String stringValue = null;

    public CachedValue() {
        flush();
    }

    final void flush() {
        isCached = false;
        exception = null;
        value = null;
    }

    /**
     * Gets the cached value.
     * If the value has not yet been parsed from the string value,
     * parse it now.
     *
     * @return the parsed value, or null if there was no string value
     * @throws IllegalArgumentException if there was a problem
     */
    public T getValue() throws IllegalArgumentException {
        // Not quite double-check locking -- since isCached is marked as volatile
        if (!isCached) {
            synchronized (lock) {
                try {
                    value = (stringValue == null) ? null : parse(stringValue);
                    exception = null;
                } catch ( Exception e ) {
                    value = null;
                    exception = new IllegalArgumentException(e);
                } finally {
                    isCached = true;
                }
            }
        }
        if (exception != null) {
            throw exception;
        } else {
            return value;
        }
    }

    /**
     * Gets the cached value.
     * If the value has not yet been parsed from the string value,
     * parse it now.
     * If there is no string value, or there was a parse error,
     * returns the given default value.
     *
     * @param defaultValue the value to return if there was a problem
     * @return the parsed value, or the default if there was no
     * string value or a problem during parse
     */
    public T getValue(T defaultValue) {
        try {
            T result = getValue();
            return (result == null) ? defaultValue : result;
        } catch ( IllegalArgumentException e ) {
            return defaultValue;
        }
    }

    @Override
    public String toString() {
        if (!isCached) {
            return "{not cached}";
        } else if (exception != null) {
            return "{Exception: " + exception + "}";
        } else {
            return "{Value: " + value + "}";
        }
    }

    /**
     * Parse a string, converting it to an object of the value type.
     *
     * @param rep the string representation to parse
     * @throws Exception if the parse failed
     * @returns the parsed value
     */
    protected abstract T parse(String rep) throws Exception;
}
