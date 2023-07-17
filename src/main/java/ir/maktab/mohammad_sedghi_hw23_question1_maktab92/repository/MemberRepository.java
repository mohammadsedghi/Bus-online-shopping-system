package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.repositpry.BaseRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Member;

import java.util.Optional;

public interface MemberRepository extends BaseRepository<Member,Long> {
    Optional<Member> findByUsernameAndPassword(String username, String password);
}
