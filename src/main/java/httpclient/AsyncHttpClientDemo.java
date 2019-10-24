package httpclient;

import io.netty.handler.codec.http.HttpHeaders;
import org.asynchttpclient.*;

import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 异步的http请求
 *
 * @author: liangzhang212928
 * @Date: 2018-08-14
 */
public class AsyncHttpClientDemo {
    private static String url = "http://onlinetestapi.k.sohu.com/api/news/v2/externalSeoArticle.go?newsId=290704986";

    public static String get(String url) throws ExecutionException, InterruptedException {
        // 1. 创建一个asychttpclient
        // 2. 创建一个handler
        AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
        ListenableFuture<String> future = asyncHttpClient.prepareGet(url).execute(new AsyncCompletionHandler<String>() {
            @Override
            public State onStatusReceived(HttpResponseStatus status) throws Exception {
                System.out.println("status received");
                System.out.println(status.getStatusCode());
                return super.onStatusReceived(status);
            }

            @Override
            public State onHeadersReceived(HttpHeaders headers) throws Exception {
                System.out.println("header received");
                return super.onHeadersReceived(headers);
            }

            @Override
            public State onBodyPartReceived(HttpResponseBodyPart content) throws Exception {
                System.out.println("body part received");
                return super.onBodyPartReceived(content);
            }

            @Override
            public State onTrailingHeadersReceived(HttpHeaders headers) throws Exception {
                System.out.println("trail header");
                return super.onTrailingHeadersReceived(headers);
            }

            @Override
            public void onThrowable(Throwable t) {
                super.onThrowable(t);
            }

            @Override
            public State onHeadersWritten() {
                System.out.println("header write");
                return super.onHeadersWritten();
            }

            @Override
            public State onContentWritten() {
                System.out.println("header content write");
                return super.onContentWritten();
            }

            @Override
            public State onContentWriteProgress(long amount, long current, long total) {
                System.out.println("content write progress");
                return super.onContentWriteProgress(amount, current, total);
            }

            @Override
            public String onCompleted(Response response) throws Exception {

                System.out.println("complete");
                return response.getResponseBody();
            }


        });
        return future.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(get(url));
    }
}
