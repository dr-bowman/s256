package me.ilich.s256;

import me.ilich.s256.instructions.Instruction;
import me.ilich.s256.instructions.InstructionsRepository;
import me.ilich.s256.io.IO;
import me.ilich.s256.memory.Memory;

public class S256 {

    private static final int MAX_TICKS = 2000;

    private Memory memory = new Memory();
    private IO io = new IO();

    public S256() {

    }

    public void init() {
        memory.reset();
    }

    public void load(byte[] prg) {
        for (int i = 0; i < prg.length; i++) {
            byte val = prg[i];
            memory.setValue(i, val);
        }
    }

    public void execute() {
        int tick = 0;
        boolean work = true;
        do {
            //System.out.println("# " + tick);
            int pointer = memory.getPointer();
            byte val = memory.getValue(pointer);
            Instruction instruction = InstructionsRepository.get(val);
            instruction.execute(memory, io);
            tick++;
            work = tick < MAX_TICKS;
        } while (work);
    }

}
