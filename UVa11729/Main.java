package UVa.UVa11729;

import java.util.*;

public class Main {

    public static int NumberOfMission;
    private int assignTaskTime;
    private int doTaskTime;

    public void setAssignTaskTime(int assignTaskTime) {
        this.assignTaskTime = assignTaskTime;
    }

    public void setDoTaskTime(int doTaskTime) {
        this.doTaskTime = doTaskTime;
    }

    public int getAssignTaskTime() {
        return assignTaskTime;
    }

    public int getDoTaskTime() {
        return doTaskTime;
    }

    public Main (int assignTaskTime, int doTaskTime) {
        this.assignTaskTime = assignTaskTime;
        this.doTaskTime = doTaskTime;
    }

    public int compareTo(Main o) {
        if (this.getDoTaskTime() < o.getDoTaskTime())
            return 1;
        return -1;
    }

    public static void main(String args[]) {

        Scanner Input = new Scanner(System.in);
        List<Main> Missions = new ArrayList<Main>();

        int num = 1;
        while (Input.hasNext()) {

            NumberOfMission = Input.nextInt();

            if (NumberOfMission == 0)   break;

            Missions.clear();
            for (int i = 0; i < NumberOfMission; i++)
                Missions.add(new Main(Input.nextInt(), Input.nextInt()));

            //doTaskTime重大到小排序
            Collections.sort(Missions, Main::compareTo);

            int sum = 0;
            int over = 0;
            for (Main item:Missions) {
                if (sum == 0) {
                    over = - item.getDoTaskTime();
                } else {
                    over = over + item.getAssignTaskTime();
                    if (over > -item.getDoTaskTime()) {
                        over = -item.getDoTaskTime();
                    }
                }
                sum += item.getAssignTaskTime();
//                over += item.getAssignTaskTime();     //保存分配完当前任务时已用的时间
//                if((over+item.getDoTaskTime())>sum){
//                    sum = over+item.getDoTaskTime();
//                }
            }

            sum = sum - over;
            System.out.println("Case " + num +": " + sum);
            num ++;
        }
    }
}
