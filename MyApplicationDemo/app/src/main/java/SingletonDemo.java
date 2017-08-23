/**
 * Created by ws on 17-8-7.
 */

class SingletonDemo {
    private volatile static SingletonDemo sInstance;

    private SingletonDemo() {
    }

    public SingletonDemo getInstance() {
        if (sInstance == null) {
            synchronized (SingletonDemo.class) {
                if (sInstance == null) {
                    sInstance = new SingletonDemo();
                }
            }
        }
        return sInstance;
    }
}