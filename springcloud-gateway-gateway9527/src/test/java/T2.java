import java.time.ZonedDateTime;

/**
 * @author : Nsz
 * @version :1.0
 * @email : 954062058@qq.com
 * @since : 2021-03-03 14:14
 */
public class T2 {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(); //默认时区
        System.out.println(zonedDateTime); //TODO 断言时间设置里面的时间格式  2021-03-03T14:15:58.081+08:00[Asia/Shanghai]
    }
}
