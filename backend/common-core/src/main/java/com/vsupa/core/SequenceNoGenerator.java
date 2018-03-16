package com.vsupa.core;

import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 流水号生成器；
 * @author Maxwell.Lee
 * @date 2018-03-13 17:56
 * @since   1.0.0
 */
public class SequenceNoGenerator {

    private String  pattern;

    private Random  rand;

    private AtomicLong  counter;

    public SequenceNoGenerator() {
        this("%02d%02d%02d%02d%02d%02d%04d");
    }

    public SequenceNoGenerator(String pattern) {
        this.pattern = pattern;
        this.rand = new Random(System.currentTimeMillis());
        this.counter = new AtomicLong(0L);
    }

    public String next() {
        Calendar    cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        long no = Math.abs(rand.nextInt(99999999)  + counter.incrementAndGet());

        return String.format(pattern, year % 100, month, dayOfMonth, hour, minute, second, no % 9999);
    }

}
