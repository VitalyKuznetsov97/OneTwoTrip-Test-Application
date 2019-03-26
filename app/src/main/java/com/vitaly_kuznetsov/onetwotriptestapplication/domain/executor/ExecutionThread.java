package com.vitaly_kuznetsov.onetwotriptestapplication.domain.executor;

import java.util.concurrent.Executor;

import io.reactivex.Scheduler;

/**
 * Thread abstraction created to change the execution context from any thread to any other thread.
 * Useful to encapsulate a Thread, some job will be done in background.
 */
public interface ExecutionThread {
    Scheduler getScheduler();
}
