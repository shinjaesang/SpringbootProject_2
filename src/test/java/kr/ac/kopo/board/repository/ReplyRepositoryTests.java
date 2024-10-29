package kr.ac.kopo.board.repository;


import kr.ac.kopo.board.entity.Board;
import kr.ac.kopo.board.entity.Member;
import kr.ac.kopo.board.entity.Reply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTests {
    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void testListByBoard(){
        List<Reply> replyList = replyRepository.getRepliesByBoardOrderByRno(Board.builder().bno(100L).build());
        replyList.forEach(reply -> System.out.println(reply));
    }

    @Test //Board 객체를 100 추가하는 테스트 코드
    public void insertBoards(){
        IntStream.rangeClosed(1, 300).forEach(i -> {
            long bno = (long)(Math.random() * 100 + 1); //1~100 사이의 임의의 long 형의 정수 값

            Board board = Board.builder()
                    .bno(bno)
                    .build();

            Reply reply = Reply.builder()
                    .text("Reply" + i)
                    .board(board)
                    .replyer("guest")
                    .build();

            replyRepository.save(reply);//reply엔티티 300개 저장됨
        });
    }
}
