package contriller;

import data.Member;

import infra.Container;
import infra.Request;
import service.MemberService;
import utills.Utill;

import java.util.Scanner;

public class MemberController implements Controller {

    private Scanner sc;
    private MemberService memberService;

    public MemberController() {
        this.sc = Container.sc;
        this.memberService = Container.memberService;
    }

    @Override
    public void execute(Request request) {
        switch (request.getTarget()) {
            case "join":
                saveMember();
                break;
            case "login":
                login(request);
                break;
            case "Logout":
                logout(request);
                break;
            case "detail":
                detail(request);
                break;
            default:
                System.out.println("올바른 요청을 보내주시기 바랍니다.");
                break;
        }
    }


    public void saveMember() {
        System.out.println(" == 회원가입 == ");


        System.out.print("아이디 : ");
        String loginId = sc.nextLine().trim();

        if (memberService.isExistsByLoginID(loginId)) {
            System.out.println("이미 존재하는 아이디입니다.");

        }

        System.out.print("비밀번호 : ");
        String password = sc.nextLine().trim();

        System.out.println("이름 : ");
        String name = sc.nextLine().trim();


        int memberId = memberService.saveMember(loginId, password, name);

        System.out.println(memberId + "번 회원님 회원가입을 환영합니다.");


    }


    public void login(Request request) {

        //==로그인==
        System.out.println("==로그인==");

        //아이디:
        System.out.print("아이디: ");
        String loginId = sc.nextLine().trim();

        //배열에 지금 로그인 하고자 하는 회원의 아이디가 있는지 검사하는 로직이 필요
        //없다면 "존재하지 않는 계정입니다."
        if (!memberService.isExistsByLoginID(loginId)) {
            System.out.println("존재하지 않는 계정입니다.");
            return;
        }
        //비밀번호:
        System.out.print("비밀번호: ");
        String password = sc.nextLine().trim();
        if (!memberService.isCorrectInfo(loginId, password)) {
            System.out.println("아이디 혹은 비밀번호가 정확하지 않습니다.");
            return;
        }

        request.login(loginId);

        System.out.println(loginId + " 님 환영합니다.");
    }

    //로그아웃 로직 구현
    public void logout(Request request) {

        String logonMemberId = request.getLogonMemberId();
        System.out.println("로그아웃 되었습니다." + logonMemberId + "님 안녕히 가세요.");

        request.logout();
    }

    public void detail(Request request){
        String paramKey ="loginId";
        if (Utill.hasParam(request,paramKey)){
            System.out.println(paramKey+"파라미터가 필요합니다.");
            return;
        }

        String loginId= request.getParameterStrValue(paramKey);
        Member findMember= memberService.getMemberByLoginId(loginId);


        if (findMember==null){
            System.out.println("해당 회원은 존재하지않습니다.");
            return;
        }
        System.out.println("=="+loginId+"님의 정보==");
        System.out.println("아이디"+loginId);
        System.out.println("이름"+findMember.getName());
        System.out.println("가입일"+findMember.getRegDate());

    }
}




