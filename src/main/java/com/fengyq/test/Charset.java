package com.fengyq.test;

public class Charset {
    /**
     * https://blog.csdn.net/54powerman/article/details/77575656
     * @param str
     * @param destCharset the destination Charset目的字符集
     * @param midCharset 中转字符集
     * @throws Exception
     */
    public static void demo(String str, String destCharset, String midCharset) throws Exception {
        System.out.println("原文：" + str);

        byte[] destByte = str.getBytes(destCharset);
        System.out.println(destCharset+" Byte："+getHexString(destByte));
        String midStr = new String(destByte, midCharset);//奇数个汉字GBK会出错;用GBK做中转,这里实际上把数据破坏了。应该用iso-8859-1;
        System.out.println("to "+midCharset+"：" + midStr);

        byte[] midByte=midStr.getBytes(midCharset);
        String destStr = new String(midByte, destCharset);
        System.out.println(midCharset+" Byte："+getHexString(midByte));
        System.out.println("revert "+destCharset+"：" + destStr);
        System.out.println("===");
    }

    public static String getHexString(byte[] byteArray) {
        StringBuffer sb = new StringBuffer();
        for (byte b : byteArray) {
            sb.append(Integer.toHexString((b >> 4) & 0xF));
            sb.append(Integer.toHexString(b & 0xF));
            sb.append(" ");
        }
        return sb.toString();
    };

    public static void main(String[] args) throws Exception {
        String str1 = "姓名";
        String str2 = "用户名";
        demo(str1,"UTF-8","ISO-8859-1");
        demo(str2,"UTF-8","ISO-8859-1");

        demo(str1,"UTF-8","GBK");
        demo(str2,"UTF-8","GBK");
        /*String s="严A";
        System.out.println("unicode Byte："+getHexString(s.getBytes("unicode")));
        //将 UNICODE 字符串通过 iso-8859-1 转化为字节串时，只能正常转化 0~255 范围的字符
        byte[] bytes=s.getBytes("ISO-8859-1");
        System.out.println("ISO-8859-1"+" Byte："+getHexString(bytes));
        s=new String(bytes,"ISO-8859-1" );
        System.out.println("revert "+"ISO-8859-1"+"：" + s);*/
    }
}
