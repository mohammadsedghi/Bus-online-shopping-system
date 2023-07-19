package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.service.Impl.BaseServiceImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Member;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.MemberRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.MemberService;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.FilterCheck;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import java.util.Optional;
import java.util.Set;

import static org.hibernate.query.sqm.tree.SqmNode.log;

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

    @Override
    public boolean validate(Member member) {
        ValidatorFactory factory = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();

        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Member>> violations = validator.validate(member);
        if (violations.size() > 0) {
            for (ConstraintViolation<Member> violation : violations) {
                log.error(violation.getMessage());
            }
            factory.close();
            return false;
        } else
            memberRepository.save(member);
        return true;
    }
}
