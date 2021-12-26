package project.app.domain;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Connection;

public class JobKorea extends Domain {
    
    public static String call(){
        String str = "";
        String url = "https://www.jobkorea.co.kr/Search/?stext=%EA%B0%9C%EB%B0%9C&local=I000%2CB150%2CB160%2CB170&duty=1000100&careerType=2%2C4&careerMin=1&careerMax=5&jobtype=6&tabType=recruit&Page_No=1&Ord=RegDtDesc";

        Document doc = connect(url);
        Elements el = doc.select("div#content")
                .select("div.cnt-list-wrap")
                .select("div.list-wrap")
                .select("div.recruit-info")
                .select("div.lists")
                .select("div.lists-cnt");

        String totalCnt = el.attr("total-count");

        Elements ul = el.select("ul.clear");
        Elements lis = ul.get(0).select("li");
        for (int i = 0; i < lis.size(); i++) {
            System.out.println(i+1+" ==============");
            
            
            Elements div = lis.get(i).select("div.post");
            
            String 업체명 = div.select("div.post-list-corp a").attr("title");
            String 제목 = div.select("div.post-list-info a").attr("title");
            String 주소 = div.select("div.post-list-info a").attr("href");
            String 옵션 = div.select("div.post-list-info").select("p.option").text();
            String 스킬 = div.select("div.post-list-info").select("p.etc").text();
            
            System.out.println(업체명);
            System.out.println(제목);
            System.out.println(주소);
            System.out.println(옵션);
            System.out.println(스킬);
            
                
        }
        return str;
    }
    
}
