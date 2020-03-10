package com.dagamer.mall.sso.test;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SsoTester {

    @Test
    public void test1() {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        for (int i=0;i<10;i++)
        System.out.println(bcrypt.encode("1"));
    }

    @Test
    public void test2() {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        System.out.println(bcrypt.matches("1", "$2a$10$jNmjUzk6tAEvjh6Mq4Tev.vGAeAT/xESAdXW4Qv0uULZOQq3snQSO"));
    }

    @Test
    public void test3() throws NoSuchAlgorithmException {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        for (int i=0;i<10;i++)
        System.out.println(bcrypt.encode(new String(new Hex().encode(md.digest("1".getBytes())))));
    }

}
