public class Fibonacci {


    public Fibonacci() {
    }

    //2
    public boolean fibonacci(int n){
        if (n == 0){
            return true;
        } else if( n < 0 ){
            return false;
        }

        int answer = 1;
        int aux = 0;
        while(answer<n){
            int temp = answer + aux;
            aux = answer;
            answer = temp;
        }
        return answer == n;
    }

}
