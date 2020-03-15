import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ghfhg {
    public static void main(String args[]) {
        String ad;
        System.out.println("请输入指令和参数");
         do{
           ad = got1();
           System.out.println("请输入指令和参数");
       }while (!ad.equals("-q"));


     }




        public static String got1(){
            Scanner input=new Scanner(System.in);
            String ip[] = input.nextLine().split(" ");
     switch (ip[0]){
         case "-c":if(readFile(ip[1]).get("Row")!=null)
             System.out.println("该文件的行数为"+readFile(ip[1]).get("Row"));

             break;
         case "-l":if(readFile(ip[1]).get("Chars")!=null)
             System.out.println("该文件的字符数为"+readFile(ip[1]).get("Chars"));
             break;
         case "-w":if(readFile(ip[1]).get("Word")!=null)
             System.out.println("该文件的单词数为"+readFile(ip[1]).get("Word"));
             break;

             default:
                 System.out.println("输入错误");
                 break;}
     return ip[0];}



    public static Map<String ,Integer> readFile(String filename) {
        String pathname = filename;
        Map<String, Integer> Information = new HashMap<String, Integer>();
        int row=0,chars=0,word=0;
        File file=new File(pathname);
        if (!file.exists()) {
            System.out.println("该文件不存在");
        }else{;
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            while ((line = br.readLine()) != null) {if(line.isEmpty()){row++;}
               else{if((line.charAt(0)>='a'&&line.charAt(0)<='z')||(line.charAt(0)>='A'&&line.charAt(0)<='Z')){
                    word++;
                }
                for(int i=1; i< line.length();i++,chars++) {
                    char c = line.charAt(i);
                    char b=line.charAt(i-1);
                    if(((c>='a'&&c<='z')||(c>='A'&&c<='Z'))&&!((b>='a'&&b<='z')||(b>='A'&&b<='Z'))){
                        word++;
                    }
                }
           row++;}}
            Information.put("Row",row);
            Information.put("Chars",chars);
            Information.put("Word",word);

        } catch (IOException e) {
            e.printStackTrace();
        }}
               return Information;}
}

