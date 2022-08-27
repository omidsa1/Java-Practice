package com.omid.library.repos;

import com.omid.library.models.Member;

import java.util.List;

public interface MemberRepo {

    public void saveOrUpdate(Member member);

    public void delete(int memberId);

    public Member get(int memberId);

    public List<Member> list();
}
