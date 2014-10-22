package me.ilich.s256.io;

public class ByteOutputChannel implements OutputChannel {

    @Override
    public void out(byte val) {
        System.out.println(val);
    }

}
