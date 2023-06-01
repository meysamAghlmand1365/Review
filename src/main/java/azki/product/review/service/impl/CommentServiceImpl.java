package azki.product.review.service.impl;

import azki.product.review.dao.ICommentDao;
import azki.product.review.dto.request.BasePageableRequestDto;
import azki.product.review.dto.CommentDto;
import azki.product.review.entity.Comment;
import azki.product.review.service.ICommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements ICommentService {
    private final ICommentDao commentDao;

    private final ModelMapper modelMapper;
    @Override
    public List<CommentDto> fetchTopNComment(long productId, int limit){
        return commentDao.fetchTopNComment(productId,limit).stream().map(comment ->modelMapper.map(comment,CommentDto.class) ).collect(Collectors.toList());
    }

    @Override
    public Long countAllConfirmedComment(Long productId){
        return commentDao.countAllByConfirmStatusTrueAndProductIdIs(productId);
    }


    @Override
    public Comment saveComment( CommentDto dto){
        dto.setId(null);
        dto.setConfirmStatus(null);
        return commentDao.saveAndFlush(modelMapper.map(dto, Comment.class));
    }

   /* @Override
    public GenericPageableList<Comment> fetchAllNotCheckedComment(BasePageableRequestDto dto){
        return new GenericPageableList<>(commentDao.findAllByConfirmStatusIsNull(PageRequest.of(dto.getPageNum(), dto.getPageNum()))
                .stream().map(a->modelMapper.map(a,Comment.class)).collect(Collectors.toList()));
    }*/


    @Override
    public Page<CommentDto> fetchComment(Specification<Comment> specification, BasePageableRequestDto dto){

        return commentDao.findAll(Specification.where(specification),dto.getPageSize()>0?PageRequest.of( dto.getPageNum(),dto.getPageSize()):PageRequest.of(0,5)).map(a->modelMapper.map(a,CommentDto.class));
    }
}
