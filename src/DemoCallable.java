import java.util.concurrent.Callable;

public class DemoCallable implements Callable {
    @Override
    public Object call() throws Exception {
        Thread.sleep(1000);//задержка
        return Thread.currentThread().getName();//выведем название текущего потока
    }
}
