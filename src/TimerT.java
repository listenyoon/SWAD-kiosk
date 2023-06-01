import java.util.TimerTask;
import java.util.Timer;

public class TimerT {
    private static TimerT instance = new TimerT();
    static int count = 0;
    int timeout;
    static Timer timer;
    static TimerTask task;

    private TimerT() { }

    public static TimerT getInstance() {
        return instance;
    }

    public synchronized void setTimer(int time){
        count = 0;
        this.timeout = time;
        timer = new Timer();
                task = new TimerTask() {
            @Override
            public void run() {
                if(count < timeout){
                // System.out.println("countdown..." + count);
                    count++;
                }
                else{
                    timer.cancel();
                    System.out.println("우왕 시간이 다 되었습니다.");
                    System.exit(1);
                }
            }
        };
        timer.schedule(task, 1000, 1000);
    }

    public synchronized String waiting(int time){
        count = 0;
        this.timeout = time;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(count < timeout){
                // System.out.println("countdown..." + count);
                    count++;
                }
                else{
                    timer.cancel();
                    System.out.println("웨이팅 시간이 다 되었습니다.");
                }
            }
        };
        timer.schedule(task, 1000, 1000);
        return "n";
    }
}
