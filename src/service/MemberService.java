package service;

import data.Member;
import infra.Container;
import repsitory.MemberRepository;

import java.util.List;

public class MemberService {
    private MemberRepository memberRepository;
    public MemberService(){
        this.memberRepository = Container.memberRepository;
    }

    public int saveMember(String loginId, String password, String name){
        return memberRepository.saveMember(loginId,password,name);

    }

    public boolean isExistsByLoginID(String loginId) {
        return memberRepository.isExistsByLoginId(loginId);
    }


    public boolean isCorrectInfo(String loginId,String password){
      Member findMember = memberRepository.getMemberByLoginId(loginId);

        if (findMember==null){
            return false;
        }
        if (findMember.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public Member getMemberByLoginId(String loginId){
        return memberRepository.getMemberByLoginId(loginId);
    }


     public List<Member> getMembers(){
        return memberRepository.getmembers();
     }


    public void delete(String loginId) {
        Member findMember= getMemberByLoginId(loginId);
        memberRepository.delete(findMember);

    }
}





