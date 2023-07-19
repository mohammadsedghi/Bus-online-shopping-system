package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Member;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {
    MemberServiceImpl memberService;
    @InjectMocks
    Member member;
    @BeforeEach
    void setUp() {
        memberService=Mockito.mock(MemberServiceImpl.class);
       member = Mockito.mock(Member.class);
    }

    @Test
    void findByUsernameAndPassword() {
        Mockito.when(memberService.findByUsernameAndPassword("","")).thenReturn(member);
        Assertions.assertEquals(member, memberService.findByUsernameAndPassword("",""));
    }

    @Test
    void findByUsername() {
        Mockito.when(memberService.findByUsername("")).thenReturn(member);
        Assertions.assertEquals(member, memberService.findByUsername(""));

    }
}