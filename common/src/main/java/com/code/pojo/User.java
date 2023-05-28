package com.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaoshuai
 * @since 2023-05-12
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable,Cloneable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private String name;

    private String account;

    private String password;

    public User(String name, String account, String password) {
        this.name = name;
        this.account = account;
        this.password = password;
    }

    public static UserBuilder builder(){   //通过builder方法直接获取建造者
        return new UserBuilder();
    }

    public static class UserBuilder{

         String name;
         String account;
         String password;
         public UserBuilder name(String name){
             this.name = name;
             return this;
         }

        public UserBuilder account(String account){
            this.account = account;
            return this;
        }
        public UserBuilder password(String password){
            this.password = password;
            return this;
        }

        public User build(){
             return new User(name,account,password);
        }

    }

    @Override
    public Object clone() throws CloneNotSupportedException {   //提升clone方法的访问权限
        return super.clone();
    }



}
