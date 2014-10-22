package me.ilich.s256.memory;

public class AddressAccessStrategy implements AccessStrategy {
    @Override
    public byte get(Memory memory, int address) {
        byte addr = memory.getValue(address);
        byte value = memory.getValue(addr);
        return value;
    }
}
