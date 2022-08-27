package com.omid.library.services;

import com.omid.library.models.Book;
import com.omid.library.models.Member;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MemberService {


    public List<Member> memberList();

    public void saveMember(Member model);

    public void deleteMember(Integer id);

    public Member editMember(int model);

}
