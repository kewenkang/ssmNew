package com.smarthouse.operation;

public class SalaryUtil {
    public static float getSalary(int sum){
        if (sum <= 0)
            return 0;

        if (sum <= 1000){
            return sum * 0.1f;
        }else if (sum <= 1800){
            return 100 + (sum - 1000) * 0.15f;
        }else{
            return 100 + 800 * 0.15f + (sum - 1800) * 0.2f;
        }
    }
}
