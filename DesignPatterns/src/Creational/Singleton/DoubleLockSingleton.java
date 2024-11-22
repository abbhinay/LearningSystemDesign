package Creational.Singleton;

public class DoubleLockSingleton {
    /*
    When a variable is declared as volatile, the Java Virtual Machine (JVM) ensures that
    the value of the variable is always read from and written to main memory, bypassing any thread-local caches.
    This means that any thread accessing the variable will always see the latest value written by another thread.
    */
    private static volatile DoubleLockSingleton instance;

    private DoubleLockSingleton() {}

    /*
    When two threads T1 and T2 comes to create instance and execute ?instance==null?,
    both threads have identified instance variable to null thus assume they must create an instance.
    They sequentially go to synchronized to create the object two times.
    That's where second lock comes into play.
    It prevents second thread to proceed.
     */
    public static DoubleLockSingleton getInstance() {
        if(instance==null) {
            synchronized(DoubleLockSingleton.class) {
                if(instance==null) {
                    instance = new DoubleLockSingleton();
                }
            }
        }
        return instance;
    }
}
