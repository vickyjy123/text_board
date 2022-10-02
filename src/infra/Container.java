package infra;


import controller.ArticleController;
import controller.MemberController;
import controller.SystemController;
import repsitory.ArticleRepository;
import repsitory.MemberRepository;
import service.ArticleService;
import service.MemberService;

import java.util.Scanner;

    public class Container {
    public static Scanner sc;

    public static Session session;


    public static MemberRepository memberRepository;

    public  static MemberService memberService;


    public static SystemController systemcontroller;

    public  static MemberController memberController;



    public static ArticleRepository articleRepository;
    public static ArticleService articleService;
    public static ArticleController articleController;




    static {
        sc=new Scanner(System.in);
        session =new Session();
        systemcontroller = new SystemController();
        memberRepository = new MemberRepository();
        memberService = new MemberService();
        memberController =new MemberController();


        articleRepository= new ArticleRepository();
        articleService = new ArticleService();
        articleController =new ArticleController();
    }





}
