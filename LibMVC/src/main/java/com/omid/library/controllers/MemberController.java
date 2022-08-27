package com.omid.library.controllers;

import com.omid.library.models.Member;
import com.omid.library.repos.MemberRepo;
import com.omid.library.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller("/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/list")
    public ModelAndView memberList(ModelAndView model){
        List<Member> memberList = memberService.memberList();
        model.addObject("memberList",memberList);
        model.setViewName("MemberList");
        return model;
    }

    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public ModelAndView newMember(ModelAndView model){
        Member newMember = new Member();
        model.addObject("member",newMember);
        model.setViewName("MemberForm");
        return model;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ModelAndView saveMember(@ModelAttribute Member member){
        memberService.saveMember(member);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteMember(HttpServletRequest request) {
        int memberId = Integer.parseInt(request.getParameter("id"));
        memberService.deleteMember(memberId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editBook(HttpServletRequest request) {
        int memberId = Integer.parseInt(request.getParameter("id"));
        Member member = memberService.editMember(memberId);
        ModelAndView model = new ModelAndView("MemberForm");
        model.addObject("member", member);
        return model;
    }
}


















