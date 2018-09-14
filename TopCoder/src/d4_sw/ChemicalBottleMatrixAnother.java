package d4_sw;

import java.util.PriorityQueue;
import java.util.Scanner;
public class ChemicalBottleMatrixAnother {
    public static PriorityQueue pq=new PriorityQueue();
    public static int arr[][];
    public static int N;
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int Num=s.nextInt(); s.nextLine();
        for(int tc=0;tc<Num;tc++){
            N=s.nextInt(); s.nextLine();
            arr=new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    arr[i][j]=s.nextInt();
                }
                if(i!=N-1)s.nextLine();
            }
             
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(arr[i][j]!=0){
                        check(i,j);
                    }
                }
            }
            System.out.print("#"+(tc+1)+" "+pq.size()+" ");
            while(!pq.isEmpty()){
                ppoint temp=(ppoint)pq.poll();
                System.out.print(temp.x+" "+temp.y+" ");
            }
            System.out.println();
        }
    }
    public static void check(int x,int y){
        int tempx=1; int tempy=1;
        while(true){
            if(x+tempx < N && arr[x+tempx][y] !=0 ){
                tempx++;
            }
            else{
                break;
            }
        }
         
        while(true){
            if(y+tempy < N && arr[x][y+tempy] != 0){
                tempy++;
            }
            else{
                break;
            }
        }
         
        for(int i=0;i<tempx;i++){
            for(int j=0;j<tempy;j++){
                arr[x+i][y+j]=0;
            }
        }
        pq.add(new ppoint(tempx,tempy,tempx*tempy));
         
    }
}
 
class ppoint implements Comparable<ppoint>{
    int x; int y; int val;
    ppoint(int x,int y,int val){
        this.x=x;this.y=y;this.val=val;
    }
     
    @Override
    public int compareTo(ppoint o) {
        if(o.val<this.val){
            return 1;
        }
        else if(o.val==this.val){
            if(o.x<this.x){
                return 1;
            }
            else{
                return -1;
            }
        }
        else{
            return -1;
        }
    }
}