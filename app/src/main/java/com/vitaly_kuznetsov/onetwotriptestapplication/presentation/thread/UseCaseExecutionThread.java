package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.thread;

import com.vitaly_kuznetsov.onetwotriptestapplication.domain.executor.ExecutionThread;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class UseCaseExecutionThread implements ExecutionThread {

    @Override public Scheduler getScheduler() {
        return Schedulers.computation();
    }

}