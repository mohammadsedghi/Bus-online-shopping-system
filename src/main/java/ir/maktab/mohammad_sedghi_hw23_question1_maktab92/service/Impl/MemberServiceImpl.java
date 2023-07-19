package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.service.Impl.BaseServiceImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Member;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.MemberRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.MemberService;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.FilterCheck;

import java.util.Optional;

public class MemberServiceImpl extends BaseServiceImpl<Member,Long, MemberRepository>
        implements MemberService {
    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        super(memberRepository);
        this.memberRepository = memberRepository;
    }

    @Override
    public Member findByUsernameAndPassword(String username, String password) {
        Optional<Member> optionalPerson = memberRepository.findByUsernameAndPassword(username, password);

        optionalPerson.ifPresentOrElse(
                person -> {
                    FilterCheck.member = person;
                },
                () -> {
                    System.out.println("Person not found. Start login again.");
                    FilterCheck.member=null;

                }
        );
        return null;
    }

    @Override
    public Member findByUsername(String username) {
        Optional<Member> optionalPerson = memberRepository.findByUsername(username);

        optionalPerson.ifPresentOrElse(
                person -> {
                    FilterCheck.member = person;
                },
                () -> {
                    System.out.println("Person not found. Start login again.");
                    FilterCheck.member=null;

                }
        );
        return null;
    }
}
