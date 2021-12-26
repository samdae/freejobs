package project.app;

import org.springframework.stereotype.Service;

import project.app.domain.JobKorea;
import project.app.domain.Okky;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Connection;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;

@Service
public class JobAdsService {
    
    public String jobKorea() {
        return JobKorea.call();
    }
    
    public String okky() {
        return Okky.call();    
    }
    
    public void saramin() {
        String url = "https://www.saramin.co.kr/zf_user/search?searchType=search&searchword=%EA%B0%9C%EB%B0%9C&company_cd=0%2C1%2C2%2C3%2C4%2C5%2C6%2C7%2C9%2C10&loc_mcd=101000&loc_cd=102200%2C102190%2C102210%2C102180&cat_kewd=101%2C84%2C89%2C87%2C222%2C214%2C209%2C210%2C217%2C194%2C293%2C297%2C301%2C302%2C313%2C312%2C282%2C291%2C292%2C257%2C254%2C255%2C256%2C250%2C243%2C240%2C239%2C238%2C235%2C236&job_type=9&panel_type=&search_optional_item=y&search_done=y&panel_count=y&recruitPage=1&recruitSort=reg_dt&recruitPageCount=100&inner_com_type=&show_applied=&quick_apply=&except_read=&mainSearch=y";
        //System.out.println(conn(url));
    }
    
    public void wishket() {
        // 상주, 개발, 웹, 금액:400~800, 기간:60~240, 서울전체&성남시
        // String url = "https://www.wishket.com/project/?text_search_type=all&search_text=&inhouse=inhouse&project_category=develop&project_subcategory=web&project_min_budget=&project_max_budget=&project_min_term=60&project_max_term=240&term_hand_writing=on&project_min_launch_date=&project_max_launch_date=&inhouse_project_min_budget=4%2C000%2C000&inhouse_project_max_budget=8%2C000%2C000&location=seoul&location_detail=91&location_detail=92&location_detail=93&hide_close_project=hide_close_project&order_by=default&page=1";
    
        // try{
        //     System.out.println("start wishket");
        //     Connection con = Jsoup.connect(url);
        //     Thread.sleep(5000);
            
        //     Document doc = con.get();
        //     System.out.println(doc);
        //     Elements el = doc.select("section#resultListWrap");
        //     //div.project-list-box
        //     System.out.println(el.toString());
            
        // } catch(Exception e){
        //     e.printStackTrace();
        // }
        
        try{
            String url = "https://www.wishket.com/project/search/?page=1";
            String referer = "https://www.wishket.com/project/?text_search_type=all&search_text=&inhouse=inhouse&project_category=develop&project_subcategory=web&project_min_budget=&project_max_budget=&project_min_term=60&project_max_term=240&term_hand_writing=on&project_min_launch_date=&project_max_launch_date=&inhouse_project_min_budget=4%2C000%2C000&inhouse_project_max_budget=8%2C000%2C000&location=seoul&location_detail=91&location_detail=92&location_detail=93&hide_close_project=hide_close_project&order_by=default&page=1";

            HttpClient client = HttpClientBuilder.create().build(); // HttpClient 생성
            HttpPost postRequest = new HttpPost(url); //POST 메소드 URL 새성
            postRequest.setHeader("Accept", "*/*");
            postRequest.setHeader("Content-Type", "application/x-www-form-urlencoded");
            postRequest.setHeader("origin", "https://www.wishket.com");
            postRequest.setHeader("Accept-Encoding", "gzip, deflate, br");
            
            postRequest.setHeader("referer", referer);

            HttpResponse response = client.execute(postRequest);

            
                ResponseHandler<String> handler = new BasicResponseHandler();
                String body = handler.handleResponse(response);

                System.out.println("body ==>"+body);
            
        } catch(Exception e){
            e.printStackTrace();
        }
        

    }
    

    
}
