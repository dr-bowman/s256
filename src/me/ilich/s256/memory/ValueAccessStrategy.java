package me.ilich.s256.memory;

public class ValueAccessStrategy implements AccessStrategy {
    @Override
    public byte get(Memory memory, int address) {
        byte value = memory.getValue(address);
        return value;
    }
}
