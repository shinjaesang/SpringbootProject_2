package kr.ac.kopo.board.service;

import kr.ac.kopo.board.dto.ReplyDTO;

public interface ReplyService {
    //댓글 등록 기능
    Long register(ReplyDTO replyDTO);
    void modify(ReplyDTO replyDTO);
}
