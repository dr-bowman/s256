package me.ilich.s256.instructions;

import me.ilich.s256.instructions.Instruction;
import me.ilich.s256.io.IO;
import me.ilich.s256.memory.AccessStrategy;
import me.ilich.s256.memory.Memory;

public class OutputSpecialInstruction implements Instruction {

    private final AccessStrategy outputChannellAccessStrategy;
    private final AccessStrategy outputSymbolAccessStrategy;

    public OutputSpecialInstruction(AccessStrategy outputChannellAccessStrategy, AccessStrategy outputSymbolAccessStrategy) {
        this.outputChannellAccessStrategy = outputChannellAccessStrategy;
        this.outputSymbolAccessStrategy = outputSymbolAccessStrategy;
    }

    @Override
    public void execute(Memory memory, IO io) {
        byte channel = outputChannellAccessStrategy.get(memory, memory.getPointer() + 1);
        byte val = outputSymbolAccessStrategy.get(memory, memory.getPointer() + 2);
        io.output(channel, val);
        memory.stepPoiner(3);
    }
}
