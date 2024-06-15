package generator.mapper;

import generator.TEmp;

/**
* @author Administrator
* @description 针对表【t_emp】的数据库操作Mapper
* @createDate 2024-06-11 16:16:32
* @Entity generator.TEmp
*/
public interface TEmpMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TEmp record);

    int insertSelective(TEmp record);

    TEmp selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TEmp record);

    int updateByPrimaryKey(TEmp record);

}
