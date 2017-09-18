
import java.util.Scanner;
public class First {
    public static void main(String[] args) {
    }
}
class Tasks {
    FirstTaskAnswer BeginTask(int r) {
        FirstTaskAnswer answer = new FirstTaskAnswer();
        if(r<=0) {
           throw new AssertionError("Wrong input (First Task)");
        }
        answer.S = 3.14 * r * r;
        answer.L = 2 * 3.14 * r;
        return answer;
    }

    SecondTaskAnswer IntegerTask(int value) {
        SecondTaskAnswer answer = new SecondTaskAnswer();
        int First,Second;
        if ((value > 99) || (value < 10)) {
            throw new AssertionError("Wrong input (Integer Task)");
        }
        First = value / 10;
        Second = value % 10;
        answer.First = First + Second;
        answer.Second = First*Second;
        return answer;
    }

    boolean BooleanTask(int value1, int value2, int value3) {
        if ((value1 < value2) && (value2 < value3)) {
            return true;
        } else {
            return false;
        }
    }

    int IfTask(int value1, int value2) {
        if(value1 == value2) {
            throw new AssertionError("Wrong Input (If Task)");
        }
        if (value1 > value2) {
            return 2;
        } else {
            return 1;
        }
    }
    double SwitchTask(int type, double weight){

        double answer = 0;
        switch (type){
            case 1:
                answer = weight;
                break;
            case 2:
                answer = weight / 1000000;
                break;
            case 3:
                answer = weight / 1000;
                break;
            case 4:
                answer = weight * 1000;
                break;
            case 5:
                answer = weight * 100;
                break;
            default:
                return 0;
        }
        return answer;
    }
    int ForTask(int value1, int value2){
        if(value2 <= value1){
            throw new AssertionError("Wrong input (For Task)");
        }
        return (value1+value2)*(value2-value1+1)/2;
    }
    int WhileTask(int N){
        int k=0;
        if(N<0){
            throw new AssertionError("Wrong input (While Task)");
        }
        while( (k*k) < N) {
         k++;
        }
        return k;
    }
    int ArrayTask(int[] mas){
        int n=mas.length;
        if(n<2){
            throw new AssertionError("Wrong input (Array Task)");
        }
        for(int i=2;i<n;i++){
            if( (mas[i]-mas[i-1]) != (mas[i-1]-mas[i-2]) ){
                return 0;
            }
        }
        return mas[1]-mas[0];
    }
    int[][] MatrixTask(int[][] result, int n, int m){
        int matrix[][] = new int[1][1];
        if(n<1 || m<1){
            return matrix;
        }
        int k=0,line=0;
        for(int j=m-1;j>0;j--){
            if(k==n){
                line = j+1;
                break;
            }
            k=0;
            for(int i=0;i<n;i++){
                if(result[i][j]>0)
                    k++;
                if(k==n){
                    line = j;
                    break;
                }
            }
        }
        for (int i=0;i<n;i++){
            int temp = result[i][0];
            result[i][0] = result[i][line];
            result[i][line] = temp;
        }
        return result;
    }

}
class FirstTaskAnswer {
    double S;
    double L;
    FirstTaskAnswer(double S,double L){
        this.S = S;
        this.L = L;
    }
    FirstTaskAnswer(){
        this.S = 0;
        this.L = 0;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj)
            return true;

        if(this.getClass()!=obj.getClass())
            return false;

        FirstTaskAnswer temp = (FirstTaskAnswer)obj;
        return ( (this.S == temp.S) || (this.L == temp.L) );
    }
}

class SecondTaskAnswer {
    int First, Second;
    SecondTaskAnswer(int first,int second){
        this.First = first;
        this.Second = second;
    }
    SecondTaskAnswer(){
        this.First = 0;
        this.Second = 0;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj)
            return true;

        if(this.getClass()!=obj.getClass())
            return false;

        SecondTaskAnswer temp = (SecondTaskAnswer)obj;
        return ( (this.First == temp.First) || (this.Second == temp.Second) );
    }
}