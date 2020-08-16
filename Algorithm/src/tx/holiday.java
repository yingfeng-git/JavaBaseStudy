package tx;

/**
 * 由于业绩优秀，公司给小Q放了 n 天的假，身为工作狂的小Q打算在在假期中工作、锻炼或者休息。
 * 他有个奇怪的习惯：不会连续两天工作或锻炼。只有当公司营业时，小Q才能去工作，
 * 只有当健身房营业时，小Q才能去健身，小Q一天只能干一件事。给出假期中公司，健身房的营业情况，
 * 求小Q最少需要休息几天。
 */
public class holiday {
    public static void main(String[] args) {
        String company = "00101";
        String gym = "00100";
        int days = company.length();
        int lianXuDay = 0;

        char[] sa1 = company.toCharArray();
        char[] sa2 = gym.toCharArray();


        for (int i = 0; i < sa1.length; i++) {
            if ('1'== sa1[i] || '1' == sa2[i]) {
                lianXuDay++;
            }else{
                if (lianXuDay >0) {
                    days = days - (lianXuDay / 2) - (lianXuDay % 2);
                    lianXuDay = 0;
                }
            }
        }

        if (lianXuDay >0)  days = days - (lianXuDay / 2) - (lianXuDay % 2);

        System.out.println(days);
    }
}
