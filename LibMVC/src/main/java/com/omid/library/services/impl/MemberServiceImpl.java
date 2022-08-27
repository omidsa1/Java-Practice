package com.omid.library.services.impl;

import com.omid.library.models.Member;
import com.omid.library.repos.MemberRepo;
import com.omid.library.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepo memberRepo;


    @Override
    public List<Member> memberList() {
        List<Member> memberList = memberRepo.list();
        return memberList;
    }

    @Override
    public void saveMember(Member model) {
        memberRepo.saveOrUpdate(model);
    }

    @Override
    public void deleteMember(Integer id) {
        memberRepo.delete(id);
    }

    @Override
    public Member editMember(int id) {
        return memberRepo.get(id);
    }
}

