package com.gareth.userappws.shared.dao;

import com.gareth.userappws.entity.UserEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao extends JdbcDaoSupport {


    public UserEntity getUserById(int id) {
        String sql = "select * from users where id = ?";
        return this.getJdbcTemplate().queryForObject(sql, new Object[] {id}, new UserMapper());
    }

    public List<UserEntity> getAllUsers() {
        String sql = "select * from users";
        return this.getJdbcTemplate().query(sql, new UserMapper());
    }

    public int getUserCount() {
        String sql = "select count(*) from users";
        return this.getJdbcTemplate().queryForObject(sql, Integer.class);
    }

    public void createUser(UserEntity user) {
        String sql = "insert into users (id, email, email_verification_status, email_verification_token, encrypted_password, first_name, last_name, user_id) values (?, ?, ?, ?, ?, ?, ?, ?)";
        this.getJdbcTemplate().update(sql, new Object[] {user.getId(), user.getEmail(), user.getEmailVerificationStatus(), user.getEmailVerificationToken(), user.getEncryptedPassword(), user.getFirstName(), user.getLastName(), user.getId()});
    }

    private static final class UserMapper implements RowMapper<UserEntity> {

        public UserEntity mapRow(ResultSet resultSet, int i) throws SQLException {
            UserEntity user = new UserEntity();
            user.setEmail(resultSet.getString("email"));
            user.setEmailVerificationStatus(resultSet.getBoolean("email_verification_status"));
            user.setEmailVerificationToken(resultSet.getString("email_verification_token"));
            user.setEncryptedPassword(resultSet.getString("encrypted_password"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setUserId(resultSet.getString("user_id"));
            user.setId(resultSet.getLong("id"));
            return user;
        }
    }
}
