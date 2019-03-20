package com.vitaly_kuznetsov.onetwotriptestapplication.domain.executor;

import java.util.concurrent.Executor;

/**
 * Executor implementation can be based on different frameworks or techniques of asynchronous
 * execution, but every implementation will execute the
 * {@link com.vitaly_kuznetsov.onetwotriptestapplication.domain.interactor.UseCase} out of the UI thread.
 */
public interface ThreadExecutor extends Executor {}
