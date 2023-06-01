import java.util.TimerTask;
import java.util.Timer;

public class TimerT {
    private static TimerT instance = new TimerT();
    static int count = 0;
    int timeout;
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(count < timeout){
                // System.out.println("countdown..." + count);
                    count++;
                }
                else{
                    System.out.println("시간이 다 되었습니다.");
                    timer.cancel();
                }
            }
        };

    private TimerT() { }

    public static TimerT getInstance() {
        return instance;
    }

    public synchronized void setTimer(int time){
        this.timeout = time;
        // timer.cancel();
        timer.schedule(task, 1000, 1000);
    }
}
