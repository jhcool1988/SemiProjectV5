package jhcool1988.spring.mvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import siestageek.spring.mvc.vo.BoardVO;

import java.util.ArrayList;

@Repository("bdao")
public class BoardDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BoardDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 게시판 데이터를 board테이블에 저장
    public boolean insertBoard( BoardVO b ) {
        // sql 정의
        String sql = "insert into board (title,userid,contents) values (?,?,?)";

        // 매개변수 정의
        Object[] params = new Object[] {
             b.getTitle(), b.getUserid(), b.getContents()
        };

        // 매개변수 타입 정의 - 생략 ^^;

        // 샐행
        boolean isInsert = false;
        if (jdbcTemplate.update(sql, params) > 0)
            isInsert = true;

        return isInsert;
    }

    // 게시판데이터 중에서 글번호/제목/작성자/작성일/추천/조회만
    // 골라서 동적배열에 담아 반환함
    public ArrayList<BoardVO> selectBoard() {
        return null;
    }

    // 글번호로 선택한 게시물에 대해 모든 컬럼을 조회해서
    // BoardVO 객체에 저장하고 반환함
    public BoardVO selectOneBoard(String bno) {
        return null;
    }

}
