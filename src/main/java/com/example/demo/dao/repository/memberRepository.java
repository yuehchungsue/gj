package com.example.demo.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.vo.dataentity.member;

public interface memberRepository extends JpaRepository<member, Integer> {
	member findById(int id);

	member findByMemberno(String memberno);
	member findByUsername(String username);

	//JPQL
	@Query("select m from member m where m.username=?1 and m.password=?2")
	member queryMember(String username, String password);

	// SQL
	@Query(value = "select * from member where username=?1 and password=?2", nativeQuery = true)
	member queryMember2(String username, String password);
}
