package cn.infit.ll.test;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by kaxia on 2017/6/15.
 */
public class PostTest {

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

    @Test
    public void aTest() {

        String param = "user_phone=18817774173&sex=men&weight=80.00&height=183.00&high_waist=98.0854&ankle_high=9.8&knee_high=41.7598" +
                "&does_high=68.3339&hip_high=79.2186&feet_long=0&back_length=43.9799&front_waist_length=45.75&chest_long=22.4541" +
                "&chest_width=0&back_width=0&shoulder_length=45.7666&hip_waist_long=19.0603&the_thigh_inside_long=0&arm_length=52.7761" +
                "&upper_arm_length=23.9838&length_of_the_trunk=0&fork_length=62.915&head_circumference=75.1433&neck_circumference=37.747&on_the_chest=0" +
                "&the_chest=99.3232&under_the_chest=0&on_the_waist_waist_in_the_net=91.3792&in_the_waist=90.563&waistband_is_surrounded=91.4588" +
                "&hip_circumference=91.0379&thigh_circumference=52.6255&in_the_thigh_circumference=45.521&knee_circumference=40.9113&ankle_circumference=23.3712" +
                "&heels_circumference=0&arm_rhizosphere=44.7665&upper_arm_circumference=28.8434&elbow_circumference=20.6404&wrist_circumference=3.48542" +
                "&hem_circumference=0&foot_mouth=23.3494&before_the_length=73.7315&after_the_length=71.7315&sleeve_length=57.7761&length=98.5232&straight_crotch=22.0667";

        //发送 POST 请求
        String sr=sendPost("http://localhost/IN_Fit/receive/receiveData.do", param);

        System.out.println(sr);

    }


}
