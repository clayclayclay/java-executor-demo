# java-executor-demo
this is a project about java executor.

* JavaThreadPool1:

  * create a fix thread pool by Executors and execute tasks of `Thread` and `Runnable`

  * Thread Pool:

    ```java
    ExecutorService pool = Executors.newFixedThreadPool(int poolSize);
    ```

  * Task Type:

    * Thread
    * Runnable

  * Task Submit:

    ```java
    pool.execute(Runnable task);
    ```

* JavaThreadPool2:

  * create a fix thread pool by Executors, submit tasks of `Callable`, and get return Object `Future`

  * Thread Pool:

    ```java
    ExecutorService pool = Executors.newFixedThreadPool(int poolSize);
    ```

  * Task Type:

    * Callable

  * Task Submit:

    ```java
    pool.submit(Callable task);
    ```

* JavaThreadPool3:

  * create a fix thread pool by ThreadPoolExecutor and execute tasks of `Thread` and `Runnable`

  * Thread Pool:

    ```java
    ThreadPoolExecutor pool = new ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue);
    ```

  * Task Type:

    * Thread
    * Runnable

  * Task  Submit:

    ```java
    pool.execute(Runnable task);
    ```

* JavaThreadPool4:

  * create a fix thread pool by ThreadPoolExecutor, submit tasks of `Callable`, and get return Object `Future`

  * Thread Pool:

    ```java
    ThreadPoolExecutor pool = new ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue);
    ```

  * Task Type:

    * Callable

  * Task Submit:

    ```java
    pool.submit(Callable task);
    ```

* JavaThreadPool5:

  * create a fix thread pool by Executors, submit tasks of `FutureTask`, and use it to get Thread's state.

  * Thread Pool:

    ```java
    ExecutorService pool = Executors.newFixedThreadPool(int poolSize);
    ```

  * Task Type:

    * FutureTask

  * Task Submit:

    ```java
    pool.submit(Callable task);
    ```

* JavaThreadPool6:

  * create a fix thread pool by ThreadPoolExecutorand, execute tasks of `Thread` and `Runnable`, and override method `beforeExecute`, `afterExecute`, `terminated` to monitor the thread pool.

  * Thread Pool:

    ```java
    ThreadPoolExecutor pool = new ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue);
    ```

  * Task Type:

    * Thread
    * Runnable

  * Task Submit:

    ```java
    pool.execute(Runnable task);
    ```

  * Thread Pool Life cycle monitor:

    ```java
    @Override
    protected void beforeExecute(Thread t, Runnable r);
    @Override
    protected void afterExecute(Runnable r, Throwable t);
    @Override
    protected void terminated();
    ```

* JavaThreadPool7:

  * Thread Pool:

    ```java
    ThreadPoolExecutor pool = new ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue);
    ```

  * Task Type:

    * Thread
    * Runnable

  * Task Submit:

    ```java
    pool.execute(Runnable task);
    ```

  * RejectExecution:

    ```java
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor);
    ```

    ​