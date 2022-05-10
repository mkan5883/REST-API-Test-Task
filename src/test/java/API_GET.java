import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class API_GET {

    @BeforeClass
    public void baseTest() {
        RestAssured.baseURI = "https://finanzen.check24.de/accounts/r/frs/productInfo/kreditkarte";
    }

    @Test
    void test_01() {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/200007");
        int statusCode =response.statusCode();
        Assert.assertEquals(statusCode, 200, "Incorrect response status code");
    }

    @Test
    void test_02() {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/abcd");
        String message = response.jsonPath().get("message");
        int statusCode =response.statusCode();
        Assert.assertEquals(statusCode, 404, "Incorrect response status code");
        Assert.assertEquals(message, "HTTP 404 Not Found", "Incorrect error message");
    }

    @Test
    void test_03() {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/5456");
        int statusCode =response.statusCode();
        Assert.assertEquals(statusCode, 204, "Incorrect response status code");
    }
}
