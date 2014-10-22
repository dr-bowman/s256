package me.ilich;

import me.ilich.s256.S256;
import me.ilich.s256.instructions.InstructionsRepository;

import java.util.Random;

public class Main {


    public static void main(String[] args) {

        byte[] prg = new byte[]{
                InstructionsRepository.OPDV,
                65,
                InstructionsRepository.OPDV,
                66,
                InstructionsRepository.JMPA,
                6,
                0
        };

        byte[] prg1 = new byte[256];
        Random r = new Random();
        for(int i=0; i<256; i++){
            prg1[i] = (byte) r.nextInt(256);
        }

        S256 s256 = new S256();
        s256.init();
        s256.load(prg1);
        s256.execute();
    }
}
