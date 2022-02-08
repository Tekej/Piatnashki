package sample;

public class Zegar {
    public Zge zge ;
    public static int time=0;
    public boolean run = true;
    public void setZge(Zge zge) {
        this.zge = zge;
    }

    public void start() {
        Thread thread = new Thread(()->{
            while (run && !Game.endGame){
                time++;
                if(zge!=null){
                    zge.zegarChange(time);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
    public interface Zge{
        void zegarChange(int t);
    }
}
