package com.agent.mapper;

import java.util.List;

//import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.agent.domain.*;

//@Mapper
@Repository
public interface  DemoMapper {
	List<DemoVo> getUserList()throws Exception ;
}
