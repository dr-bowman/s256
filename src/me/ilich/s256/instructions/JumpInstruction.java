package me.ilich.s256.instructions;

import me.ilich.s256.instructions.Instruction;
import me.ilich.s256.io.IO;
import me.ilich.s256.memory.AccessStrategy;
import me.ilich.s256.memory.Memory;

public class JumpInstruction implements Instruction {

    private final AccessStrategy jumpToAccessStrategy;

    public JumpInstruction(AccessStrategy jumpToAccessStrategy) {
        this.jumpToAccessStrategy = jumpToAccessStrategy;
    }

    @Override
    public void execute(Memory memory, IO io) {
        byte val = jumpToAccessStrategy.get(memory, memory.getPointer() + 1);
        memory.setPointer(val);
    }

}
