package com.toy.traveldiary.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	MemberRepository memberRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testMember() throws Exception {
		Member member = new Member();
		member.setEmail("test01@mail.com");
		member.setPassword("test01");
		member.setNickname("test01");
		member.setEnabled(true);

		//when
		Long savedId = memberRepository.save(member);
		Member findMember = memberRepository.find(savedId);

		//then
		assertEquals(findMember.getId(), member.getId());
		assertEquals(findMember.getEmail(), member.getEmail());
		assertEquals(findMember, member);
	}
}
