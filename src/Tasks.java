
class Tasks {
    public FirstTaskAnswer beginTask(int r) {
        FirstTaskAnswer answer = new FirstTaskAnswer();
        assert r >= 0: "Wrong input (First Task)";
        answer.s = 3.14 * r * r;
        answer.l = 2 * 3.14 * r;
        return answer;
    }

    public SecondTaskAnswer integerTask(int value) {
        SecondTaskAnswer answer = new SecondTaskAnswer();
        int first,second;
        assert ((value < 100) || (value > 9)): "Wrong input (Integer Task)";
        first = value / 10;
        second = value % 10;
        answer.first = first + second;
        answer.second = first*second;
        return answer;
    }

    public boolean booleanTask(int value1, int value2, int value3) {
        return ((value1 < value2) && (value2 < value3));
    }

    public int ifTask(int value1, int value2) {
        assert value1 != value2: "Wrong input (If Task)";
        if (value1 > value2) {
            return 2;
        } else {
            return 1;
        }
    }
    public double switchTask(int type, double weight){

        double answer;
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
    public int forTask(int value1, int value2){
        assert value2 >= value1: "Wrong input (For Task)";
        return (value1+value2)*(value2-value1+1)/2;
    }
    public int whileTask(int N){
        int k=0;
        assert N > 0: "Wrong input (While Task)";
        while( (k*k) < N) {
         k++;
        }
        return k;
    }
    public int arrayTask(int[] mas){
        int n=mas.length;
        assert n>1: "Wrong input (Array Task)";
        for(int i=2;i<n;i++){
            if( (mas[i]-mas[i-1]) != (mas[i-1]-mas[i-2]) ){
                return 0;
            }
        }
        return mas[1]-mas[0];
    }
    public int[][] matrixTask(int[][] result){
        int n = result.length, m = result[0].length;
        assert (n > 0 || m > 0): "Wrong input (Matrix Task)";
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
    double s;
    double l;
    FirstTaskAnswer(double s,double l){
        this.s = s;
        this.l = l;
    }
    FirstTaskAnswer(){
        this.s = 0;
        this.l = 0;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj)
            return true;

        if(this.getClass()!=obj.getClass())
            return false;

        FirstTaskAnswer temp = (FirstTaskAnswer)obj;
        return ( (this.s == temp.s) || (this.l == temp.l) );
    }
}

class SecondTaskAnswer {
    int first, second;
    SecondTaskAnswer(int first,int second){
        this.first = first;
        this.second = second;
    }
    SecondTaskAnswer(){
        this.first = 0;
        this.second = 0;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj)
            return true;

        if(this.getClass()!=obj.getClass())
            return false;

        SecondTaskAnswer temp = (SecondTaskAnswer)obj;
        return ( (this.first == temp.first) || (this.second == temp.second) );
    }
}