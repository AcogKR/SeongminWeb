package cloud.acog.SeongminWeb.service;

import cloud.acog.SeongminWeb.domain.entity.Board;
import cloud.acog.SeongminWeb.domain.repository.BoardRepository;
import cloud.acog.SeongminWeb.dto.BoardDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service // 이게 서비스를 선언하지 않고서 알아서 사용?
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }

    @Transactional
    public List<BoardDto> getBoardList() {
        List<Board> boardList = boardRepository.findAll(); // 데이터베이스에 존재하는 Board 테이블의 데이터를 모두 가져옴
        List<BoardDto> boardDtoList = new ArrayList<>(); // Dto 로 옮기기 위해 새로 생성

        for(Board board : boardList) {
            BoardDto boardDto = BoardDto.builder()
                    .id(board.getId())
                    .author(board.getAuthor())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .createdDate(board.getCreatedDate())
                    .build();
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }
}
