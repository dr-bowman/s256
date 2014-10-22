package me.ilich.s256.io;

public class CharOutputChannel implements OutputChannel {

    @Override
    public void out(byte val) {
        System.out.print((char) val);
    }

}
