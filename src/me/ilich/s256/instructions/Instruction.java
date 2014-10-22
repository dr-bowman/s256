package me.ilich.s256.instructions;

import me.ilich.s256.io.IO;
import me.ilich.s256.memory.Memory;

public interface Instruction {

    void execute(Memory memory, IO io);

}
