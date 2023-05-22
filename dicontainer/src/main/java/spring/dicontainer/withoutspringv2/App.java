package spring.dicontainer.withoutspringv2;

public class App {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        memberService.join("tommy");
        System.out.println(memberService.getMember("tommy").getName());
    }
}
