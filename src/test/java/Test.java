public class Test {

    HTTPRequests httpReq = HTTPRequests.getInstance();

    @org.testng.annotations.Test
    public void tagsTest() {

        httpReq.registerToBackOffice();
        httpReq.findUserByEmail();
        httpReq.set360ProTag();


    }
}