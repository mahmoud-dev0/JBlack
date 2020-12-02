package UtilsMethods;

import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;


public class Utils {
    
    public  static void messageWithBeep(String s) {
		Toolkit.getDefaultToolkit().beep();
		JOptionPane.showMessageDialog(null, 
				  s, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
    public static int[] byteToIntArr(byte buff[]){
        int intArr[] = new int[buff.length/4];
        int offset = 0;
        for(int i=0;i< intArr.length;i++){
            intArr[i] = (buff[3 + offset] & 0xFF) | ((buff[2 + offset]) << 8) |
                    ((buff[1 + offset] & 0xFF)<<16 | ((buff[0 + offset]) & 0xFF) <<24);
            offset+=4;
        }
        return intArr;
}
    public static byte[] intToByteArr(int[] buff) throws IOException{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        
        for(int i=0;i< buff.length;i++){
           dos.writeInt(buff[i]);
        }
        return bos.toByteArray();
}
     public static int[] fullInt(int[] s){
            int[] ss=s;
             if(ss.length < 16){
                 int n = 16-ss.length;
                for(int i=n;i<ss.length;i++){
                    ss[i]=0;
                }
            }
            System.out.println(ss);
            if(ss.length % 16 != 0){
                int n = ss.length;
                int m = n % 16;
                for(int j=0;j<16-m;j++){
                    ss[j] = 0;
                }
            }
            return ss;
        }
   public static byte[] stringToByteArray(String s){
        String ss=s;
        String tmp;
         byte[] b = new byte[s.length() / 2];
           //int i;
           for (int i = 0; i < s.length() / 2; i++) {
             tmp = s.substring(i * 2, i * 2 + 2);
             b[i] = (byte)(Integer.parseInt(tmp, 16) & 0xff);
           }
        return b;
    }
   
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
    return new String(hexChars);
    }
    
     public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
     public String hexToString(String hex){
  	  StringBuilder sb = new StringBuilder();
  	  StringBuilder temp = new StringBuilder();
  	  //49204c6f7665204a617661 split into two characters 49, 20, 4c...
  	  for( int i=0; i<hex.length()-1; i+=2 ){
  	      //grab the hex in pairs
  	      String output = hex.substring(i, (i + 2));
  	      //convert hex to decimal
  	      int decimal = Integer.parseInt(output, 16);
  	      //convert the decimal to character
  	      sb.append((char)decimal);
  		  
  	      temp.append(decimal);
  	  }
  	  return sb.toString();
    }
}
