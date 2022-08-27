package com.omid.library.repos.impl;

import com.omid.library.models.Member;
import com.omid.library.repos.MemberRepo;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MemberRepoImpl implements MemberRepo {

    private JdbcTemplate jdbcTemplate;

    public MemberRepoImpl(DataSource dataSource) { jdbcTemplate = new JdbcTemplate(dataSource); }

    @Override
    public void saveOrUpdate(Member member) {
        String sql = "INSERT INTO member ( member_firstName, membber_lastname) VALUES (?, ?, ?)";

        jdbcTemplate.update(sql,member.getFirstName(),member.getLastname());
    }

    @Override
    public void delete(int memberId) {
        String sql="DELETE FROM member WHERE id=?";
        jdbcTemplate.update(sql,memberId);
    }

    @Override
    public Member get(int memberId) {
        String sql = "SELECT * FROM member WHERE id=" + memberId;
        return jdbcTemplate.query(sql, rs -> {
            if (rs.next()) {
                Member member = new Member();
                member.setFirstName(rs.getString("member_firstName"));
                member.setLastname(rs.getString("member_lastName"));return member;
            }

            return null;
        });
    }

    @Override
    public List<Member> list() {
        String sql = "SELECT * FROM member";

        List<Member> memberList = jdbcTemplate.query(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                Member member = new Member();
                member.setFirstName(rs.getString("member_firstName"));
                member.setLastname(rs.getString("member_lastname"));
                return member;
            }
        });
        return memberList;
    }
}
