package azki.product.review.service.impl;

import azki.product.review.constant.ErrorMessage;
import azki.product.review.dao.ICommentDao;
import azki.product.review.dto.request.FetchCommentRateRequest;
import azki.product.review.dto.projection.CommentProductView;
import azki.product.review.dto.request.BasePageableRequestDto;
import azki.product.review.dto.CommentDto;
import azki.product.review.entity.Comment;
import azki.product.review.service.ICommentService;
import azki.product.review.util.PageRequestBuilder;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static azki.product.review.constant.StateValue.STATE_CONFIRM;
import static azki.product.review.constant.StateValue.STATE_NOT_CHECKED;

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
        return commentDao.countAllByStatusAndProductId(STATE_CONFIRM,productId);
    }


    @Override
    public Comment saveComment( CommentDto dto){
        dto.setId(null);
        dto.setStatus(STATE_NOT_CHECKED);
        return commentDao.saveAndFlush(modelMapper.map(dto, Comment.class));
    }




    @Override
    public Page<CommentDto> fetchComment(Specification<Comment> specification, BasePageableRequestDto dto){

        return commentDao.findAll(Specification.where(specification),dto.getPageSize()>0?PageRequest.of( dto.getPageNum(),dto.getPageSize()):PageRequest.of(0,5)).map(a->modelMapper.map(a,CommentDto.class));
    }

    @Override
    public Page<CommentProductView> fetchComment(FetchCommentRateRequest request){
        return commentDao.fetchCommentProduct(request.getFromDate()!=null?request.getFromDate().toString():null,
                                  request.getToDate()!=null?request.getToDate().toString():null,
                                  PageRequestBuilder.buildPageRequest(request));
    }



    @Override
    public CommentDto updateComment(Long id, CommentDto commentDto){
        Optional<Comment> comment =commentDao.findById(id);
        if(comment.isPresent()){
            comment.get().setStatus(commentDto.getStatus());
            return modelMapper.map(commentDao.saveAndFlush(comment.get()),CommentDto.class);
        }else{
          throw new EntityNotFoundException(ErrorMessage.ID+id.toString()+ ErrorMessage.NOT_FOUND);
        }
    }
}
