package sk.sb.training_assignment.search.mapper;

import com.scheidtbachmann.ps.search.searchextension.dto.SearchResult;
import com.scheidtbachmann.ps.search.searchextension.mapper.SearchResultMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sk.sb.training_assignment.entities.User;

@Mapper
public interface UserMapper extends SearchResultMapper<User> {
    @Override
    @Mapping(target = "name", expression = "java(value.getName() + \" \" + value.getSurname())")
    @Mapping(target = "resultLocalId", source = "value.id")
    SearchResult toSearchResultDto(User value);
}
