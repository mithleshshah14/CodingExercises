public class SingletonClass {

    private static SingletonClass singletonClass = null;
    private SingletonClass(){}

    public synchronized static SingletonClass getObject() {
        if(singletonClass == null) {
            synchronized (SingletonClass.class) {
                singletonClass = new SingletonClass();
            }
        }

        return singletonClass;
    }

}
