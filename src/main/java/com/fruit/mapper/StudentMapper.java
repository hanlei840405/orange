package com.fruit.mapper;

import com.fruit.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by JesseHan on 2016/12/19.
 */
@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student get(Long id);

    @Select("SELECT * FROM student WHERE username = #{username}")
    Student getByUsername(String username);

    @Select("SELECT * FROM student WHERE we_chat = #{weChat}")
    Student getByWeChat(String weChat);

    @Select("SELECT * FROM student WHERE cellphone = #{cellphone}")
    Student getByCellphone(String cellphone);

    @Select("SELECT * FROM student WHERE qq = #{qq}")
    Student getByQq(String qq);

    @Select("SELECT * FROM student WHERE email = #{email}")
    Student getByEmail(String email);

    @Select("SELECT * FROM student WHERE wei_bo = #{weiBo}")
    Student getByWeiBo(String weiBo);

    @Select("SELECT * FROM student WHERE real_name = #{realName}")
    List<Student> findByRealName(String realName);

    @Select("SELECT * FROM student WHERE birthday = #{birthday}")
    List<Student> findByBirthday(String Date);

    @Select("SELECT * FROM student WHERE birthday = #{givenDate}")
    List<Student> findByBirthdayBeforeGivenDate(Date givenDate);

    @Select("SELECT * FROM student WHERE gender = #{gender}")
    List<Student> findByGender(String gender);

    @Select("SELECT * FROM student WHERE province = #{province}")
    List<Student> findByProvince(String province);

    @Select("SELECT * FROM student WHERE city = #{city}")
    List<Student> findByCity(String city);

    @Select("SELECT * FROM student WHERE district = #{district}")
    List<Student> findByDistrict(String district);

    @Select("SELECT * FROM student WHERE school = #{school}")
    List<Student> findBySchool(String school);

    @Select("SELECT * FROM student WHERE grade = #{grade}")
    List<Student> findByGrade(String grade);

    @Select("SELECT * FROM student WHERE status = #{status}")
    List<Student> findByStatus(int status);

    @Insert("INSERT INTO student (id, username, password, nick, real_name, photo, age, gender, birthday, cellphone, " +
            "email, we_chat, wei_bo, qq, province, city, district, address, school, grade, status, created, creator, " +
            "version) VALUE (#{id}, #{username}, #{password}, #{nick}, #{realName}, #{photo}, #{age}, #{gender}, " +
            "#{birthday}, #{cellphone}, #{email}, #{weChat}, #{weiBo}, #{qq}, #{province}, #{city}, #{district}, " +
            "#{address}, #{school}, #{grade}, #{status}, #{created}, #{creator},#{version})")
    int insert(Student student);

    @Update("UPDATE student SET nick=#{nike}, real_name=#{realName}, photo=#{photo}, age=#{age}, gender=#{gender}, " +
            "birthday=#{birthday}, cellphone=#{cellphone}, email=#{email}, we_chat=#{we_chat}, wei_bo=#{wei_bo}, qq=#{qq}," +
            "province=#{province}, city=#{city}, district=#{district}, address=#{address}, school=#{school}, grade=#{grade}," +
            "status=#{status}, modifier=#{modifier}, modified=#{modified}, version=#{version} WHERE id={id} AND version=#{version}")
    int update(Student student);

    @Delete("DELETE FROM student WHERE id=#{id} AND version=#{version}")
    int physicalDelete(Student student);
}
