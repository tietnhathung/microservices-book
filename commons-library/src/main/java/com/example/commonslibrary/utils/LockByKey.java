package com.example.commonslibrary.utils;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class LockByKey {
    private final Set<String> lockKeys = new HashSet<>();

    public synchronized void lock(String key) throws InterruptedException {
        while (lockKeys.contains(key)) {
            wait();
        }
        lockKeys.add(key);
    }

    public synchronized void unlock(String key) {
        lockKeys.remove(key);
        notifyAll();
    }
}
