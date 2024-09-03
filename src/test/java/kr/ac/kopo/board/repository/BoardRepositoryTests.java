package kr.ac.kopo.board.repository;


import kr.ac.kopo.board.entity.Board;
import kr.ac.kopo.board.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTests {
    @Autowired
    private BoardRepository boardRepository;

    @Test //Board 객체를 100 추가하는 테스트 코드
    public void insertBoards(){
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Member member = Member.builder()
                    .email("user" + i + "@kopo.ac.kr")
                    .build();

            Board board = Board.builder()
                    .title("Title " + i)
                    .content("Content" + i)
                    .writer(member)
                    .build();

            boardRepository.save(board);
        });
    }
    @Transactional
    @Test
    public void testRead(){
        Optional<Board> result = boardRepository.findById(5L);

        Board board = result.get();

        System.out.println(board);
        System.out.println(board.getWriter());
    }

    @Test
    public void testReadWithWriter(){
        Object result = boardRepository.getBoardWithWriter(10L);
        Object[] arr = (Object[])result;
        System.out.println(result);
    }

    @Test
    public void testReadWithReply(){
        List<Object[]> result = boardRepository.getBoardWithReply(77L);
        for (Object[] arr : result){
            System.out.println(Arrays.toString(arr));
        }
//        Object[] arr = (Object[])result;
//        System.out.println(Arrays.toString(arr));
    }
}
