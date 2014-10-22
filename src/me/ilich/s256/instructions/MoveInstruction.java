package me.ilich.s256.instructions;

import me.ilich.s256.io.IO;
import me.ilich.s256.memory.AccessStrategy;
import me.ilich.s256.memory.Memory;

/**
 * Created by ilich on 19.10.14.
 */
public class MoveInstruction implements Instruction {

    private final AccessStrategy valueAccessStrategy;

    public MoveInstruction(AccessStrategy valueAccessStrategy) {
        this.valueAccessStrategy = valueAccessStrategy;
    }

    @Override
    public void execute(Memory memory, IO io) {
        byte val = valueAccessStrategy.get(memory, memory.getPointer() + 1);
        int addr = memory.getValue(memory.getPointer() + 2);
        memory.setValue(addr, val);
        memory.stepPoiner(3);
    }

}
