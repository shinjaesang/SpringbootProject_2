package kr.ac.kopo.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing//이 어노테이션을 사용하면 엔티티(Entity)에서 생성 시간이나 수정 시간 등을 자동으로 관리할 수 있습니다.
public class BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

}
