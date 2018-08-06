import java.util.Arrays;

public class max_or_min {
    public static void main(String[] args){
        int i ;
        int[] num = new int[5] ;
        for(i=0;i<5;i++){
            num[i] = Integer.parseInt(args[i+1]) ;
        }
        if(args[0].equals("max")){
            max_prime max = new max_prime();
            max.max_method(num);
        }else if(args[0].equals("min")){
            min_prime min = new min_prime();
            min.min_method(num);
        }else{
            System.out.println("please retry");
        }
    }
}

class get_prime{
    int[] a = new int[5] ;
    int j,k,l ;
    int N ;
    int OK ;
    int prime_check(int[] num){
        for(j=12345;j<=54321;j++){
            OK = 1 ;
            for(k=4;k>-1;k--){
                a[4-k] = (int)Math.floor((double)j/Math.pow(10.0,(double)k)) % 10 ;
            }
            for(k=0;k<4;k++){
                for(l=k+1;l<5;l++){
                    if(a[k]==a[l] || a[l]>5 || a[l]==0){
                        OK = 0 ;
                    }
                }
            }
            if(OK==1){
                N = 0 ;
                for(k=0;k<5;k++){
                    N = N * 10 + num[a[k]-1] ;
                }
                for(k=2;k<N-1;k++){
                    if(N%k==0){
                        OK = 0 ;
                        break;
                    }
                }
                if(OK==1){
                    return N ;
                }
            }
        }
        return 0 ;
    }
}

class max_prime extends get_prime{
    int[] hold_num = new int[5] ;
    void max_method(int[] num){
        Arrays.sort(num);
        for(j=0;j<5;j++){
            hold_num[j] = num[4-j] ;
        }
        for(j=0;j<5;j++){
            num[j] = hold_num[j] ;
        }
        System.out.println("max prime : " + prime_check(num));
    }
}

class min_prime extends get_prime{
    void min_method(int[] num){
        Arrays.sort(num);
        System.out.println("min prime : " + prime_check(num));
    }
}
