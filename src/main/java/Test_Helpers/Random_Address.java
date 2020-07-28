package Test_Helpers;

public class Random_Address {
    public String getRandomAddress()
    {
        int min = 50;
        int max = 100;
        int random_int = (int)(Math.random() * (max - min + 1) + min);
        String Address=Integer.toString(random_int);
        return Address;
    }
}
