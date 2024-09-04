class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<List<Integer>> set=new  HashSet<>();
        for(int i=0;i<obstacles.length;i++)
        {
            List<Integer> list=new  ArrayList<>();
            list.add(obstacles[i][0]);
            list.add(obstacles[i][1]);
            set.add(list);
        }
        int x=0,y=0;
        boolean allow=true;
        char dir='N';//Direction(Initially north i.e. N)
        int ans=0;
        for(int i=0;i<commands.length;i++)
        {
            //System.out.print(commands[i]+" "+x+" "+y+" "+allow+"\t");
            if(commands[i]>=1 && commands[i]<=9)
            {
                int ar[]=moveDirection(x,y,dir,commands[i],set,allow);
                allow=false;
                x=ar[0];
                y=ar[1];
            }
            else
                dir=changeDirection(dir,commands[i]);
            //System.out.println(x+" "+y+" "+allow);
            ans=Math.max(ans,(Math.abs(x)*Math.abs(x))+(Math.abs(y)*Math.abs(y)));
        }
        return ans;
    }
    public int[] moveDirection(int x,int y,char dir,int dis,HashSet<List<Integer>> set,boolean allowed)
    {
        for(int i=1;i<=dis;i++)
        {
            List<Integer> list=new  ArrayList<>();
            list.add(x);
            list.add(y);
            if(set.contains(list) && allowed==false)
                break;
            if(dir=='N')
                y++;
            else if(dir=='S')
                y--;
            else if(dir=='W')
                x--;
            else
                x++;
            List<Integer> temp=new  ArrayList<>();
            temp.add(x);
            temp.add(y);
            if(set.contains(temp))
            {
                x=list.get(0);
                y=list.get(1);
                break;
            }
        }
        int ar[]=new  int[2];
        ar[0]=x;
        ar[1]=y;
        return ar;
    }
    public char changeDirection(char dir,int command)
    {
        switch(dir)
        {
            case 'N':   if(command==-2)
                            return 'W';
                        else
                            return 'E';
            case 'S':   if(command==-2)
                            return 'E';
                        else
                            return 'W';
            case 'W':   if(command==-2)
                            return 'S';
                        else
                            return 'N';
            default:    if(command==-2)
                            return 'N';
                        else
                            return 'S';
        }
    }
}