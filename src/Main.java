import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);//используем ExecutorService, чтобы не создавать потоки руками

        List<Future> futures = new ArrayList<Future>();//сюда складываем результаты выполнения потоков

        Callable callable = new DemoCallable();//Экземпляр нашего класса

        for (int i = 0; i < 100; i++) {
            Future future = executorService.submit(callable);//получим результат работы нашего callable
            futures.add(future);//добавим его в список
        }

        for (Future fut : futures) {
            try {
                System.out.println(new Date() + "::" + fut.get());//а теперь выведем содержимое списка
            } catch (InterruptedException | ExecutionException e) {
              e.printStackTrace();
            }
        }
        executorService.shutdown();//остановим наш executorService
    }
}