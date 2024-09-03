package kr.ac.kopo.board.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer")//나중에 foreign key설정할 때 잘 됨
public class Board extends BaseEntity{

    @Id //기본키 설정(primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY)//1씩 자동 증가(auto-increment)
    private Long bno;
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)//다 대 일 관계에 외래키 설정을 위함
    private Member writer;//Foreign key 설정(참조무결성 유지)
}
