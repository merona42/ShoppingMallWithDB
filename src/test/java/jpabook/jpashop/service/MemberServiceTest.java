package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;



    @Test
    public void join(){
        //given
        Member member = new Member();
        member.setName("memberA");
        //when
        Long memberId = memberService.join(member);
        Member findMember = memberService.findOne(memberId);
        //then
        Assertions.assertThat(findMember).isEqualTo(member);
    }
    @Test(expected = IllegalStateException.class)
    @DisplayName("중복회원방지 테스트")
    public void duplicateJoinTest(){
        //given
        Member memberA = new Member();
        Member memberB = new Member();
        memberA.setName("member");
        memberB.setName("member");
        //when
        memberService.join(memberA);
        memberService.join(memberB);
        //then
        fail("실패해야 합니다.");
    }
}