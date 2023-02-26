//package Assignment_Question;
//import java.io.IOException;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//import javax.lang.model.util.Elements;
//import javax.swing.text.Document;
//import javax.swing.text.Element;
//
////question 7b)	Write multithreaded web crawler
//
//public class Web_Crawler {
//
//    private static final int THREAD_POOL_SIZE = 10;
//    private final Set<String> visitedUrls = new HashSet<>();
//    private final String startUrl;
//    private final int maxDepth;
//
//    public Web_Crawler(String startUrl, int maxDepth) {
//        this.startUrl = startUrl;
//        this.maxDepth = maxDepth;
//    }
//
//    public void crawl() {
//        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
//
//        crawl_Url(startUrl, 0, executor);
//
//        executor.shutdown();
//
//        try {
//            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void crawl_Url(String url, int depth, ExecutorService executor) {
//        if (depth > maxDepth || visitedUrls.contains(url)) {
//            return;
//        }
//
//        visitedUrls.add(url);
//
//        executor.execute(() -> {
//            System.out.println("Crawling " + url);
//
//            try {
//                Document doc = Jsoup.connect(url).get();
//                Elements links = doc.select("a[href]");
//
//                for (Element link : links) {
//                    String nextUrl = link.absUrl("href");
//                    crawl_Url(nextUrl, depth + 1, executor);
//                }
//            } catch (IOException e) {
//                System.err.println("Error crawling " + url + ": " + e.getMessage());
//            }
//        });
//    }
//
//    public static void main(String[] args) {
//        Web_Crawler crawler = new Web_Crawler("https://www.example.com/", 2);
//        crawler.crawl();
//    }
//
//}