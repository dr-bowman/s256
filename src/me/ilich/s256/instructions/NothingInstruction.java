package me.ilich.s256.instructions;

import me.ilich.s256.io.IO;
import me.ilich.s256.memory.Memory;
import me.ilich.s256.instructions.Instruction;

public class NothingInstruction implements Instruction {

    @Override
    public void execute(Memory memory, IO io) {
        memory.stepPoiner(1);
    }
}
