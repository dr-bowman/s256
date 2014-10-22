package me.ilich.s256.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ilich on 18.10.14.
 */
public class IO {

    public static final byte OUT_BYTE = 0;
    public static final byte OUT_CHAR = 1;

    private static final Map<Byte, OutputChannel> outMap = new HashMap<Byte, OutputChannel>();
    private static final OutputChannel defaultOut = new CharOutputChannel();

    private static OutputChannel getOut(byte id) {
        final OutputChannel result;
        if (outMap.containsKey(id)) {
            result = outMap.get(id);
        } else {
            result = defaultOut;
        }
        return result;
    }

    static {
        outMap.put(OUT_CHAR, new CharOutputChannel());
        outMap.put(OUT_BYTE, new ByteOutputChannel());
    }

    public void outputDefault(byte val) {
        defaultOut.out(val);
    }

    public void output(byte channel, byte val) {
        getOut(channel).out(val);
    }

}
