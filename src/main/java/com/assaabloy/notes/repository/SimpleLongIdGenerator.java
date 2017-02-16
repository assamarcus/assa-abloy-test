package com.assaabloy.notes.repository;

public class SimpleLongIdGenerator {

    protected volatile long value;

    protected long initialValue;
    protected long maxValue;
    protected boolean cycle;

    /**
     * Creates a new default cycled id generator. Starts from 1 and counts up to max long value.
     */
    public SimpleLongIdGenerator() {
        this(1, Long.MAX_VALUE, true);
    }

    /**
     * Creates a new cycled id generator with specified initial value.
     */
    public SimpleLongIdGenerator(long initialValue) {
        this(initialValue, Long.MAX_VALUE, true);
    }

    /**
     * Creates a new cycled id generator with specified range.
     */
    public SimpleLongIdGenerator(long initialValue, long maxValue) {
        this(initialValue, maxValue, true);
    }

    /**
     * Creates a new id generator with specified range and cycling flag.
     */
    public SimpleLongIdGenerator(long initialValue, long maxValue, boolean cycle) {
        if (initialValue < 0) {
            throw new IllegalArgumentException("Initial value '" + initialValue + "' must be a positive number.");
        }
        if (maxValue <= initialValue) {
            throw new IllegalArgumentException("Max value '" + maxValue + "' is less or equals to initial value '" + initialValue + "'.");
        }
        this.initialValue = this.value = initialValue;
        this.maxValue = maxValue;
        this.cycle = cycle;
    }

    /**
     * Returns the next value from the sequence. Thread-safe.
     */
    public synchronized long next() {
        long id = value;

        value++;
        if ((value > maxValue) || (value < 0)) {
            if (cycle == false) {
                throw new IllegalStateException("Max value already reached.");
            }
            value = initialValue;
        }
        return id;
    }
}
