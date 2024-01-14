package org.example;

import org.example.adapter.*;
import org.example.aop.AopBrowser;
import org.example.decorator.*;
import org.example.facade.Ftp;
import org.example.facade.Reader;
import org.example.facade.SftpClient;
import org.example.facade.Writer;
import org.example.observer.Button;
import org.example.observer.IButtonListener;
import org.example.proxy.Browser;
import org.example.proxy.BrowserProxy;
import org.example.proxy.Html;
import org.example.proxy.IBrowser;
import org.example.singleton.AClazz;
import org.example.singleton.BClazz;
import org.example.singleton.SoketClient;
import org.example.strategy.*;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {


        /*
           ---- <Singleton pattern>
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SoketClient aClient = aClazz.getSoketClient();
        SoketClient bClient = bClazz.getSoketClient();

        System.out.println("싱글톤 객체 동일?");
        System.out.println(aClient.equals(bClient));*/


 /*     -------  <Adapter pattern >
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SoketAdapter(cleaner);
        connect(adapter);  // adapter를 통해 220V --> 110V 로 변환

        AirConditional airConditional = new AirConditional();
        Electronic110V adapter2 = new SoketAdapter(airConditional);
       connect(adapter2); // adapter를 통해 220V --> 110V 로 변환
       */


        //-------- <proxy pattern >
       /* 1. Proxy > no adapt
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();


        2. Proxy > adapt
        proxy 다른 무언가와 이어지게 하는 인터페이스 역할하는 클래스
        IBrowser iBrowser = new BrowserProxy("www.naver.com");
        iBrowser.show();
        iBrowser.show();
        iBrowser.show();
        iBrowser.show();


        3. Proxy > aopProxy 적용 >>
         ** aop는 여러 객체에 공통으로 적용할 수 있는 기능을 분리해서 재사용하는 기법
            aop는 전후메서드, 기능, 흩어져있는 기능을 proxy패턴으로 제공함
                  메서드 전후 시간, 요청 정보, 반응시간 확인
         ** proxy는 핵심 기능의 실행을 다른 객체에 위임하고 부가적인 기능을 제공하는 객체

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()->{

                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
         );
        aopBrowser.show();
        System.out.println("loading time : "+end.get());

        aopBrowser.show();
        System.out.println("loading time : "+end.get());

        aopBrowser.show();
        System.out.println("loading time : "+end.get());
*/


       /* // ------  <decorator pattern>
        // ** 기존 뼈대(클래스)는 유지하되, 이후 필요한 형태로 꾸밀 때 사용한다. 확장시 유용
        // ** ex. 뼈대 : 에스프레소  + 확장 - 우유추가시 : 라떼, 물추가시 : 아메리카노 etc,,,,

        ICar iCar = new Audi(1000);
        iCar.showPrice();

        // 등급 확인 a3, a4, a5
        ICar a3 = new A3(iCar,"A3");
        a3.showPrice();

        ICar a4 = new A4(iCar, "A4");
        a4.showPrice();

        ICar a5 = new A5(iCar, "A5");
        a5.showPrice();
        */


        /* --------< Observer pattern >
        변화가 일어 났을 때, 미리 등록된 다른 클래스에 통보해주는 패턴
        ex. 선생님 오실 때 '망을 보는 학생'


        Button button = new Button("button");

        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println("observer listen "+event);
            }
        });
        button.click("msg 전달 1");
        button.click("msg 전달 2");
        button.click("msg 전달 3");
        button.click("msg 전달 4");
    }
      */

        /*
        // ---- <Facade pattern>
        // 여러 개의 객체와 실제 사용하는 서브 객체의 사이에 복잡한 의존관계가 있을때
        // 중간에 facade라는 객체를 두고, 여기서 제공하는 인터페이스만을 활용하여 기능 사용하는 방식


        Ftp ftp = new Ftp("www.naver.com", 22, "/home/etc");
        ftp.connect();
        ftp.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.writer();

        Reader reader = new Reader("text.temp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftp.disconnect();
        SftpClient sftpClient = new SftpClient("www.naver.com", 22, "/home/etc", "text.temp");
        sftpClient.connenct();
        sftpClient.writer();
        sftpClient.read();
        sftpClient.disConnect();
        */

        /*
          ----- < Strategy pattern >
          전략 메서드를 가진 전랙 객체(Normal Stratege, Base64 )
          전략 객체를 사용하는 컨텍스트
          전략 객체를 생성해 컨텍스트에 주입하는  클라이언트
*/
        Encoder encoder = new Encoder();

        EncodingStrategy base64 = new Base64Strategy();

        EncodingStrategy normal = new NormalStrategy();

        //EncodingStrategy append = new AppendStrategy();

        String msg = "hello Strategy pattern";

        //bae64
        encoder.setEcodingStrategy(base64);
        String base64Result = encoder.getMsg(msg);
        System.out.println(base64Result);

        //normal
        encoder.setEcodingStrategy(normal);
        String normalResult = encoder.getMsg(msg);
        System.out.println(normalResult);

        encoder.setEcodingStrategy(new AppendStrategy());
        //String appendResult = encoder.getMsg(msg);
        //System.out.println(appendResult);
        System.out.println(encoder.getMsg(msg));



    }


    public static void connect(Electronic110V electronic110V){

        electronic110V.powerOn();
    }


}