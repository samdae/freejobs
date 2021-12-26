package project.app.domain;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Connection;

public class Okky extends Domain {
    
    public static String call(){
        String str = "";
        
        String url = "https://okky.kr/articles/recruit?offset=0&max=24&sort=id&order=desc&filter.group=1&filter.minCareer=2&filter.minPay=400&filter.jobType=CONTRACT&filter.jobDuty=35&filter.rank=3&filter.startDate=1&filter.city=%EC%84%9C%EC%9A%B8&filter.district=%EA%B0%95%EB%82%A8%EA%B5%AC,%EA%B0%95%EB%8F%99%EA%B5%AC,%EA%B4%80%EC%95%85%EA%B5%AC,%EA%B4%91%EC%A7%84%EA%B5%AC,%EA%B5%AC%EB%A1%9C%EA%B5%AC,%EA%B8%88%EC%B2%9C%EA%B5%AC,%EB%8F%99%EC%9E%91%EA%B5%AC,%EC%84%9C%EC%B4%88%EA%B5%AC,%EC%84%B1%EB%8F%99%EA%B5%AC,%EC%84%B1%EB%B6%81%EA%B5%AC,%EC%86%A1%ED%8C%8C%EA%B5%AC,%EC%98%81%EB%93%B1%ED%8F%AC%EA%B5%AC,%EC%9A%A9%EC%82%B0%EA%B5%AC&filter.skill=java,spring,javascript";
        Elements el = connect(url).select("div#list-article")
            .select("div.panel.panel-default.recruit-panel")
            .select("ul li");
        
        for(int i=0; i < el.size(); i++){
            System.out.println(i+1 + " ==================");
            Elements div = el.get(i).select("div.list-title-wrapper-flex div");
            Elements infoTitle = div.select("div.list-position-info")
                .select("div.list-position-info-title");
            
            String 정보 = infoTitle.select("div.skill-tag-list").text();
            String 제목 = infoTitle.select("a.title-link").text();
            String 주소 = infoTitle.select("a.title-link").attr("href");
            
            
            Elements eli = div.select("div.list-position-info")
                .select("div.list-position-info-wrapper")
                .select("div.list-position-info-item");
            
            
            String 금액 = eli.get(0).text();
            String 경력 = eli.get(1).text();
            String 위치 = eli.get(2).text();
            String 옵션 = eli.get(3).text();
            옵션 += " | " + eli.get(4).text();
            String 기간 = eli.get(5).text();
                
            System.out.println(제목);
            System.out.println(주소);
            System.out.println(정보);
            System.out.println(금액);
            System.out.println(경력);
            System.out.println(위치);
            System.out.println(옵션);
            System.out.println(기간);
            
            
            //
            
            // System.out.println("2)  "+div.get(1).toString());
            // System.out.println("3)  "+div.get(2).toString());
            // System.out.println("4)  "+div.get(3).toString());
        }
        return "";
    }
}
