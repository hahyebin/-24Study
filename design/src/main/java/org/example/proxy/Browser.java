package main.java.org.example.proxy;

public class Browser implements IBrowser {

    private String url;

    public Browser(String url) {
        this.url = url;
    }

    @Override
    public Html show() {
        System.out.println("Browser loading html form : "+ url);
        return new Html(url);
    }
}
