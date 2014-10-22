package me.ilich.s256.memory;

public interface AccessStrategy {

    byte get(Memory memory, int address);

}
