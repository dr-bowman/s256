package me.ilich.s256.memory;

public class Memory {

    private static final int MEMORY_SIZE = 256;

    private final byte[] memory = new byte[MEMORY_SIZE];

    private static int normalizeAddress(int address) {
        return Math.abs(address) % MEMORY_SIZE;
    }

    private int pointer;

    public Memory() {

    }

    public void reset() {
        for (int i = 0; i < MEMORY_SIZE; i++) {
            memory[i] = 0;
        }
        pointer = 0;
    }

    public int getPointer() {
        return normalizeAddress(pointer);
    }

    public void setPointer(int p) {
        pointer = normalizeAddress(p);
    }

    public void stepPoiner(int step) {
        pointer = normalizeAddress(pointer + step);
    }

    public byte getValue(int address) {
        address = normalizeAddress(address);
        return memory[address];
    }

    public void setValue(int address, byte value) {
        address = normalizeAddress(address);
        memory[address] = value;
    }

}
