/**
 * Created by vans239 on 29/06/17.
 */
public class ChangeBase {
    static String asThreeBase(int decimal) {
        StringBuilder sb = new StringBuilder();

        if (decimal == 0) {
            return "0";
        }
        while (decimal > 0) {
            sb.append(decimal % 3);
            decimal /= 3;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(asThreeBase(0));
        System.out.println(asThreeBase(3));
        System.out.println(asThreeBase(4));
        System.out.println(asThreeBase(9));
    }
}
