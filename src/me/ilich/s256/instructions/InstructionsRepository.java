package me.ilich.s256.instructions;

import me.ilich.s256.memory.AddressAccessStrategy;
import me.ilich.s256.memory.ValueAccessStrategy;

import java.util.HashMap;
import java.util.Map;

public class InstructionsRepository {

    public static final byte NOP = 0;
    public static final byte OPDV = 10;
    //public static final byte OPSV = 11;
    public static final byte JMPV = 20;
    public static final byte JMPA = 21;
    public static final byte MOVA = 30;
    public static final byte MOVV = 31;


    private static final Map<Byte, Instruction> map = new HashMap<Byte, Instruction>();
    private static final Instruction defaultInstruction = new NothingInstruction();

    static {
        map.put(NOP, new NothingInstruction());
        map.put(OPDV, new OutputDefaultInstruction(new ValueAccessStrategy()));
        //map.put(OPSV, new OutputSpecialInstruction(new ValueAccessStrategy(), new ValueAccessStrategy()));
        map.put(JMPV, new JumpInstruction(new ValueAccessStrategy()));
        map.put(JMPA, new JumpInstruction(new AddressAccessStrategy()));
        map.put(MOVA, new MoveInstruction(new AddressAccessStrategy()));
        map.put(MOVV, new MoveInstruction(new ValueAccessStrategy()));
    }

    public static Instruction get(byte ins) {
        final Instruction result;
        if (map.containsKey(ins)) {
            result = map.get(ins);
        } else {
            result = defaultInstruction;
        }
        return result;
    }

}
