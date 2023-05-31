package azki.product.review.service.impl;

import azki.product.review.dao.ICommentDao;
import azki.product.review.dto.CommentDto;
import azki.product.review.entity.Comment;
import azki.product.review.service.ICommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements ICommentService {
    private final ICommentDao commentDao;

    private final ModelMapper modelMapper;
    @Override
    public List<CommentDto> fetchTopNComment(long productId, int count){
        return commentDao.fetchTopNComment(productId,count).stream().map(comment ->modelMapper.map(comment,CommentDto.class) ).collect(Collectors.toList());
    }

    @Override
    public Long countAllConfirmedComment(){
        return commentDao.countAllByConfirmStatusTrue();
    }


    @Override
    public Comment saveComment( CommentDto dto){
        dto.setId(null);
        dto.setConfirmStatus(null);
        return commentDao.saveAndFlush(modelMapper.map(dto, Comment.class));
    }
}
