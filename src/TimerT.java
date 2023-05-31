import java.util.TimerTask;
import java.util.Timer;

public class TimerT {
    static int count = 0;
    int timeout;
    Timer timer;
    TimerTask task;

    public TimerT() {
        this.timer = new Timer();
        count = 0;
        task = new TimerTask() {
            @Override
            public void run() {
                if(count < timeout){
//                    System.out.println("countdown..." + count);
                    count++;
                }
                else{
                    System.out.println("시간이 다 되었습니다.");
                    timer.cancel();
                }
            }
        };
    }
    private boolean noticeTimeout(){
        return true;
    }

    public void setTimer(int time){
        this.timeout = time;
        timer.schedule(task, 1000, 1000);
    }
}
