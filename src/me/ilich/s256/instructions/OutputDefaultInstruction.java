package me.ilich.s256.instructions;

import me.ilich.s256.io.IO;
import me.ilich.s256.memory.AccessStrategy;
import me.ilich.s256.memory.Memory;
import me.ilich.s256.instructions.Instruction;

public class OutputDefaultInstruction implements Instruction {

    private final AccessStrategy outputSymbolAccessStrategy;

    public OutputDefaultInstruction(AccessStrategy outputSymbolAccessStrategy) {
        this.outputSymbolAccessStrategy = outputSymbolAccessStrategy;
    }

    @Override
    public void execute(Memory memory, IO io) {
        byte val = outputSymbolAccessStrategy.get(memory, memory.getPointer()+1);
        io.outputDefault(val);
        memory.stepPoiner(2);
    }

}
