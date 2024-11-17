package com.example.desing_pattern.creational.singleton;

public class Singleton {
    private Singleton() {
    }

    /*
    ------------Approach 1--Not Thread safe-------------------
    When two threads call getInstance() at the same time like this,
    both threads check if (instance == null) simultaneously,
    they may both see instance as null.
    As a result, both threads could create separate instances of the Singleton class,
    breaking the Singleton pattern.
    ------------Approach 1--Not Thread safe-------------------
     */
    private static Singleton instance = null;
    public Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }

    /*
    ------------Approach 2--Thread safe but costly-------------------
    When two threads call getInstance() at the same time like this,
    only one thread can execute the method at a time.
    The second thread will have to wait until the first thread has
    finished executing and released the lock.
    every time this will happened and cause a performance issue
    ------------Approach 2--Thread safe but costly-------------------
    */
    public static synchronized Singleton getSynchronizedInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }

    /*
    ------------Approach 3--Thread safe but costly for first initialization-------------------
    When two threads call getInstance() at the same time like this,
    both threads check if (instance == null) simultaneously,
    but when enter synchronized block first thread start creating the instance and
    second thread wait in the queue. then when first thread finished its work second thread
    start executing and found instance != null so its not create new instance.
    also it's not call synchronized every time.
    ------------Approach 3--Thread safe but costly for first initialization-------------------
    */
    private static Singleton instance2 = null;
    public static Singleton getDoubleCheckInstance() {
        if (instance2 == null)
            synchronized (Singleton.class){
                if (instance2 == null)
                    instance2 = new Singleton();
            }
        return instance2;
    }

    /*
    ------------Approach 4--Use of volatile keyword-------------------
    Volatile keyword ensures two key properties:

    1.Changes are immediately visible to all threads. Without volatile,
      there is a chance that other thread may not see the updated value.

    2.The Java Memory Model allows the compiler and the CPU to reorder instructions for optimization purposes.
      Without volatile, the compiler or processor might reorder these steps such that
      the reference to the object is assigned before the constructor completes.
      This means that another thread could see a non-null instance that points to a
      partially constructed object.


      Example Scenario Without volatile

      Thread 1: starts executing and passes the initial if (instance == null) check.
      Thread 1: enters the synchronized block and starts creating the singleton object.
                The compiler or CPU may reorder instructions so that the instance
                reference is assigned before the object is fully constructed.

      Thread 2: sees instance as null (because of the reordering),leading to unpredictable behavior.
    ------------Use of volatile keyword-------------------
    */
    private static volatile Singleton instance3 = null;
    public static Singleton getVolatileInstance() {
        if (instance3 == null)
            synchronized (Singleton.class){
                if (instance3 == null)
                    instance3 = new Singleton();
            }
        return instance3;
    }

    /*
    ------------Approach 5--Thread safe Early Initialization-------------------
    */
    private static final Singleton earlyInstance = new Singleton();
    public static Singleton getEarlyInstance() {
        return earlyInstance;
    }

    /*
    ------------Approach 5--Inner class (Bill Pugh) Technique-------------------
    Normally, static members of a class (e.g., static variables or methods) are loaded and initialized
    when the class itself is loaded into memory by the class loader.
    This happens the first time the class is referenced in any way.

    A static inner class behaves differently.
    The static inner class is not loaded into memory when the outer class is loaded.
    Instead, the static inner class is loaded only when it is explicitly referenced
    */
    private static class SingletonHelper{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstanceBillPugh() {
        return SingletonHelper.INSTANCE;
    }
}
